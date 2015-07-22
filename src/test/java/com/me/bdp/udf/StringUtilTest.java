package com.haizhi.bdp.udf;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by dingzhu on 15/3/9.
 */
public class StringUtilTest {
    @Test
    public void testGetIndex() throws Exception {
        assertEquals(6,StringUtil.getIndex("TFBoy是掏粪男孩","是",0));
        assertEquals(9,StringUtil.getIndex("TFBoy是掏粪男孩","男孩",0));
        assertEquals(3,StringUtil.getIndex("TFBoy是掏粪男孩","Boy",0));
        assertEquals(0,StringUtil.getIndex("TFBoy是掏粪男孩","Boy",3));
        assertEquals(0,StringUtil.getIndex("TFBoy是掏粪男孩","男孩",10));
    }
}
