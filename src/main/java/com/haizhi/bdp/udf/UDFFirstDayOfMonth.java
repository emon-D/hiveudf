package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
/**
 * Created by dingzhu on 15/1/23.
 */
public class UDFFirstDayOfMonth extends UDF{
    public String evaluate(int year, int month){
        return DateUtil.getFirstDayOfMonth(year,month);
    }
}
