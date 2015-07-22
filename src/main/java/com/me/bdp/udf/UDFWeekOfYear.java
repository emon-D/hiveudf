package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFWeekOfYear extends UDF {
    public int evaluate(String value, int format) {
        String week;
        if((week = DateUtil.getWeekOfYear(value, format)).equals("")){
            return 0;
        }
        return Integer.parseInt(week);
    }

    public String evaluate(String value){
        return DateUtil.getWeekOfYear(value, 0);
    }
}
