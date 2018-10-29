import java.io.IOException;

/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * Driver class that get input and create a new mapData
 */

public class Driver
{

/**
* @param args args
 * @throws IOException exception
*/
    public static void main(String[] args) throws IOException
    {
        final int YEAR = 2018;
        final int MONTH = 8;
        final int DAY = 30;
        final int HOUR = 17;
        final int MINUTE = 45; 
        final String directory = "data";
        MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
        mapData.parseFile();
        System.out.println(mapData);
        }
    }