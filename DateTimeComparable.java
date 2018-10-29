import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * DateTimeComparable class
 */

public interface DateTimeComparable {
    public boolean newerThan(GregorianCalendar inDateTime);
    public boolean olderThan(GregorianCalendar inDateTime);
    public boolean sameAs(GregorianCalendar inDateTime);
    public boolean newerThan( ZonedDateTime inDateTimeUTC);
    public boolean olderThan( ZonedDateTime inDateTimeUTC);
    public boolean sameAs( ZonedDateTime inDateTimeUTC);
}
