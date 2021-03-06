package android.net;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public abstract class NetworkAgent extends Handler {
    private static final int BASE = 528384;
    private static final long BW_REFRESH_MIN_WIN_MS = 500;
    public static final int CMD_PREVENT_AUTOMATIC_RECONNECT = 528399;
    public static final int CMD_REPORT_NETWORK_STATUS = 528391;
    public static final int CMD_REQUEST_BANDWIDTH_UPDATE = 528394;
    public static final int CMD_SAVE_ACCEPT_UNVALIDATED = 528393;
    public static final int CMD_SET_SIGNAL_STRENGTH_THRESHOLDS = 528398;
    public static final int CMD_START_PACKET_KEEPALIVE = 528395;
    public static final int CMD_STOP_PACKET_KEEPALIVE = 528396;
    public static final int CMD_SUSPECT_BAD = 528384;
    private static final boolean DBG = true;
    public static final int EVENT_NETWORK_CAPABILITIES_CHANGED = 528386;
    public static final int EVENT_NETWORK_INFO_CHANGED = 528385;
    public static final int EVENT_NETWORK_PROPERTIES_CHANGED = 528387;
    public static final int EVENT_NETWORK_SCORE_CHANGED = 528388;
    public static final int EVENT_PACKET_KEEPALIVE = 528397;
    public static final int EVENT_SET_EXPLICITLY_SELECTED = 528392;
    public static final int EVENT_UID_RANGES_ADDED = 528389;
    public static final int EVENT_UID_RANGES_REMOVED = 528390;
    public static final int INVALID_NETWORK = 2;
    public static String REDIRECT_URL_KEY = null;
    public static final int VALID_NETWORK = 1;
    private static final boolean VDBG = true;
    public static final int WIFI_BASE_SCORE = 5;
    public static final int WIFI_BASE_SCORE_VALID = 79;
    private final String LOG_TAG;
    private volatile AsyncChannel mAsyncChannel;
    private final Context mContext;
    private volatile long mLastBwRefreshTime;
    private AtomicBoolean mPollLcePending;
    private boolean mPollLceScheduled;
    private final ArrayList<Message> mPreConnectedQueue;
    public final int netId;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: android.net.NetworkAgent.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: android.net.NetworkAgent.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.NetworkAgent.<clinit>():void");
    }

    protected abstract void unwanted();

    public NetworkAgent(Looper looper, Context context, String logTag, NetworkInfo ni, NetworkCapabilities nc, LinkProperties lp, int score) {
        this(looper, context, logTag, ni, nc, lp, score, null);
    }

    public NetworkAgent(Looper looper, Context context, String logTag, NetworkInfo ni, NetworkCapabilities nc, LinkProperties lp, int score, NetworkMisc misc) {
        super(looper);
        this.mPreConnectedQueue = new ArrayList();
        this.mLastBwRefreshTime = 0;
        this.mPollLceScheduled = false;
        this.mPollLcePending = new AtomicBoolean(false);
        this.LOG_TAG = logTag;
        this.mContext = context;
        if (ni == null || nc == null || lp == null) {
            throw new IllegalArgumentException();
        }
        log("Registering NetworkAgent");
        this.netId = ((ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE)).registerNetworkAgent(new Messenger((Handler) this), new NetworkInfo(ni), new LinkProperties(lp), new NetworkCapabilities(nc), score, misc);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 69633:
                if (this.mAsyncChannel != null) {
                    log("Received new connection while already connected!");
                    return;
                }
                log("NetworkAgent fully connected");
                AsyncChannel ac = new AsyncChannel();
                ac.connected(null, this, msg.replyTo);
                ac.replyToMessage(msg, 69634, 0);
                synchronized (this.mPreConnectedQueue) {
                    this.mAsyncChannel = ac;
                    for (Message m : this.mPreConnectedQueue) {
                        ac.sendMessage(m);
                    }
                    this.mPreConnectedQueue.clear();
                }
                return;
            case 69635:
                log("CMD_CHANNEL_DISCONNECT");
                if (this.mAsyncChannel != null) {
                    this.mAsyncChannel.disconnect();
                    return;
                }
                return;
            case 69636:
                log("NetworkAgent channel lost");
                unwanted();
                synchronized (this.mPreConnectedQueue) {
                }
                return;
            case 528384:
                log("Unhandled Message " + msg);
                return;
            case CMD_REPORT_NETWORK_STATUS /*528391*/:
                String redirectUrl = ((Bundle) msg.obj).getString(REDIRECT_URL_KEY);
                log("CMD_REPORT_NETWORK_STATUS(" + (msg.arg1 == 1 ? "VALID, " : "INVALID, ") + redirectUrl);
                networkStatus(msg.arg1, redirectUrl);
                return;
            case CMD_SAVE_ACCEPT_UNVALIDATED /*528393*/:
                saveAcceptUnvalidated(msg.arg1 != 0);
                return;
            case CMD_REQUEST_BANDWIDTH_UPDATE /*528394*/:
                long currentTimeMs = System.currentTimeMillis();
                log("CMD_REQUEST_BANDWIDTH_UPDATE request received.");
                if (currentTimeMs >= this.mLastBwRefreshTime + BW_REFRESH_MIN_WIN_MS) {
                    this.mPollLceScheduled = false;
                    if (!this.mPollLcePending.getAndSet(true)) {
                        pollLceData();
                        return;
                    }
                    return;
                } else if (!this.mPollLceScheduled) {
                    this.mPollLceScheduled = sendEmptyMessageDelayed(CMD_REQUEST_BANDWIDTH_UPDATE, ((this.mLastBwRefreshTime + BW_REFRESH_MIN_WIN_MS) - currentTimeMs) + 1);
                    return;
                } else {
                    return;
                }
            case CMD_START_PACKET_KEEPALIVE /*528395*/:
                startPacketKeepalive(msg);
                return;
            case CMD_STOP_PACKET_KEEPALIVE /*528396*/:
                stopPacketKeepalive(msg);
                return;
            case CMD_SET_SIGNAL_STRENGTH_THRESHOLDS /*528398*/:
                ArrayList<Integer> thresholds = ((Bundle) msg.obj).getIntegerArrayList("thresholds");
                int[] intThresholds = new int[(thresholds != null ? thresholds.size() : 0)];
                for (int i = 0; i < intThresholds.length; i++) {
                    intThresholds[i] = ((Integer) thresholds.get(i)).intValue();
                }
                setSignalStrengthThresholds(intThresholds);
                return;
            case CMD_PREVENT_AUTOMATIC_RECONNECT /*528399*/:
                preventAutomaticReconnect();
                return;
            default:
                return;
        }
    }

    private void queueOrSendMessage(int what, Object obj) {
        queueOrSendMessage(what, 0, 0, obj);
    }

    private void queueOrSendMessage(int what, int arg1, int arg2) {
        queueOrSendMessage(what, arg1, arg2, null);
    }

    private void queueOrSendMessage(int what, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        queueOrSendMessage(msg);
    }

    private void queueOrSendMessage(Message msg) {
        synchronized (this.mPreConnectedQueue) {
            if (this.mAsyncChannel != null) {
                this.mAsyncChannel.sendMessage(msg);
            } else {
                this.mPreConnectedQueue.add(msg);
            }
        }
    }

    public void sendLinkProperties(LinkProperties linkProperties) {
        queueOrSendMessage(EVENT_NETWORK_PROPERTIES_CHANGED, new LinkProperties(linkProperties));
    }

    public void sendNetworkInfo(NetworkInfo networkInfo) {
        queueOrSendMessage(EVENT_NETWORK_INFO_CHANGED, new NetworkInfo(networkInfo));
    }

    public void sendNetworkCapabilities(NetworkCapabilities networkCapabilities) {
        this.mPollLcePending.set(false);
        this.mLastBwRefreshTime = System.currentTimeMillis();
        queueOrSendMessage(EVENT_NETWORK_CAPABILITIES_CHANGED, new NetworkCapabilities(networkCapabilities));
    }

    public void sendNetworkScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score must be >= 0");
        }
        queueOrSendMessage(EVENT_NETWORK_SCORE_CHANGED, new Integer(score));
    }

    public void addUidRanges(UidRange[] ranges) {
        queueOrSendMessage(EVENT_UID_RANGES_ADDED, ranges);
    }

    public void removeUidRanges(UidRange[] ranges) {
        queueOrSendMessage(EVENT_UID_RANGES_REMOVED, ranges);
    }

    public void explicitlySelected(boolean acceptUnvalidated) {
        queueOrSendMessage(EVENT_SET_EXPLICITLY_SELECTED, Boolean.valueOf(acceptUnvalidated));
    }

    protected void pollLceData() {
    }

    protected void networkStatus(int status, String redirectUrl) {
    }

    protected void saveAcceptUnvalidated(boolean accept) {
    }

    protected void startPacketKeepalive(Message msg) {
        onPacketKeepaliveEvent(msg.arg1, -30);
    }

    protected void stopPacketKeepalive(Message msg) {
        onPacketKeepaliveEvent(msg.arg1, -30);
    }

    public void onPacketKeepaliveEvent(int slot, int reason) {
        queueOrSendMessage(EVENT_PACKET_KEEPALIVE, slot, reason);
    }

    protected void setSignalStrengthThresholds(int[] thresholds) {
    }

    protected void preventAutomaticReconnect() {
    }

    protected void log(String s) {
        Log.d(this.LOG_TAG, "NetworkAgent: " + s);
    }
}
