package com.haizhi.bdp.udaf;

import com.haizhi.bdp.udf.DateUtil;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by penghuang on 4/2/15.
 */
public class UDAFMaxDate extends UDAF {
    public static class MaxDateEvaluator implements UDAFEvaluator {
        private Date maxDate;
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        public void init() {
            maxDate = null;
        }

        public boolean iterate(String value) {
            if (value == null) {
                return true;
            }
            Date current = DateUtil.parse(value);
            if (current == null) {
                return true;
            }
            if (maxDate == null) {
                maxDate = current;
            } else {
                if (maxDate.compareTo(current) < 0) {
                    maxDate = current;
                }
            }
            return true;
        }

        public Date terminatePartial() {
            return maxDate;
        }

        public boolean merge(Date other) {
            if (other == null) {
                return true;
            }
            if (maxDate == null) {
                maxDate = other;
            } else {
                if (maxDate.compareTo(other) < 0) {
                    maxDate = other;
                }
            }
            return true;
        }

        public String terminate() {
            if(maxDate == null) {
                return null;
            }
            return sdf.format(maxDate);
        }
    }
}
