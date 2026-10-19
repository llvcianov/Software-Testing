import org.junit.*;
import static org.junit.Assert.*;

// Game: 1016
public class TimeStampTest {


	@Test(timeout = 4000)
	public void testParseNtpString() throws Throwable {
    	java.util.Date val = new java.util.Date(2016, 11, 1, 23, 42);
    	TimeStamp ts = new TimeStamp(val);

    	String result = String.valueOf(ts.parseNtpString(ts.toString()));
    	assertEquals("d1b3d1b8.00000000", result);
	}
  
  	@Test(timeout = 4000)
	public void testToUTCString3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	String result = ts.toUTCString();
    	assertEquals("Thu, Feb 07 2036 06:28:16.000 UTC", result); 
	}

	@Test(timeout = 4000)
	public void testToDateString3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	String result = ts.toDateString();
    	assertEquals("Thu, Feb 07 2036 07:28:16.000", result); 
	}

	@Test(timeout = 4000)
	public void testToStringDefault3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	String result = ts.toString();
    	assertEquals("00000000.00000000", result); 
	}

	@Test(timeout = 4000)
	public void testToStringWithArgument3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	String result = ts.toString(Long.MAX_VALUE);
    	assertEquals("7fffffff.ffffffff", result); 
	}

	@Test(timeout = 4000)
	public void testHashCode3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	int result = ts.hashCode();
  		int expected = 0;
    	assertEquals(expected, result); 
	}

	@Test(timeout = 4000)
	public void testParseNtpString1() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	String result = String.valueOf(ts.parseNtpString(ts.toString()));
    	assertEquals("00000000.00000000", result);
	}

	@Test(timeout = 4000)
	public void testGetFraction3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	long result = ts.getFraction();
    	assertEquals(0L, result);
	}

	@Test(timeout = 4000)
	public void testGetTime3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	long result = ts.getTime();
    	assertEquals(2085978496000L, result);
	}

	@Test(timeout = 4000)
	public void testGetSeconds3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	long result = ts.getSeconds();
    	assertEquals(0L, result);
	}

	@Test(timeout = 4000)
	public void testNtpValue3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	long result = ts.ntpValue();
    	assertEquals(0L, result);
	}

	@Test(timeout = 4000)
	public void testCompareTo3() throws Throwable {
    	java.util.Date val = null;
    	TimeStamp ts = new TimeStamp(val);

    	TimeStamp ts2 = new TimeStamp(42);

    	int result = ts.compareTo(ts2);
  		int expected = -1;
    	assertEquals(expected, result);
	}

  	@Test(timeout = 4000)
	public void test_6_1991_3() throws Throwable {
		java.util.Date val = null;
		TimeStamp ts = new TimeStamp(val);
		TimeStamp ts2 = new TimeStamp(42);
		assertEquals("1","" + ts2.compareTo(ts));
	}
  
  	@Test(timeout = 4000)
	public void test_6_1991_2() throws Throwable {
		java.util.Date val = null;
		TimeStamp ts = new TimeStamp(val);
		TimeStamp ts2 = new TimeStamp(42);
		assertEquals("falsetruefalse","" + ts.equals(ts2)+ ts.equals(ts) + ts2.equals(ts));
	}
  
  	@Test(timeout = 4000)
	public void test_7_1994() throws Throwable {
		TimeStamp ts = TimeStamp.getCurrentTime();
		TimeStamp ts2 = new TimeStamp(ts.toString());
		assertEquals("0","" + ts.compareTo(ts2));
	}
  	
	@Test(timeout = 4000)
	public void test_8_1999() throws Throwable {
		Long ts = TimeStamp.getCurrentTime().getTime();
		Long ts2 = TimeStamp.getCurrentTime().getTime();
		assertTrue(((ts2-ts)>=0));
	}
  
  	@Test(timeout = 4000)
	public void test_8_1999_2() throws Throwable {
		Long ts = TimeStamp.getCurrentTime().getTime();
		Long ts2 = TimeStamp.getCurrentTime().getTime();
		assertTrue(ts > 1471453130667l);
	}
  
	@Test(timeout = 4000)
	public void test_9_2001() throws Throwable {
		TimeStamp ts = new TimeStamp(42);
		assertTrue(ts instanceof java.io.Serializable);
	}
  	
  	@Test(timeout = 4000)
	public void test_9_2001_2() throws Throwable {
		TimeStamp ts = new TimeStamp(42);
		assertTrue(ts instanceof java.lang.Comparable);
	}
  
	@Test(timeout = 4000)
	public void test_11_2019() throws Throwable {
		long hex2time = TimeStamp.decodeNtpHexString("ffffffff");
		TimeStamp ts = new TimeStamp(hex2time);
		String result = ts.toUTCString(); 
		result += ts.decodeNtpHexString("f2f2f2f2.fafafafa");
	  	assertEquals("Thu, Feb 07 2036 06:28:15.000 UTC-940422246760252678",result);
	}

  
  	@Test(timeout = 4000)
	public void test_11_2019_2() throws Throwable {
		long hex2time = TimeStamp.decodeNtpHexString("ffffffff");
		TimeStamp ts = new TimeStamp(hex2time);
		String result = ts.toUTCString(); 
		result += ts.decodeNtpHexString("");
	  	assertEquals("Thu, Feb 07 2036 06:28:15.000 UTC0",result);
	}
  
  	@Test(timeout = 4000)
	public void test_11_2019_3() throws Throwable {
		long hex2time = TimeStamp.decodeNtpHexString("ffffffff");
		TimeStamp ts = new TimeStamp(hex2time);
		String result = ts.toUTCString(); 
		
		try{
			/*result += ts.decodeNtpHexString("f2f2f2f2.fafafafa");
			result += ts.decodeNtpHexString("");*/
			result += ts.decodeNtpHexString(null);
			fail();
		}
		catch(NullPointerException npe){}
		catch(java.lang.NumberFormatException e){}
	}

	@Test(timeout = 4000)
	public void test_12_2020() throws Throwable {
		TimeStamp ts = new TimeStamp(42);
		assertFalse(ts.equals("42"));
	}

}
