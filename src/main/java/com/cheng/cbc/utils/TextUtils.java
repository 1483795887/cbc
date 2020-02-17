package com.cheng.cbc.utils;

public class TextUtils {
    public static String getStringReal(String value) {
        String str = value.substring(1, value.length() - 1);
        str = str.replaceAll("\\\\n", "\n");
        str = str.replaceAll("\\\\b", "\b");
        str = str.replaceAll("\\\\r", "\r");
        str = str.replaceAll("\\\\t", "\t");
        return str;
    }

    public static String getStringLiteral(String value) {
        String str;
        str = value.replaceAll("\n", "\\\\n");
        str = str.replaceAll("\t", "\\\\t");
        str = str.replaceAll("\b", "\\\\b");
        str = str.replaceAll("\r", "\\\\r");
        return str;
    }

    public static long getLong(String str) {
        long v = 0;
        str = str.toLowerCase();
        str = str.replaceFirst("[UL]+", "");
        if (str.startsWith("0x")) {
            str = str.substring(2);
            v = Long.parseLong(str, 16);
        } else if (str.startsWith("0")) {
            if (str.length() == 1)
                v = 0;
            else {
                str = str.substring(1);
                v = Long.parseLong(str, 8);
            }
        } else
            v = Long.parseLong(str, 10);
        return v;
    }

    public static long getChar(String str) {
        String c = TextUtils.getStringReal(str);
        return c.charAt(0);
    }
}
