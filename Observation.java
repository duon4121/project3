/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * observation class that create observation
 */

public class Observation  extends AbstractObservation{
    // value
    private double value;
    // stid
    private String stid;
    /**
     * constructor
     * 
     * @param value value
     * @param stid string stid
     */
    public Observation(double value, String stid) {
        // value
        this.value = value;
        // stid
        this.stid = stid;
        // valid
        if (value == -999) {
            this.valid = false;
        } else {
            this.valid = true;
        }
    }
    
    /**
     * get value
     * 
     * @return double value
     */
    public double getValue() {
        
        return this.value;
    }
    
    /**
     * valid
     * 
     * @return boolean valid
     */
    public boolean isValid() {
        
        return this.valid;
    }
    
    /**
     * stid
     * 
     * @return string stid
     */
    public String getStid() {
        return this.stid;
    }
    
    /**
     * toString
     * 
     * @return string toString
     */
    public String toString() {
        return String.format("%.1f AT %s", this.value, this.stid);
    }

}
