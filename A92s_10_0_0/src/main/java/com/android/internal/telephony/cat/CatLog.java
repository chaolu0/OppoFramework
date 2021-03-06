package com.android.internal.telephony.cat;

import android.annotation.UnsupportedAppUsage;
import android.telephony.Rlog;

public abstract class CatLog {
    static final boolean DEBUG = true;

    @UnsupportedAppUsage
    public static void d(Object caller, String msg) {
        String className = caller.getClass().getName();
        Rlog.d("CAT", className.substring(className.lastIndexOf(46) + 1) + ": " + msg);
    }

    @UnsupportedAppUsage
    public static void d(String caller, String msg) {
        Rlog.d("CAT", caller + ": " + msg);
    }

    @UnsupportedAppUsage
    public static void e(Object caller, String msg) {
        String className = caller.getClass().getName();
        Rlog.e("CAT", className.substring(className.lastIndexOf(46) + 1) + ": " + msg);
    }

    public static void e(String caller, String msg) {
        Rlog.e("CAT", caller + ": " + msg);
    }
}
