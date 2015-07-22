package com.haizhi.bdp.udf;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

public class DiffUtilTest {

    @Test
    public void testDateDiff() throws Exception {
        assertEquals("4", DiffUtil.dateDiff("2014-01-05 00:10:00", "2014-01-01 00:00:00"));
        assertEquals("-3", DiffUtil.dateDiff("2014-01-01 00:00:00", "2014-01-04 00:19:00"));

        assertEquals("119", DiffUtil.dateDiff("2014-07-02 12:00:00", "2014-03-05 00:00:00"));
        assertEquals("-733", DiffUtil.dateDiff("2013-01-01 00:00:00", "2015-01-04 15:00:00"));

        assertEquals("INF", DiffUtil.dateDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.dateDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.dateDiff(null, null));
    }

    @Test
    public void testMonthDiff() throws Exception {
        assertEquals("-6", DiffUtil.monthDiff("2014-01-05 00:10:00", "2014-07-01 00:00:00"));
        assertEquals("4", DiffUtil.monthDiff("2014-05-01 00:00:00", "2014-01-04 00:19:00"));

        assertEquals("-8", DiffUtil.monthDiff("2014-07-02 12:00:00", "2015-03-05 00:00:00"));
        assertEquals("36", DiffUtil.monthDiff("2018-01-01 00:00:00", "2015-01-04 15:00:00"));

        assertEquals("INF", DiffUtil.monthDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.monthDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.monthDiff(null, null));
    }

    @Test
    public void testYearDiff() throws Exception {
        assertEquals("0", DiffUtil.yearDiff("2014-01-05 00:10:00", "2014-01-01 00:00:00"));
        assertEquals("-1", DiffUtil.yearDiff("2014-01-01 00:00:00", "2015-01-04 00:19:00"));

        assertEquals("4", DiffUtil.yearDiff("2018-07-02 12:00:00", "2014-03-05 00:00:00"));

        assertEquals("INF", DiffUtil.yearDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.yearDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.yearDiff(null, null));
    }

    @Test
    public void testHourDiff() throws Exception {
        assertEquals("10", DiffUtil.hourDiff("2014-01-01 10:00:00", "2014-01-01 00:00:00"));
        assertEquals("-19", DiffUtil.hourDiff("2015-01-01 00:00:00", "2015-01-01 19:00:00"));

        assertEquals("-72", DiffUtil.hourDiff("2014-03-02 00:00:00", "2014-03-05 00:00:00"));

        assertEquals("INF", DiffUtil.hourDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.hourDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.hourDiff(null, null));
    }

    @Test
    public void testMinuteDiff() throws Exception {
        assertEquals("10", DiffUtil.minuteDiff("2014-01-01 00:10:00", "2014-01-01 00:00:00"));
        assertEquals("-19", DiffUtil.minuteDiff("2015-01-01 00:00:00", "2015-01-01 00:19:00"));

        assertEquals("-4320", DiffUtil.minuteDiff("2014-03-02 00:00:00", "2014-03-05 00:00:00"));

        assertEquals("INF", DiffUtil.minuteDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.minuteDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.minuteDiff(null, null));
    }

    @Test
    public void testSecondDiff() throws Exception {
        assertEquals("10", DiffUtil.secondDiff("2014-01-01 00:10:10", "2014-01-01 00:10:00"));
        assertEquals("0", DiffUtil.secondDiff("2015-01-01 00:00:00", "2015-01-01 00:00:00"));
        assertEquals("36000", DiffUtil.secondDiff("2015-01-01 10:00:00", "2015-01-01 00:00:00"));

        assertEquals("-259200", DiffUtil.secondDiff("2014-03-02 00:00:00", "2014-03-05 00:00:00"));

        assertEquals("INF", DiffUtil.secondDiff("NON-Sense-String", "2015-01-04 15:00:00"));
        assertEquals("INF", DiffUtil.secondDiff("2013-01-01 00:00:00", "NON-Sense-String"));
        assertEquals("INF", DiffUtil.secondDiff(null, null));
    }
}
