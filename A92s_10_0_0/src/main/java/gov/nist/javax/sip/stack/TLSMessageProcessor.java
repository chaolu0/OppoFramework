package gov.nist.javax.sip.stack;

import gov.nist.core.HostPort;
import gov.nist.core.StackLogger;
import gov.nist.javax.sip.SipStackImpl;
import gov.nist.javax.sip.address.ParameterNames;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.sip.ListeningPoint;

public class TLSMessageProcessor extends MessageProcessor {
    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;
    private boolean isRunning;
    protected int nConnections;
    private ServerSocket sock;
    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
    protected int useCount = 0;

    protected TLSMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, ParameterNames.TLS, sipStack);
        this.sipStack = sipStack;
        this.tlsMessageChannels = new Hashtable<>();
        this.incomingTlsMessageChannels = new ArrayList<>();
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TLSMessageProcessorThread");
        thread.setPriority(10);
        thread.setDaemon(true);
        this.sock = this.sipStack.getNetworkLayer().createSSLServerSocket(getPort(), 0, getIpAddress());
        ((SSLServerSocket) this.sock).setNeedClientAuth(false);
        ((SSLServerSocket) this.sock).setUseClientMode(false);
        ((SSLServerSocket) this.sock).setWantClientAuth(true);
        ((SSLServerSocket) this.sock).setEnabledCipherSuites(((SipStackImpl) this.sipStack).getEnabledCipherSuites());
        ((SSLServerSocket) this.sock).setWantClientAuth(true);
        this.isRunning = true;
        thread.start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r1 = r5.sock.accept();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        if (r5.sipStack.isLoggingEnabled() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        r5.sipStack.getStackLogger().logDebug("Accepting new connection!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r5.incomingTlsMessageChannels.add(new gov.nist.javax.sip.stack.TLSMessageChannel(r1, r5.sipStack, r5));
     */
    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public void run() {
        while (this.isRunning) {
            try {
                synchronized (this) {
                    while (this.sipStack.maxConnections != -1 && this.nConnections >= this.sipStack.maxConnections) {
                        try {
                            wait();
                            if (!this.isRunning) {
                                return;
                            }
                        } catch (InterruptedException e) {
                        }
                    }
                    this.nConnections++;
                }
            } catch (SocketException ex) {
                if (this.isRunning) {
                    this.sipStack.getStackLogger().logError("Fatal - SocketException occured while Accepting connection", ex);
                    this.isRunning = false;
                    return;
                }
            } catch (SSLException ex2) {
                this.isRunning = false;
                this.sipStack.getStackLogger().logError("Fatal - SSSLException occured while Accepting connection", ex2);
                return;
            } catch (IOException ex3) {
                this.sipStack.getStackLogger().logError("Problem Accepting Connection", ex3);
            } catch (Exception ex4) {
                this.sipStack.getStackLogger().logError("Unexpected Exception!", ex4);
            }
        }
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public synchronized void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            try {
                this.sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (TLSMessageChannel next : this.tlsMessageChannels.values()) {
                next.close();
            }
            Iterator incomingMCIterator = this.incomingTlsMessageChannels.iterator();
            while (incomingMCIterator.hasNext()) {
                incomingMCIterator.next().close();
            }
            notify();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void remove(TLSMessageChannel tlsMessageChannel) {
        String key = tlsMessageChannel.getKey();
        if (this.sipStack.isLoggingEnabled()) {
            StackLogger stackLogger = this.sipStack.getStackLogger();
            stackLogger.logDebug(Thread.currentThread() + " removing " + key);
        }
        if (this.tlsMessageChannels.get(key) == tlsMessageChannel) {
            this.tlsMessageChannels.remove(key);
        }
        this.incomingTlsMessageChannels.remove(tlsMessageChannel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
        return r1;
     */
    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        String key = MessageChannel.getKey(targetHostPort, ListeningPoint.TLS);
        if (this.tlsMessageChannels.get(key) != null) {
            return this.tlsMessageChannels.get(key);
        }
        TLSMessageChannel retval = new TLSMessageChannel(targetHostPort.getInetAddress(), targetHostPort.getPort(), this.sipStack, this);
        this.tlsMessageChannels.put(key, retval);
        retval.isCached = true;
        if (this.sipStack.isLoggingEnabled()) {
            StackLogger stackLogger = this.sipStack.getStackLogger();
            stackLogger.logDebug("key " + key);
            StackLogger stackLogger2 = this.sipStack.getStackLogger();
            stackLogger2.logDebug("Creating " + retval);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        String key = messageChannel.getKey();
        TLSMessageChannel currentChannel = this.tlsMessageChannels.get(key);
        if (currentChannel != null) {
            if (this.sipStack.isLoggingEnabled()) {
                StackLogger stackLogger = this.sipStack.getStackLogger();
                stackLogger.logDebug("Closing " + key);
            }
            currentChannel.close();
        }
        if (this.sipStack.isLoggingEnabled()) {
            StackLogger stackLogger2 = this.sipStack.getStackLogger();
            stackLogger2.logDebug("Caching " + key);
        }
        this.tlsMessageChannels.put(key, messageChannel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        return r1;
     */
    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        try {
            String key = MessageChannel.getKey(host, port, ListeningPoint.TLS);
            if (this.tlsMessageChannels.get(key) != null) {
                return this.tlsMessageChannels.get(key);
            }
            TLSMessageChannel retval = new TLSMessageChannel(host, port, this.sipStack, this);
            this.tlsMessageChannels.put(key, retval);
            retval.isCached = true;
            if (this.sipStack.isLoggingEnabled()) {
                StackLogger stackLogger = this.sipStack.getStackLogger();
                stackLogger.logDebug("key " + key);
                StackLogger stackLogger2 = this.sipStack.getStackLogger();
                stackLogger2.logDebug("Creating " + retval);
            }
        } catch (UnknownHostException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public int getMaximumMessageSize() {
        return Integer.MAX_VALUE;
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public boolean inUse() {
        return this.useCount != 0;
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public int getDefaultTargetPort() {
        return 5061;
    }

    @Override // gov.nist.javax.sip.stack.MessageProcessor
    public boolean isSecure() {
        return true;
    }
}
