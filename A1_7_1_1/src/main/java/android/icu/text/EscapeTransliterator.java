package android.icu.text;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:546)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:221)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:121)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
class EscapeTransliterator extends Transliterator {
    private boolean grokSupplementals;
    private int minDigits;
    private String prefix;
    private int radix;
    private String suffix;
    private EscapeTransliterator supplementalHandler;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: android.icu.text.EscapeTransliterator.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, boolean, android.icu.text.EscapeTransliterator):void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 5 more
        */
    EscapeTransliterator(java.lang.String r1, java.lang.String r2, java.lang.String r3, int r4, int r5, boolean r6, android.icu.text.EscapeTransliterator r7) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: android.icu.text.EscapeTransliterator.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, boolean, android.icu.text.EscapeTransliterator):void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.icu.text.EscapeTransliterator.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, boolean, android.icu.text.EscapeTransliterator):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: android.icu.text.EscapeTransliterator.register():void, dex: 
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
    static void register() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: android.icu.text.EscapeTransliterator.register():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.icu.text.EscapeTransliterator.register():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: android.icu.text.EscapeTransliterator.addSourceTargetSet(android.icu.text.UnicodeSet, android.icu.text.UnicodeSet, android.icu.text.UnicodeSet):void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 5 more
        */
    public void addSourceTargetSet(android.icu.text.UnicodeSet r1, android.icu.text.UnicodeSet r2, android.icu.text.UnicodeSet r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: android.icu.text.EscapeTransliterator.addSourceTargetSet(android.icu.text.UnicodeSet, android.icu.text.UnicodeSet, android.icu.text.UnicodeSet):void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.icu.text.EscapeTransliterator.addSourceTargetSet(android.icu.text.UnicodeSet, android.icu.text.UnicodeSet, android.icu.text.UnicodeSet):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void, dex:  in method: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void, dex: 
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:51)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:66)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:48)
        	... 6 more
        */
    protected void handleTransliterate(android.icu.text.Replaceable r1, android.icu.text.Transliterator.Position r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: null in method: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void, dex:  in method: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.icu.text.EscapeTransliterator.handleTransliterate(android.icu.text.Replaceable, android.icu.text.Transliterator$Position, boolean):void");
    }
}
