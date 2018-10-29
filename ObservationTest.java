import org.junit.Assert;
import org.junit.Test;

/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * observation test class that test observation
 */

public class ObservationTest {

	@Test
	public void testConstructor() {
		Observation obs1 = new Observation(90, "HELLO");
		Observation obs2 = new Observation(-999, "HELLO");		
		
		Assert.assertEquals(true, obs1.isValid());
		Assert.assertEquals(false, obs2.isValid());
	}
	@Test
	public void testGetValue() {
		Observation obs1 = new Observation(90, "HELLO");	
		
		Assert.assertEquals(90.00, obs1.getValue(), 0.00001);

	}
	@Test
	public void testIsValid() {
		Observation obs1 = new Observation(90, "HELLO");
		Observation obs2 = new Observation(-999, "HELLO");		
		
		Assert.assertEquals(true, obs1.isValid());
		Assert.assertEquals(false, obs2.isValid());
	}
	@Test
	public void testGetStid() {
		Observation obs1 = new Observation(90, "HELLO");
		
		Assert.assertEquals("HELLO", obs1.getStid());
	}
	@Test
	public void testToString() {
		Observation obs1 = new Observation(90, "HELLO");	
		
		Assert.assertEquals("90.0 AT HELLO", obs1.toString());
	}

}
