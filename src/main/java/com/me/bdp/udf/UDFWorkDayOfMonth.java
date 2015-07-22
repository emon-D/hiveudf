package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
/**
 * Created by dingzhu on 15/1/23.
 */
public class UDFWorkDayOfMonth extends UDF{
    public int evaluate(int year, int month){
        return DateUtil.getWorkDayOfMonth(year,month);
    }
}
