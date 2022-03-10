/**
 * 
 */
package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author purvp
 *
 */
class TimeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void getMilliSecondsBoundary() {
		int milliseconds = Time.getMilliSeconds("00:00:00:000");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 0);
	}
	
	@Test
	void getMilliSecondsGood() {
		int milliseconds = Time.getMilliSeconds("12:05:05:005");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 5);
	}
	
	@Test
	void getMilliSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliSeconds("12:05:05");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"05:05:05", "05:05:05", "05:05:05"})
	void testGetTotalSecondsGoodp(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}

	/**
	 * Test method for {@link time.Time#getTotalSeconds(java.lang.String)}.
	 */
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"00:00:00", "00:00:00", "00:00:00"})
	void testGetTotalSecondsBoundryp(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==0);
	}
	
	@Test
	void testGetTotalSecondsBoundry() {
		int seconds = Time.getTotalSeconds("00:00:00");
		assertTrue("The seconds were not calculated accurately", seconds==0);
	}
	
	
	/**
	 * Test method for {@link time.Time#getTotalHours(java.lang.String)}.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00", "05:15:15", "05:59:59"})
	void testGetTotalHoursGoodp(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours==5);
	}
	
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("06:10:34");
		assertTrue("Then hours were not calculated accurately", hours==6);
	}
	
	@Test
	void testGetTotalHoursBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalHours("");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"00:00:00", "00:00:00", "00:00:00"})
	void testGetTotalHoursBoundryp(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours==0);
	}
	
	@Test
	void testGetTotalHoursBoundry() {
		int hours = Time.getTotalHours("00:00:00");
		assertTrue("Then hours were not calculated accurately", hours==0);
	}
	
	/**
	 * Test method for {@link time.Time#getTotalMinutes(java.lang.String)}.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"05:05:45", "05:05:55", "05:05:59"})
	void testGetTotalMinutesGoodp(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==5);
	}
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("06:10:34");
		assertTrue("Then minutes were not calculated accurately", minutes==10);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("00");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:00:00", "00:00:00", "00:00:00"})
	void testGetTotalMinutesBoundryp(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==0);
	}
	
	@Test
	void testGetTotalMinutesBoundry() {
		int minutes = Time.getTotalMinutes("06:10:34");
		assertTrue("Then minutes were not calculated accurately", minutes==10);
	}

}
