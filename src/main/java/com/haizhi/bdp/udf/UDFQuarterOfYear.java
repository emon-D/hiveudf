package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFQuarterOfYear extends UDF {
    public int evaluate(String value) {
        return DateUtil.getQuarterOfYear(value);
    }
}
