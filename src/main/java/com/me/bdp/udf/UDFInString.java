package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFInString extends UDF{

    public int evaluate(String str, String sub){
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str,sub,0);
    }

    public int evaluate(String str, String sub, int start){
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str,sub,start);
    }
}
