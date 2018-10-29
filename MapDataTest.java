import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Thanh Duong
 * @version 10/02/2018
 * project 2
 * 
 * mapdata test that test map data
 */
public class MapDataTest {

	/**
	 *  test constructor
	 * @throws IOException exception
	 */
	@Test 
	public void testConstructor() throws IOException {
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals("data/201808301745.mdf", mapData.createFileName(YEAR, MONTH, DAY, HOUR, MINUTE,directory));
//		Assert.assertEquals(36.5, mapData.getTairMax().getValue(), 0.00001);
//		Assert.assertEquals(20.8, mapData.getTairMin().getValue(), 0.00001); 
//		Assert.assertEquals(32.4, mapData.getTairAverage().getValue(), 0.00001);
//		Assert.assertEquals(34.9, mapData.getTa9mMax().getValue(), 0.00001);
//		Assert.assertEquals(20.7, mapData.getTa9mMin().getValue(), 0.00001);
//		Assert.assertEquals(31.6, mapData.getTa9mAverage().getValue(), 0.00001);
//		Assert.assertEquals(968.0, mapData.getSradMax().getValue(), 0.00001);
//		Assert.assertEquals(163.0, mapData.getSradMin().getValue(), 0.00001);
//		Assert.assertEquals(828.1, mapData.getSradAverage().getValue(), 0.00001);
//		System.out.println(mapData.getSradTotal().getValue());
//		Assert.assertEquals(97720.0, mapData.getSradTotal().getValue(), 0.00001); 
//	    Assert.assertEquals("========================================================\n" + 
//	              "=== 2018-08-30T17:45:00 CDT ===\n" + 
//	              "========================================================\n" + 
//	              "Maximum Air Temperature[1.5m] = 36.5 C AT HOOK\n" + 
//	              "Minimum Air Temperature[1.5m] = 20.8 C AT MIAM\n" + 
//	              "Average Air Temperature[1.5m] = 32.4 C AT Mesonet\n" + 
//	              "========================================================\n" + 
//	              "========================================================\n" + 
//	              "Maximum Air Temperature[9.0m] = 34.9 C AT HOOK\n" + 
//	              "Minimum Air Temperature[9.0m] = 20.7 C AT MIAM\n" + 
//	              "Average Air Temperature[9.0m] = 31.6 C AT Mesonet\n" + 
//	              "========================================================\n" + 
//	              "========================================================\n" + 
//	              "Maximum Solar Radiation[1.5m] = 968.0 W/m^2 AT SLAP\n" + 
//	              "Minimum Solar Radiation[1.5m] = 163.0 W/m^2 AT MIAM\n" + 
//	              "Average Solar Radiation[1.5m] = 828.1 W/m^2 AT Mesonet\n" + 
//	              "========================================================\n", mapData.toString());
		}
//	
//	/**
//	 * create file name test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testCreateFilename() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//        Assert.assertEquals("data/201808301745.mdf", mapData.createFileName(YEAR, MONTH, DAY, HOUR, MINUTE,directory));
//
//	}
//	
//	/**
//	 *  pare file test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testParseFile() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(97720.0, mapData.getSradTotal().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 * get srad average test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetSradAverage() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(828.1, mapData.getSradAverage().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 * get srad max
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetSradMax() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(968.0, mapData.getSradMax().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 *  get srad min test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetSradMin() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(163.0, mapData.getSradMin().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 * get srad total
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetSradTotal() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(97720.0, mapData.getSradTotal().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 *  get ta9m average
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTa9mAverage() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(31.6, mapData.getTa9mAverage().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 * get ta9m max test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTa9mMax() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(34.9, mapData.getTa9mMax().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 * get ta9m min
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTa9mMin() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(20.8, mapData.getTairMin().getValue(), 0.00001); 
//	}
//	
//	/**
//	 *  get tair average test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTairAverage() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(32.4, mapData.getTairAverage().getValue(), 0.00001);
//	}
//	
//	/**
//	 *  get tair max test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTairMax() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(36.5, mapData.getTairMax().getValue(), 0.00001);
//	}
//	
//	/**
//	 *  get tair min test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testGetTairMin() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(20.8, mapData.getTairMin().getValue(), 0.00001);
//
//	}
//	
//	/**
//	 *  to strting test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testToString() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals("========================================================\n" + 
//                "=== 2018-08-30T17:45:00 CDT ===\n" + 
//                "========================================================\n" + 
//                "Maximum Air Temperature[1.5m] = 36.5 C AT HOOK\n" + 
//                "Minimum Air Temperature[1.5m] = 20.8 C AT MIAM\n" + 
//                "Average Air Temperature[1.5m] = 32.4 C AT Mesonet\n" + 
//                "========================================================\n" + 
//                "========================================================\n" + 
//                "Maximum Air Temperature[9.0m] = 34.9 C AT HOOK\n" + 
//                "Minimum Air Temperature[9.0m] = 20.7 C AT MIAM\n" + 
//                "Average Air Temperature[9.0m] = 31.6 C AT Mesonet\n" + 
//                "========================================================\n" + 
//                "========================================================\n" + 
//                "Maximum Solar Radiation[1.5m] = 968.0 W/m^2 AT SLAP\n" + 
//                "Minimum Solar Radiation[1.5m] = 163.0 W/m^2 AT MIAM\n" + 
//                "Average Solar Radiation[1.5m] = 828.1 W/m^2 AT Mesonet\n" + 
//                "========================================================\n", mapData.toString());
//	}
//	
//	/**
//	 * calculate air temperature test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testCalculateAirTemperatureStatistics() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(36.5, mapData.getTairMax().getValue(), 0.00001);
//		Assert.assertEquals(20.8, mapData.getTairMin().getValue(), 0.00001); 
//		Assert.assertEquals(32.4, mapData.getTairAverage().getValue(), 0.00001);
//	}
//	
//	/**
//	 *  calculate air temperature test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testCalculateTa9mTemperatureStatistics() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(34.9, mapData.getTa9mMax().getValue(), 0.00001);
//		Assert.assertEquals(20.7, mapData.getTa9mMin().getValue(), 0.00001);
//		Assert.assertEquals(31.6, mapData.getTa9mAverage().getValue(), 0.00001);
//	}
//	
//	/**
//	 *  calculate srad test
//	 * @throws IOException exception
//	 */
//	@Test 
//	public void testCalculateSolarRadiationStatistics() throws IOException {
//		final int YEAR = 2018;
//		final int MONTH = 8;
//		final int DAY = 30;
//		final int HOUR = 17;
//		final int MINUTE = 45;
//		final String directory = "data";
//		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
//		mapData.parseFile();
//		Assert.assertEquals(968.0, mapData.getSradMax().getValue(), 0.00001);
//		Assert.assertEquals(163.0, mapData.getSradMin().getValue(), 0.00001);
//		Assert.assertEquals(828.1, mapData.getSradAverage().getValue(), 0.00001);
//		Assert.assertEquals(97720.0, mapData.getSradTotal().getValue(), 0.00001);
//	}
}
