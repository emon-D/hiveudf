package com.haizhi.bdp.udf;

public class StringUtil {
    public static int getIndex(String str, String sub, int start){
        // src.position(start) can't accept negative numbers.
        int length = str.length() - start;
        if (start < 0 || length < 0 || length < sub.length()) {
            return 0;
        }
        if (sub.length() == 0) {
            return 0;
        }
        if (length == 0) {
            return 0;
        }

        int index = str.indexOf(sub, start);
        return index + 1;
    }
}
