import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Thanh Duong
 * @version 10/02/2018 
 * Project 2 
 * 
 * mapdata class read and modify file
 */

public class MapData {
    
    private HashMap<String, ArrayList<Observation>> dataCatalog;
    private EnumMap<StatsType, TreeMap<String, Statistics>> statistics;
    private TreeMap<String, Integer> paramPositions;
    private int NUMBER_OF_MISSING_OBSERVATIONS = 10;
    private Integer numberOfStations = null;
    // ta9m
    private String TA9M = "TA9M";
    // tair
    private String TAIR = "TAIR";
    // srad
    private String SRAD = "SRAD";
    // stid
    private String STID = "STID";
    // station name
    private String MESONET = "Mesonet";
    // file name
    private String fileName;
    // date time
    private GregorianCalendar utcDateTime;
    
    /**
     * default mapdata constructor 
     * 
     * @param year year of observation
     * @param month month of observation
     * @param day day of observation
     * @param hour hour of observation
     * @param minute minute of observation
     * @param directory directory of observation
     */
    public MapData(int year, int month, int day, int hour, int minute, String directory) {
        // date time
        this.utcDateTime = new GregorianCalendar(year, month - 1, day, hour, minute);
        // file name
        this.fileName = createFileName(year, month, day, hour, minute, directory);
        //
        this.dataCatalog = new HashMap<String, ArrayList<Observation>>();
        //
        this.statistics = new EnumMap<StatsType, TreeMap<String, Statistics>>(StatsType.class);
        //
        this.paramPositions = new TreeMap<String, Integer>();
        //
        this.numberOfStations = 1000;
    }
    
    /**
     * creat file name
     * 
     * @param year int year
     * @param month int month
     * @param day int day
     * @param hour in hour
     * @param minute in minute
     * @param directory Stirng dir
     * @return file name
     */
    public String createFileName(int year, int month, int day, int hour, int minute, String directory) {
        return String.format("%s/%04d%02d%02d%02d%02d.mdf", directory, year, month, day, hour, minute);
    }
    
    /**
     * set up position
     * 
     * @param inParamStr string name in
     */
    private void  parseParamHeader(String inParamStr) {
        // split
        String[] str = inParamStr.trim().split("\\s+");
        // load name
        for (int i = 0; i < str.length; i++) {
            // air temp
            if (str[i].equalsIgnoreCase(this.TAIR)) {
                this.paramPositions.put(this.TAIR, i);
            } 
            // air temp
            else if(str[i].equalsIgnoreCase(this.TA9M)) {
                this.paramPositions.put(this.TA9M, i);
            } 
            // srad
            else if(str[i].equalsIgnoreCase(this.SRAD)) {
                this.paramPositions.put(this.SRAD, i);
            } 
            // stid
            else if(str[i].equalsIgnoreCase(this.STID)) {
                this.paramPositions.put(this.STID, i);
            }
        }
    }
    
    public Integer getIndexOf(String inParamStr) {
        return this.paramPositions.get(inParamStr);
    }
    
    /*
     * parse file
     */
    public void parseFile() throws IOException {
        //System.out.println(this.createFileName());
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String strg;
        
        // Throw out header
        strg = br.readLine(); 
        // First row containing data
        strg = br.readLine();
        // Second row containing data
        strg = br.readLine();
        // Read header
        parseParamHeader(strg);
        // Third row containing data
        strg = br.readLine();
        // Loop over the lines in the file
        //
        ArrayList<Observation> srad = new ArrayList<Observation>();
        
        ArrayList<Observation> tair = new ArrayList<Observation>();
        
        ArrayList<Observation> ta9m = new ArrayList<Observation>();

        while (strg != null)
        {
            // split
            String[] tokens = strg.trim().split("\\s+");
            // srad data
            srad.add(new Observation(Double.parseDouble(tokens[this.getIndexOf(this.SRAD)]), tokens[this.getIndexOf(this.STID)]));
            
            tair.add(new Observation(Double.parseDouble(tokens[this.getIndexOf(this.TAIR)]), tokens[this.getIndexOf(this.STID)]));

            ta9m.add(new Observation(Double.parseDouble(tokens[this.getIndexOf(this.TA9M)]), tokens[this.getIndexOf(this.STID)]));

            // next line
            strg = br.readLine();
        }
        
        this.dataCatalog.put(this.SRAD, srad);
        this.dataCatalog.put(this.TAIR, tair);
        this.dataCatalog.put(this.TA9M, ta9m);
//        // calculate statistics
//        calculateStatistics(this.sradData,this.SRAD);
//        // calculate statistics
//        calculateStatistics(this.tairData,this.TAIR);
//        // calculate statistics
//        calculateStatistics(this.ta9mData,this.TA9M);
        // close file
        calculateAllStatistics();
        br.close();
    }
    
