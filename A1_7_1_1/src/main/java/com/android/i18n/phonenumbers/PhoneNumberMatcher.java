package com.android.i18n.phonenumbers;

import com.android.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.android.i18n.phonenumbers.PhoneNumberUtil.MatchType;
import com.android.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import gov.nist.core.Separators;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    private static final Pattern[] INNER_MATCHES = null;
    private static final Pattern LEAD_CLASS = null;
    private static final Pattern MATCHING_BRACKETS = null;
    private static final Pattern PATTERN = null;
    private static final Pattern PUB_PAGES = null;
    private static final Pattern SLASH_SEPARATED_DATES = null;
    private static final Pattern TIME_STAMPS = null;
    private static final Pattern TIME_STAMPS_SUFFIX = null;
    private PhoneNumberMatch lastMatch;
    private final Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private int searchIndex;
    private State state;
    private final CharSequence text;

    interface NumberGroupingChecker {
        boolean checkGroups(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder stringBuilder, String[] strArr);
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.util.ArrayList.forEach(ArrayList.java:1251)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private enum State {
        ;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.android.i18n.phonenumbers.PhoneNumberMatcher.State.<clinit>():void, dex: 
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:254)
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
            	... 6 more
            */
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.android.i18n.phonenumbers.PhoneNumberMatcher.State.<clinit>():void, dex: 
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.i18n.phonenumbers.PhoneNumberMatcher.State.<clinit>():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: com.android.i18n.phonenumbers.PhoneNumberMatcher.<clinit>():void, dex: 
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: com.android.i18n.phonenumbers.PhoneNumberMatcher.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.i18n.phonenumbers.PhoneNumberMatcher.<clinit>():void");
    }

    private static String limit(int lower, int upper) {
        if (lower >= 0 && upper > 0 && upper >= lower) {
            return "{" + lower + Separators.COMMA + upper + "}";
        }
        throw new IllegalArgumentException();
    }

    PhoneNumberMatcher(PhoneNumberUtil util, CharSequence text, String country, Leniency leniency, long maxTries) {
        this.state = State.NOT_READY;
        this.lastMatch = null;
        this.searchIndex = 0;
        if (util == null || leniency == null) {
            throw new NullPointerException();
        } else if (maxTries < 0) {
            throw new IllegalArgumentException();
        } else {
            this.phoneUtil = util;
            if (text == null) {
                text = "";
            }
            this.text = text;
            this.preferredRegion = country;
            this.leniency = leniency;
            this.maxTries = maxTries;
        }
    }

    private PhoneNumberMatch find(int index) {
        Matcher matcher = PATTERN.matcher(this.text);
        while (this.maxTries > 0 && matcher.find(index)) {
            int start = matcher.start();
            CharSequence candidate = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, this.text.subSequence(start, matcher.end()));
            PhoneNumberMatch match = extractMatch(candidate, start);
            if (match != null) {
                return match;
            }
            index = start + candidate.length();
            this.maxTries--;
        }
        return null;
    }

    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence candidate) {
        Matcher trailingCharsMatcher = pattern.matcher(candidate);
        if (trailingCharsMatcher.find()) {
            return candidate.subSequence(0, trailingCharsMatcher.start());
        }
        return candidate;
    }

    static boolean isLatinLetter(char letter) {
        if (!Character.isLetter(letter) && Character.getType(letter) != 6) {
            return false;
        }
        UnicodeBlock block = UnicodeBlock.of(letter);
        boolean equals = (block.equals(UnicodeBlock.BASIC_LATIN) || block.equals(UnicodeBlock.LATIN_1_SUPPLEMENT) || block.equals(UnicodeBlock.LATIN_EXTENDED_A) || block.equals(UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) || block.equals(UnicodeBlock.LATIN_EXTENDED_B)) ? true : block.equals(UnicodeBlock.COMBINING_DIACRITICAL_MARKS);
        return equals;
    }

    private static boolean isInvalidPunctuationSymbol(char character) {
        return character == '%' || Character.getType(character) == 26;
    }

    private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
        if (SLASH_SEPARATED_DATES.matcher(candidate).find()) {
            return null;
        }
        if (TIME_STAMPS.matcher(candidate).find()) {
            if (TIME_STAMPS_SUFFIX.matcher(this.text.toString().substring(candidate.length() + offset)).lookingAt()) {
                return null;
            }
        }
        String rawString = candidate.toString();
        PhoneNumberMatch match = parseAndVerify(rawString, offset);
        if (match != null) {
            return match;
        }
        return extractInnerMatch(rawString, offset);
    }

    private PhoneNumberMatch extractInnerMatch(String candidate, int offset) {
        for (Pattern possibleInnerMatch : INNER_MATCHES) {
            Matcher groupMatcher = possibleInnerMatch.matcher(candidate);
            boolean isFirstMatch = true;
            while (groupMatcher.find() && this.maxTries > 0) {
                PhoneNumberMatch match;
                if (isFirstMatch) {
                    match = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, candidate.substring(0, groupMatcher.start())).toString(), offset);
                    if (match != null) {
                        return match;
                    }
                    this.maxTries--;
                    isFirstMatch = false;
                }
                match = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, groupMatcher.group(1)).toString(), groupMatcher.start(1) + offset);
                if (match != null) {
                    return match;
                }
                this.maxTries--;
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:32:0x00a0, code:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PhoneNumberMatch parseAndVerify(String candidate, int offset) {
        try {
            if (!MATCHING_BRACKETS.matcher(candidate).matches() || PUB_PAGES.matcher(candidate).find()) {
                return null;
            }
            if (this.leniency.compareTo(Leniency.VALID) >= 0) {
                if (offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt()) {
                    char previousChar = this.text.charAt(offset - 1);
                    if (isInvalidPunctuationSymbol(previousChar) || isLatinLetter(previousChar)) {
                        return null;
                    }
                }
                int lastCharIndex = offset + candidate.length();
                if (lastCharIndex < this.text.length()) {
                    char nextChar = this.text.charAt(lastCharIndex);
                    if (isInvalidPunctuationSymbol(nextChar) || isLatinLetter(nextChar)) {
                        return null;
                    }
                }
            }
            PhoneNumber number = this.phoneUtil.parseAndKeepRawInput(candidate, this.preferredRegion);
            if (!(this.phoneUtil.getRegionCodeForCountryCode(number.getCountryCode()).equals("IL") && this.phoneUtil.getNationalSignificantNumber(number).length() == 4 && (offset == 0 || (offset > 0 && this.text.charAt(offset - 1) != '*'))) && this.leniency.verify(number, candidate, this.phoneUtil)) {
                number.clearCountryCodeSource();
                number.clearRawInput();
                number.clearPreferredDomesticCarrierCode();
                return new PhoneNumberMatch(offset, candidate, number);
            }
            return null;
        } catch (NumberParseException e) {
        }
    }

    static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil util, PhoneNumber number, StringBuilder normalizedCandidate, String[] formattedNumberGroups) {
        int fromIndex = 0;
        if (number.getCountryCodeSource() != CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String countryCode = Integer.toString(number.getCountryCode());
            fromIndex = normalizedCandidate.indexOf(countryCode) + countryCode.length();
        }
        int i = 0;
        while (i < formattedNumberGroups.length) {
            fromIndex = normalizedCandidate.indexOf(formattedNumberGroups[i], fromIndex);
            if (fromIndex < 0) {
                return false;
            }
            fromIndex += formattedNumberGroups[i].length();
            if (i != 0 || fromIndex >= normalizedCandidate.length() || util.getNddPrefixForRegion(util.getRegionCodeForCountryCode(number.getCountryCode()), true) == null || !Character.isDigit(normalizedCandidate.charAt(fromIndex))) {
                i++;
            } else {
                return normalizedCandidate.substring(fromIndex - formattedNumberGroups[i].length()).startsWith(util.getNationalSignificantNumber(number));
            }
        }
        return normalizedCandidate.substring(fromIndex).contains(number.getExtension());
    }

    static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil util, PhoneNumber number, StringBuilder normalizedCandidate, String[] formattedNumberGroups) {
        boolean z = false;
        String[] candidateGroups = PhoneNumberUtil.NON_DIGITS_PATTERN.split(normalizedCandidate.toString());
        int candidateNumberGroupIndex = number.hasExtension() ? candidateGroups.length - 2 : candidateGroups.length - 1;
        if (candidateGroups.length == 1 || candidateGroups[candidateNumberGroupIndex].contains(util.getNationalSignificantNumber(number))) {
            return true;
        }
        int formattedNumberGroupIndex = formattedNumberGroups.length - 1;
        while (formattedNumberGroupIndex > 0 && candidateNumberGroupIndex >= 0) {
            if (!candidateGroups[candidateNumberGroupIndex].equals(formattedNumberGroups[formattedNumberGroupIndex])) {
                return false;
            }
            formattedNumberGroupIndex--;
            candidateNumberGroupIndex--;
        }
        if (candidateNumberGroupIndex >= 0) {
            z = candidateGroups[candidateNumberGroupIndex].endsWith(formattedNumberGroups[0]);
        }
        return z;
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil util, PhoneNumber number, NumberFormat formattingPattern) {
        if (formattingPattern != null) {
            return util.formatNsnUsingPattern(util.getNationalSignificantNumber(number), formattingPattern, PhoneNumberFormat.RFC3966).split("-");
        }
        String rfc3966Format = util.format(number, PhoneNumberFormat.RFC3966);
        int endIndex = rfc3966Format.indexOf(59);
        if (endIndex < 0) {
            endIndex = rfc3966Format.length();
        }
        return rfc3966Format.substring(rfc3966Format.indexOf(45) + 1, endIndex).split("-");
    }

    static boolean checkNumberGroupingIsValid(PhoneNumber number, String candidate, PhoneNumberUtil util, NumberGroupingChecker checker) {
        StringBuilder normalizedCandidate = PhoneNumberUtil.normalizeDigits(candidate, true);
        if (checker.checkGroups(util, number, normalizedCandidate, getNationalNumberGroups(util, number, null))) {
            return true;
        }
        PhoneMetadata alternateFormats = MetadataManager.getAlternateFormatsForCountry(number.getCountryCode());
        if (alternateFormats != null) {
            for (NumberFormat alternateFormat : alternateFormats.numberFormats()) {
                if (checker.checkGroups(util, number, normalizedCandidate, getNationalNumberGroups(util, number, alternateFormat))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean containsMoreThanOneSlashInNationalNumber(PhoneNumber number, String candidate) {
        int firstSlashInBodyIndex = candidate.indexOf(47);
        if (firstSlashInBodyIndex < 0) {
            return false;
        }
        int secondSlashInBodyIndex = candidate.indexOf(47, firstSlashInBodyIndex + 1);
        if (secondSlashInBodyIndex < 0) {
            return false;
        }
        boolean candidateHasCountryCode;
        if (number.getCountryCodeSource() == CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN) {
            candidateHasCountryCode = true;
        } else if (number.getCountryCodeSource() == CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) {
            candidateHasCountryCode = true;
        } else {
            candidateHasCountryCode = false;
        }
        if (candidateHasCountryCode && PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(0, firstSlashInBodyIndex)).equals(Integer.toString(number.getCountryCode()))) {
            return candidate.substring(secondSlashInBodyIndex + 1).contains(Separators.SLASH);
        }
        return true;
    }

    static boolean containsOnlyValidXChars(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        int index = 0;
        while (index < candidate.length() - 1) {
            char charAtIndex = candidate.charAt(index);
            if (charAtIndex == 'x' || charAtIndex == 'X') {
                char charAtNextIndex = candidate.charAt(index + 1);
                if (charAtNextIndex == 'x' || charAtNextIndex == 'X') {
                    index++;
                    if (util.isNumberMatch(number, candidate.substring(index)) != MatchType.NSN_MATCH) {
                        return false;
                    }
                } else if (!PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(index)).equals(number.getExtension())) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }

    /* JADX WARNING: Missing block: B:18:0x0056, code:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean isNationalPrefixPresentIfRequired(PhoneNumber number, PhoneNumberUtil util) {
        if (number.getCountryCodeSource() != CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            return true;
        }
        PhoneMetadata metadata = util.getMetadataForRegion(util.getRegionCodeForCountryCode(number.getCountryCode()));
        if (metadata == null) {
            return true;
        }
        NumberFormat formatRule = util.chooseFormattingPatternForNumber(metadata.numberFormats(), util.getNationalSignificantNumber(number));
        if (formatRule == null || formatRule.getNationalPrefixFormattingRule().length() <= 0 || formatRule.isNationalPrefixOptionalWhenFormatting() || PhoneNumberUtil.formattingRuleHasFirstGroupOnly(formatRule.getNationalPrefixFormattingRule())) {
            return true;
        }
        return util.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(number.getRawInput())), metadata, null);
    }

    public boolean hasNext() {
        if (this.state == State.NOT_READY) {
            this.lastMatch = find(this.searchIndex);
            if (this.lastMatch == null) {
                this.state = State.DONE;
            } else {
                this.searchIndex = this.lastMatch.end();
                this.state = State.READY;
            }
        }
        return this.state == State.READY;
    }

    public PhoneNumberMatch next() {
        if (hasNext()) {
            PhoneNumberMatch result = this.lastMatch;
            this.lastMatch = null;
            this.state = State.NOT_READY;
            return result;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
