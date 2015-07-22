package com.haizhi.bdp.udaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by dingzhu on 15/3/22.
 */
public class UDAFConcatAggre extends UDAF{

    public static class ConcatAggreEvaluator implements UDAFEvaluator{

        public static class PartialResult{
            String result;
            String delimiter;
        }

        private PartialResult partial;
        private final static String DELIMITER = "\\001\\002";

        public void init() {
            partial = null;
        }

        public boolean iterate(String value){

            if(value == null){
                return true;
            }
            if(partial == null){
                partial = new PartialResult();
                partial.result = new String("");
                partial.delimiter = new String(DELIMITER);
            }
            if(partial.result.length() > 0)
            {
                partial.result = partial.result.concat(partial.delimiter);
            }

            partial.result = partial.result.concat(value);

            return true;
        }

        public PartialResult terminatePartial(){
            return partial;
        }

        public boolean merge(PartialResult other){
            if (other == null){
                return true;
            }
            if (partial == null){
                partial = new PartialResult();
                partial.result = new String(other.result);
                partial.delimiter = new String(other.delimiter);
            }
            else
            {
                if ( partial.result.length() > 0 )
                {
                    partial.result = partial.result.concat(partial.delimiter);
                }
                partial.result = partial.result.concat(other.result);
            }
            return true;
        }

        public String terminate(){
            return new String(partial.result);
        }
    }
}
