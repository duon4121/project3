import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * statistics test class
 */

public class StatisticsTest {

    @Test
    public void testConstructor() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
        
//        Statistics sta2 = new Statistics(44, "AAN", "2018-09-30T17:45:00 CDT", 10, StatsType.MINIMUM);
//
//        Statistics sta3 = new Statistics(44, "AAN", "2018-08-30T17:45", 10, StatsType.MINIMUM);

//        Assert.assertEquals(44, sta3.getValue(), 0.00001);
//        Assert.assertEquals("AAN", sta2.getStid());
        Assert.assertEquals(10, sta1.getNumberOfReportingStations());

    }
    
    @Test
    public void testCreateDateFromString() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
        
        Assert.assertEquals(44, sta1.getValue(), 0.00001);
        Assert.assertEquals("AAN", sta1.getStid());
        Assert.assertEquals(10, sta1.getNumberOfReportingStations());
    }
    
    @Test
    public void testCreateStringFromDate() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
        
        Assert.assertEquals(44, sta1.getValue(), 0.00001);
        Assert.assertEquals("AAN", sta1.getStid());
        Assert.assertEquals(10, sta1.getNumberOfReportingStations());
    }
    
    @Test
    public void testGetNumberOfReportingStations() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);

        Assert.assertEquals(10, sta1.getNumberOfReportingStations());
    }
    
    @Test
    public void testGetUTCDateTimeString() {        
//        Statistics sta2 = new Statistics(44, "AAN", "2018-09-30T17:45:00 CDT", 10, StatsType.MINIMUM);

//        Assert.assertEquals("2018-09-30T17:45:00 CDT", sta2.getUTCDateTimeString());
    }
    
    @Test
    public void testNewerThan() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);
        GregorianCalendar time3 = new GregorianCalendar(2018, 6, 30, 17, 45);
        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
        
        Assert.assertFalse(sta1.newerThan(time1));
        Assert.assertTrue(sta1.newerThan(time3));
    }
    
    @Test
    public void testOlderThan() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);
        GregorianCalendar time2 = new GregorianCalendar(2018, 8, 30, 17, 45);
        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
                
        Assert.assertFalse(sta1.olderThan(time1));
        Assert.assertTrue(sta1.olderThan(time2));
    }
    
    @Test
    public void testSameAs() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);
        GregorianCalendar time2 = new GregorianCalendar(2018, 8, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
                
        Assert.assertTrue(sta1.sameAs(time1));
        Assert.assertFalse(sta1.sameAs(time2));
    }
    @Test
    public void testToString() {
        GregorianCalendar time1 = new GregorianCalendar(2018, 7, 30, 17, 45);

        Statistics sta1 = new Statistics(44, "AAN", time1, 10, StatsType.MINIMUM);
        Statistics sta2 = new Statistics(44, "AAN", time1, 10, StatsType.AVERAGE);
        Statistics sta3 = new Statistics(44, "AAN", time1, 10, StatsType.MAXIMU);
        Statistics sta4 = new Statistics(44, "AAN", time1, 10, StatsType.TOTAL);
        Assert.assertEquals("MINIMUM", sta1.toString());
        Assert.assertEquals("AVERAGE", sta2.toString());
        Assert.assertEquals("MAXIMU", sta3.toString());
        Assert.assertEquals("TOTAL", sta4.toString());
    }
}