    /**
     * print string
     * 
     * @return String string 
     */
    public String toString() {
        // date in format
        String date = Statistics.createStringFromDate(this.utcDateTime);
        // string
        String c = String.format("========================================================\n=== "
                + date + " ===\n========================================================\n");
        // string for air temp
        c += String.format("Maximum Air Temperature[1.5m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.MAXIMU).get(this.TAIR).getValue(), 
                this.statistics.get(StatsType.MAXIMU).get(this.TAIR).getStid());
        // string for air temp
        c += String.format("Minimum Air Temperature[1.5m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.MINIMUM).get(this.TAIR).getValue(), 
                this.statistics.get(StatsType.MINIMUM).get(this.TAIR).getStid());
        // string for air temp
        c += String.format("Average Air Temperature[1.5m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.AVERAGE).get(this.TAIR).getValue(), 
                this.statistics.get(StatsType.AVERAGE).get(this.TAIR).getStid());
        // string for air temp
        c += "========================================================"
                + "\n========================================================\n";
        // string for air temp
        c += String.format("Maximum Air Temperature[9.0m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.MAXIMU).get(this.TA9M).getValue(), 
                this.statistics.get(StatsType.MAXIMU).get(this.TA9M).getStid());
        // string for air temp
        c += String.format("Minimum Air Temperature[9.0m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.MINIMUM).get(this.TA9M).getValue(), 
                this.statistics.get(StatsType.MINIMUM).get(this.TA9M).getStid());
        // string for air temp
        c += String.format("Average Air Temperature[9.0m] = %.1f C AT %s\n", 
                this.statistics.get(StatsType.AVERAGE).get(this.TA9M).getValue(), 
                this.statistics.get(StatsType.AVERAGE).get(this.TA9M).getStid());
        // string for srad
        c += "========================================================"
                + "\n========================================================\n";
        // string for srad
        c += String.format("Maximum Solar Radiation[1.5m] = %.1f W/m^2 AT %s\n", 
                this.statistics.get(StatsType.MAXIMU).get(this.SRAD).getValue(), 
                this.statistics.get(StatsType.MAXIMU).get(this.SRAD).getStid());
        // string for srad
        c += String.format("Minimum Solar Radiation[1.5m] = %.1f W/m^2 AT %s\n", 
                this.statistics.get(StatsType.MINIMUM).get(this.SRAD).getValue(), 
                this.statistics.get(StatsType.MINIMUM).get(this.SRAD).getStid());
        // string for srad
        c += String.format("Average Solar Radiation[1.5m] = %.1f W/m^2 AT %s\n", 
                this.statistics.get(StatsType.AVERAGE).get(this.SRAD).getValue(), 
                this.statistics.get(StatsType.AVERAGE).get(this.SRAD).getStid());
        c += "========================================================\n";
       // c += this.numberOfStations;
        return c;
    }
    
