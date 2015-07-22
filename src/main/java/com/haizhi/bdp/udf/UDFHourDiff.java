package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFHourDiff extends UDF {
    // value1 value2 should be datetime string, format : "yyyy-MM-dd HH:mm:ss"
    public String evaluate(String value1, String value2) {
        return DiffUtil.hourDiff(value1, value2);
    }
}
