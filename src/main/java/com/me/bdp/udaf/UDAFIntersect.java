package com.haizhi.bdp.udaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import java.util.ArrayList;

/**
 * Created by emon on 15/7/20.
 */
public class UDAFIntersect extends UDAF{
    public static class IntersectEvaluator implements UDAFEvaluator {
        private ArrayList<String> intersection;

        public void init() {
            intersection = null;
        }

        public boolean iterate(ArrayList<String> value) {
            if (value == null){
                return true;
            }
            if (intersection == null){
                intersection = value;
            }
            intersection.retainAll(value);
            return true;
        }

        public ArrayList<String> terminatePartial() {
            return intersection;
        }

        public boolean merge(ArrayList<String> other) {
            if (other == null) {
                return true;
            }
            if (intersection == null){
                intersection = other;
            }
            intersection.retainAll(other);
            return true;
        }

        public ArrayList<String> terminate() {
            return intersection;
        }
    }
}