    /**
     * calculate statistics
     * 
     * @param inData data array list
     * @param paramld name type
     */
    private void calculateAllStatistics() {
        int cout = 0;
        TreeMap<String, Statistics> minTree = new TreeMap<String, Statistics>();
        TreeMap<String, Statistics> maxTree = new TreeMap<String, Statistics>();
        TreeMap<String, Statistics> aveTree = new TreeMap<String, Statistics>();
        TreeMap<String, Statistics> totalTree = new TreeMap<String, Statistics>();
        while (cout < 3) {
         // min
            int min = 0;
            // max
            int max = 0;
            // valid
            int valid = 0;
            // min srad
            double minValue = Double.MAX_VALUE;
            // max srad
            double maxValue = Double.MIN_VALUE;
            // total srad
            double totalValue = 0;
            // average srad
            double averageValue = 0;
            //
            ArrayList<Observation> inData = new ArrayList<Observation>();
            if (cout == 0) {
                inData = this.dataCatalog.get(this.SRAD);
            }
            if (cout == 1) {
                inData = this.dataCatalog.get(this.TAIR);
            }
            if (cout == 2) {
                inData = this.dataCatalog.get(this.TA9M);
            }
            // read all observation
            for (int i = 0; i < inData.size(); i++) {
             // check valid
                if (inData.get(i).isValid()) {
                    // increase
                    valid ++;
                    // total srad
                    totalValue += inData.get(i).getValue();
                    // average srad
                    averageValue = totalValue/valid;
                    // min srad
                    if (minValue > inData.get(i).getValue()) {
                        minValue = inData.get(i).getValue();
                        min = i;
                    }
                    // max srad
                    if (maxValue < inData.get(i).getValue()) {
                        maxValue = inData.get(i).getValue();
                        max = i;
                    }
                }
            }
            
            if (cout == 0) {
                // min value
                minTree.put(this.SRAD, new Statistics(inData.get(min).getValue(), inData.get(min).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
                // max value
                maxTree.put(this.SRAD, new Statistics(inData.get(max).getValue(), inData.get(max).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MAXIMU));
                // average value
                aveTree.put(this.SRAD, new Statistics(Double.parseDouble(String.format("%.1f", averageValue)), this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.AVERAGE));
                // total value
                totalTree.put(this.SRAD, new Statistics(totalValue, this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.TOTAL));
            }
            
            if (cout == 1) {
                // min value
                minTree.put(this.TAIR, new Statistics(inData.get(min).getValue(), inData.get(min).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
                // max value
                maxTree.put(this.TAIR, new Statistics(inData.get(max).getValue(), inData.get(max).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MAXIMU));
                // average value
                aveTree.put(this.TAIR, new Statistics(Double.parseDouble(String.format("%.1f", averageValue)), this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
                // total value
                totalTree.put(this.TAIR, new Statistics(totalValue, this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
            }
            
            if (cout == 2) {
                // min value
                minTree.put(this.TA9M, new Statistics(inData.get(min).getValue(), inData.get(min).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
                // max value
                maxTree.put(this.TA9M, new Statistics(inData.get(max).getValue(), inData.get(max).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MAXIMU));
                // average value
                aveTree.put(this.TA9M, new Statistics(Double.parseDouble(String.format("%.1f", averageValue)), this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
                // total value
                totalTree.put(this.TA9M, new Statistics(totalValue, this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM));
            }
            cout++;
        }
        System.out.print("a");
        this.statistics.put(StatsType.MINIMUM, minTree);
        this.statistics.put(StatsType.MAXIMU, maxTree);
        this.statistics.put(StatsType.AVERAGE, aveTree);
        this.statistics.put(StatsType.TOTAL, totalTree);
//        
//        if (paramld.equals(this.TA9M)) {
//            // min value
//            this.ta9mMin = new Statistics(inData.get(min).getValue(), inData.get(min).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MINIMUM);
//            // max value
//            this.ta9mMax = new Statistics(inData.get(max).getValue(), inData.get(max).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MAXIMU);
//            // average value
//            this.ta9mAverage = new Statistics(Double.parseDouble(String.format("%.1f", averageValue)), this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM);
//        }
//        
//        if (paramld.equals(this.TAIR)) {
//            // min value
//            this.tairMin = new Statistics(inData.get(min).getValue(), inData.get(min).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MINIMUM);
//            // max value
//            this.tairMax = new Statistics(inData.get(max).getValue(), inData.get(max).getStid(), this.utcDateTime, this.numberOfStations, StatsType.MAXIMU);
//            // average value
//            this.tairAverage = new Statistics(Double.parseDouble(String.format("%.1f", averageValue)), this.MESONET, this.utcDateTime, this.numberOfStations, StatsType.MINIMUM);
//        }
    }
//    private void prepareDataCatalog() {
//        
//    }
//    private void calculateStatistics() {
//        
//    }
    public Statistics getStatistics(StatsType type, String paramId) {
        return statistics.get(StatsType.MINIMUM).get(SRAD);
    }
    
}
