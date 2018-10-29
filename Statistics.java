import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * statistics class extend of observaton
 */

public class Statistics extends Observation implements DateTimeComparable{
    // date time format
    protected static String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss z";
    //
    protected DateTimeFormatter format;
    // date time
    private GregorianCalendar utcDateTime;
    private ZonedDateTime zdtDateTime;
    // number of station
    private int numberOfReportingStations;
    // stat type
    private StatsType statType;
    
    /**
     * constructor
     * 
     * @param value double value
     * @param stid string stid
     * @param dateTimeStr GregorianCalendar date time
     * @param numberOfValidStations int number stations
     * @param inStatType stat type 
     */
    public Statistics(double value, String stid, GregorianCalendar dateTimeStr, int numberOfValidStations, StatsType inStatType) {
        // super
        super(value, stid);
        // date time
        this.utcDateTime = dateTimeStr;
        // number stations
        this.numberOfReportingStations = numberOfValidStations;
        // stat type
        this.statType = inStatType;
    }
    
    /**
     * constructor
     * 
     * @param value double value
     * @param stid string stid
     * @param dateTimeStr ZonedDateTime date time
     * @param numberOfValidStations int number stations
     * @param inStatType stat type 
     */
    public Statistics(double value, String stid, ZonedDateTime dateTimeStr, int numberOfValidStations, StatsType inStatType) {
        // super
        super(value, stid);
        // date time
        this.zdtDateTime = dateTimeStr;
        // number stations
        this.numberOfReportingStations = numberOfValidStations;
        // stat type
        this.statType = inStatType;
    }
    
    /**
     * make string from date
     * 
     * @param dateTimeStr string date time
     * @return GregorianCalendar date in format
     */
    public static GregorianCalendar createDateFromString(String dateTimeStr) {
        // GregorianCalendar date time
        GregorianCalendar time = new GregorianCalendar();
        // try
        try {
            // format
            SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
            // set time
            time.setTime(format.parse(dateTimeStr));
        }
        // error
        catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
    
    /**
     * make string from date
     * 
     * @param dateTimeStr string date time
     * @return GregorianCalendar date in format
     */
    public static ZonedDateTime createZDateFromString(String dateTimeStr) {
        // GregorianCalendar date time
        ZonedDateTime time = ZonedDateTime.parse(dateTimeStr);
//        // try
//        try {
//            // format
//            SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
//            // set time
//            time.setTime(format.parse(dateTimeStr));
//        }
//        // error
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
        return time;
    }
    
    /**
     * create string from time
     * 
     * @param calendar GregorianCalendar date time
     * @return string date time
     */
    public static String  createStringFromDate(GregorianCalendar calendar) {
        // format
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        // set time
        format.setCalendar(calendar);
        // string
        String time = format.format(calendar.getTime());
        return time;
    }
    
    /**
     * create string from time
     * 
     * @param calendar GregorianCalendar date time
     * @return string date time
     */
    public static String  createStringFromDate(ZonedDateTime calendar) {
//        // format
//        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
//        // set time
//        format.setCalendar(calendar);
        // string
        String time = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).format(calendar);
        return time;
    }
    
    /**
     * number stations
     * @return int number station
     */
    public int getNumberOfReportingStations() {
        return this.numberOfReportingStations;
    }
    
    /**
     * string date time
     * @return string date time
     */
    public String getUTCDateTimeString() {
        return createStringFromDate(this.utcDateTime);
    }
    
    /**
     * newerThan
     * @return boolean newer
     */
    public boolean newerThan(GregorianCalendar inDateTime) {
        return this.utcDateTime.after(inDateTime);
    }
    
    /**
     * olderThan
     * @return boolean older
     */
    public boolean olderThan(GregorianCalendar inDateTime) {
        return this.utcDateTime.before(inDateTime);
    }
    
    /**
     * sameAs
     * @return boolean same
     */
    public boolean sameAs(GregorianCalendar inDateTime) {
        return this.utcDateTime.equals(inDateTime);
    }
    
    public boolean newerThan(ZonedDateTime inDateTime) {
        return this.zdtDateTime.isAfter(inDateTime);
    }
    
    public boolean olderThan(ZonedDateTime inDateTime) {
        return this.zdtDateTime.isBefore(inDateTime);
    }
    
    public boolean sameAs(ZonedDateTime inDateTime) {
        return this.zdtDateTime.isEqual(inDateTime);
    }
    
    /**
     * to string
     * @return string toString
     */
    public String toString() {
        return this.statType.name();
    }
    

}
