package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by dingzhu on 15/5/25.
 */
public class UDFDayOfWeek extends UDF{
    public String evaluate(String value) {
        if (value == null) {
            return "0";
        }
        return DateUtil.getDayOfWeek(value);
    }
}
