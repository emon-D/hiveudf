package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
/**
 * Created by dingzhu on 15/1/17.
 */
public class UDFMaxVal extends UDF{
    //String
    public String evaluate(String v1,String v2){
        return NumUtil.getMax(v1,v2);
    }

    public String evaluate(String v1,String v2,String v3){
        return NumUtil.getMax(v1,v2,v3);
    }

    public String evaluate(String v1,String v2,String v3,String v4){
        return NumUtil.getMax(v1,v2,v3,v4);
    }

    public String evaluate(String v1,String v2,String v3,String v4,String v5){
        return NumUtil.getMax(v1,v2,v3,v4,v5);
    }

    public String evaluate(String v1,String v2,String v3,String v4,String v5,String v6){
        return NumUtil.getMax(v1,v2,v3,v4,v5,v6);
    }

    public String evaluate(String v1,String v2,String v3,String v4,String v5,String v6,String v7){
        return NumUtil.getMax(v1,v2,v3,v4,v5,v6,v7);
    }

    public String evaluate(String v1,String v2,String v3,String v4,String v5,String v6,String v7,String v8){
        return NumUtil.getMax(v1,v2,v3,v4,v5,v6,v7,v8);
    }
    
}
