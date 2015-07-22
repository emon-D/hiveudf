package com.haizhi.bdp.udf;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumUtilTest {
    @Test
    public void testGetMax() throws Exception {
        //invalid values
        assertEquals("INF", NumUtil.getMax("acb","fsdf"));
        assertEquals("22", NumUtil.getMax("acb","22"));
        assertEquals("-22", NumUtil.getMax("-22","fdf3fdf22"));
        //two values
        assertEquals("22", NumUtil.getMax("11","22"));
        assertEquals("11", NumUtil.getMax("11","11"));
        assertEquals("12.0", NumUtil.getMax("12.0","11"));
        assertEquals("13", NumUtil.getMax("12.0","13"));
        //three values
        assertEquals("3", NumUtil.getMax("2","1","3"));
        assertEquals("3", NumUtil.getMax("3","3","3"));
        assertEquals("22", NumUtil.getMax("22","3","22"));

    }

    @Test
    public void testGetMin() throws Exception {
        //invalid values
        assertEquals("INF", NumUtil.getMin("acb", "fsdf"));
        assertEquals("22", NumUtil.getMin("acb", "22"));
        assertEquals("-22", NumUtil.getMin("-22", "fdf3fdf22"));
        //two values
        assertEquals("11", NumUtil.getMin("11", "22"));
        assertEquals("11", NumUtil.getMin("11", "11"));
        assertEquals("11", NumUtil.getMin("12", "11"));
        //three values
        assertEquals("1", NumUtil.getMin("2","1","3"));
        assertEquals("3", NumUtil.getMin("3","3","3"));
        assertEquals("3", NumUtil.getMin("22", "3", "22"));

    }
}
