package com.haizhi.bdp.udf;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void testGetWeekOfYear() throws Exception {
        assertEquals("2013 52", DateUtil.getWeekOfYear("2014-01-01 00:00:00"));
        assertEquals("2013 52", DateUtil.getWeekOfYear("2014-01-02 00:00:00"));
        assertEquals("2013 52", DateUtil.getWeekOfYear("2014-01-03 00:00:00"));
        assertEquals("2013 52", DateUtil.getWeekOfYear("2014-01-04 00:00:00"));
        assertEquals("2013 52", DateUtil.getWeekOfYear("2014-01-05 00:00:00"));
        assertEquals("2014 1", DateUtil.getWeekOfYear("2014-01-06 00:00:00"));
        assertEquals("2013 51", DateUtil.getWeekOfYear("2013-12-29 00:00:00"));
        assertEquals("2014 52", DateUtil.getWeekOfYear("2014-12-30 00:00:00"));
    }

    @Test
    public void testGetWeekOfYearOnlyWeek() throws Exception {
        assertEquals("52", DateUtil.getWeekOfYear("2014-01-01 00:00:00", 1));
        assertEquals("52", DateUtil.getWeekOfYear("2014-01-02 00:00:00", 1));
        assertEquals("52", DateUtil.getWeekOfYear("2014-01-03 00:00:00", 1));
        assertEquals("52", DateUtil.getWeekOfYear("2014-01-04 00:00:00", 1));
        assertEquals("52", DateUtil.getWeekOfYear("2014-01-05 00:00:00", 1));
        assertEquals("1", DateUtil.getWeekOfYear("2014-01-06 00:00:00", 1));
        assertEquals("51", DateUtil.getWeekOfYear("2013-12-29 00:00:00", 1));
        assertEquals("52", DateUtil.getWeekOfYear("2014-12-30 00:00:00", 1));
    }

    @Test
    public void testGetFirstDayOfMonth() throws Exception {
        assertEquals("2015-01-01 00:00:00",DateUtil.getFirstDayOfMonth(2015,1));
        assertEquals("2015-02-01 00:00:00",DateUtil.getFirstDayOfMonth(2015,2));
    }

    @Test
    public void testGetLastDayOfMonth() throws Exception {
        assertEquals("2015-01-31 00:00:00", DateUtil.getLastDayOfMonth(2015, 1));
        assertEquals("2015-02-28 00:00:00", DateUtil.getLastDayOfMonth(2015, 2));
        assertEquals("2012-02-29 00:00:00", DateUtil.getLastDayOfMonth(2012, 2));
    }

    @Test
    public void testGetWorkDayOfMonth() throws Exception {
        assertEquals(23, DateUtil.getWorkDayOfMonth(2014, 12));
        assertEquals(22, DateUtil.getWorkDayOfMonth(2015, 1));
        assertEquals(20, DateUtil.getWorkDayOfMonth(2015, 2));
    }

    @Test
    public void testUnifyDate(){
        assertEquals("2014-10-05 21:00:00", DateUtil.unifyDate("2014 10 5 21"));
        assertEquals("2014-10-05 22:05:00", DateUtil.unifyDate("2014 10 5 22 5"));
        assertEquals("2014-10-05 22:15:20", DateUtil.unifyDate("2014-10-05 22:15:20"));
        assertEquals("2014-10-05 00:00:00", DateUtil.unifyDate("2014 10 5"));
        assertEquals("2014-10-05 00:00:00", DateUtil.unifyDate("2014 10 05"));
        assertEquals("2014-09-01 00:00:00", DateUtil.unifyDate("2014 9"));
        assertEquals("2014-09-01 00:00:00", DateUtil.unifyDate("2014 09"));
        assertEquals("2014-01-01 00:00:00", DateUtil.unifyDate("2014"));
    }

    @Test
    public void testDayOfWeek() throws Exception {
        assertEquals("1", DateUtil.getDayOfWeek("2015-05-25"));
        assertEquals("7", DateUtil.getDayOfWeek("2015-05-31"));
        assertEquals("5", DateUtil.getDayOfWeek("2014-09-19 00:01:03"));
        assertEquals("0", DateUtil.getDayOfWeek("aaa"));
    }
}