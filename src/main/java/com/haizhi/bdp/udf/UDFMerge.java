package com.haizhi.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by penghuang on 4/2/15.
 */
public class UDFMerge extends UDF{

    public String evaluate(String v1, String v2) {
        if (v1 == null && v2 == null) {
            return null;
        } else if (v1 != null) {
            return v1;
        } else {
            return v2;
        }
    }

}
