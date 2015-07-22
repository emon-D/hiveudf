package com.haizhi.bdp.udf;

/**
 * Created by dingzhu on 15/1/17.
 */
public class SimpleValue {
    private String val;
    private Boolean trans_flag;
    private double trans_val;

    public SimpleValue(String val){
        this.val = val;
        try{
            this.trans_flag = true;
            this.trans_val = Double.parseDouble(val);
        }
        catch(NumberFormatException e){
            this.trans_flag = false;
            this.trans_val = 0.0;
        }
    }

    public String get_val(){
        return this.val;
    }

    public Boolean get_trans_flag(){
        return this.trans_flag;
    }

    public double get_trans_val(){
        return this.trans_val;
    }
}
