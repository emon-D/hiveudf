package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFUnifyDate extends UDF{
    public String evaluate(String value) {
        if (value == null){
            return null;
        }
        return DateUtil.unifyDate(value);
    }
}
