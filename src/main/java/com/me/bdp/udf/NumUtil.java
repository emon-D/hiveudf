package com.haizhi.bdp.udf;

import java.util.ArrayList;

public class NumUtil {

    private final static String EXCEPT_STR = "INF";

    public static String getMax(String v1,String v2){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3,String v4){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3,String v4,String v5){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3,String v4,String v5,String v6){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3,String v4,String v5,String v6,String v7){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        list.add(new SimpleValue(v7));
        return NumUtil._getMax(list);
    }

    public static String getMax(String v1,String v2,String v3,String v4,String v5,String v6,String v7,String v8){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        list.add(new SimpleValue(v7));
        list.add(new SimpleValue(v8));
        return NumUtil._getMax(list);
    }
    public static String getMin(String v1,String v2){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3,String v4){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3,String v4,String v5){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3,String v4,String v5,String v6){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3,String v4,String v5,String v6,String v7){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        list.add(new SimpleValue(v7));
        return NumUtil._getMin(list);
    }

    public static String getMin(String v1,String v2,String v3,String v4,String v5,String v6,String v7,String v8){
        ArrayList<SimpleValue> list = new ArrayList<>();
        list.add(new SimpleValue(v1));
        list.add(new SimpleValue(v2));
        list.add(new SimpleValue(v3));
        list.add(new SimpleValue(v4));
        list.add(new SimpleValue(v5));
        list.add(new SimpleValue(v6));
        list.add(new SimpleValue(v7));
        list.add(new SimpleValue(v8));
        return NumUtil._getMin(list);
    }

    public static String _getMax(ArrayList<SimpleValue> list){
        double max_trans_value = 0.0;
        String max_value = "";
        for(SimpleValue val : list){
            if(!val.get_trans_flag()) continue;
            if(max_value.equals("")){
                max_value = val.get_val();
                max_trans_value = val.get_trans_val();
            }
            else if(max_trans_value < val.get_trans_val()){
                max_value = val.get_val();
                max_trans_value = val.get_trans_val();
            }
        }

        return (max_value.equals("")) ? NumUtil.EXCEPT_STR : max_value;
    }

    public static String _getMin(ArrayList<SimpleValue> list){
        double min_trans_value = 0.0;
        String min_value = "";
        for(SimpleValue val : list){
            if(!val.get_trans_flag()) continue;
            if(min_value.equals("")){
                min_value = val.get_val();
                min_trans_value = val.get_trans_val();
            }
            else if(min_trans_value > val.get_trans_val()){
                min_value = val.get_val();
                min_trans_value = val.get_trans_val();
            }
        }

        return (min_value.equals("")) ? NumUtil.EXCEPT_STR : min_value;
    }
}
