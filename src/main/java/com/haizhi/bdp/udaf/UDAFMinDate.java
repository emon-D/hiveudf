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
public class UDAFMinDate extends UDAF {
    public static class MaxDateEvaluator implements UDAFEvaluator {
        private Date minDate;
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        public void init() {
            minDate = null;
        }

        public boolean iterate(String value) {
            if (value == null) {
                return true;
            }
            Date current = DateUtil.parse(value);
            if (current == null) {
                return true;
            }
            if (minDate == null) {
                minDate = current;
            } else {
                if (minDate.compareTo(current) > 0) {
                    minDate = current;
                }
            }
            return true;
        }

        public Date terminatePartial() {
            return minDate;
        }

        public boolean merge(Date other) {
            if (other == null) {
                return true;
            }
            if (minDate == null) {
                minDate = other;
            } else {
                if (minDate.compareTo(other) > 0) {
                    minDate = other;
                }
            }
            return true;
        }

        public String terminate() {
            if(minDate == null) {
                return null;
            }
            return sdf.format(minDate);
        }
    }
}
