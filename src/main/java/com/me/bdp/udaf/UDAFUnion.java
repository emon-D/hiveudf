package com.haizhi.bdp.udaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import java.util.ArrayList;

/**
 * Created by emon on 15/7/21.
 */
public class UDAFUnion extends UDAF{
    public static class IntersectEvaluator implements UDAFEvaluator {
        private ArrayList<String> union;

        public void init() {
            union = null;
        }

        public boolean iterate(ArrayList<String> value) {
            if (value == null){
                return true;
            }
            if (union == null){
                union = value;
            }
            else {
                union.removeAll(value);
                union.addAll(value);
            }
            return true;
        }

        public ArrayList<String> terminatePartial() {
            return union;
        }

        public boolean merge(ArrayList<String> other) {
            if (other == null) {
                return true;
            }
            if (union == null){
                union = other;
            }
            else {
                union.removeAll(other);
                union.addAll(other);
            }
            return true;
        }

        public ArrayList<String> terminate() {
            return union;
        }
    }
}
