import org.junit.*;
import static org.junit.Assert.*;
import java.lang.Thread;

// Game: 1005
public class FTPFileTest {

    public FTPFileTest(){
      FTPFile f = new FTPFile();
    }
  
	@Test(timeout = 4000)
	public void test_1_451() throws Throwable {
		FTPFile f = new FTPFile();
		String raw = f.getRawListing();
		assertEquals(null, raw);
	}

	@Test(timeout = 4000)
	public void test_2_453() throws Throwable {
		FTPFile f = new FTPFile();
		String rawVal = "blue monkey";
		f.setRawListing(rawVal);
		String raw = f.getRawListing();		
		assertEquals(rawVal, raw);
	}

	@Test(timeout = 4000)
	public void test_3_455() throws Throwable {
		String rawVal = "blue monkey";
		FTPFile f = new FTPFile(rawVal);
		String raw = f.getRawListing();		
		assertEquals(rawVal, raw);
	}

	@Test(timeout = 4000)
	public void test_4_456() throws Throwable {
		FTPFile f = new FTPFile("");
		assertFalse(f.isValid());
	}

	@Test(timeout = 4000)
	public void test_5_457() throws Throwable {
		FTPFile f = new FTPFile();
		boolean type = f.isDirectory();
		assertEquals(false, type);
	}

	@Test(timeout = 4000)
	public void test_6_458() throws Throwable {
		FTPFile f = new FTPFile();
		boolean type = f.isSymbolicLink();
		assertEquals(false, type);
	}

	@Test(timeout = 4000)
	public void test_8_461() throws Throwable {
		String s = "test string";
		FTPFile f = new FTPFile(s);
		f.setType(FTPFile.FILE_TYPE);
		assertEquals(f.getType(), FTPFile.FILE_TYPE);
	}

	@Test(timeout = 4000)
	public void test_9_462() throws Throwable {
		FTPFile f = new FTPFile();
		f.setName("borat");
		assertEquals("borat", f.getName());
	}

	@Test(timeout = 4000)
	public void test_10_463() throws Throwable {
		String s = "test string";
		FTPFile f = new FTPFile(s);
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertEquals(f.getType(), FTPFile.DIRECTORY_TYPE);
	}

	@Test(timeout = 4000)
	public void test_11_464() throws Throwable {
		String s = "test string";
		FTPFile f = new FTPFile(s);
		f.setType(FTPFile.SYMBOLIC_LINK_TYPE);
		assertEquals(f.getType(), FTPFile.SYMBOLIC_LINK_TYPE);
	}

	@Test(timeout = 4000)
	public void test_13_466() throws Throwable {
		FTPFile f = new FTPFile();
		f.setGroup("borat");
		assertEquals("borat", f.getGroup());
	}

	@Test(timeout = 4000)
	public void test_16_469() throws Throwable {
		String s = "test string";
		FTPFile f = new FTPFile(s);
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertTrue(f.isDirectory());
	}

	@Test(timeout = 4000)
	public void test_17_472() throws Throwable {
		FTPFile f = new FTPFile("JAVA");
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertEquals("[Invalid: could not parse file entry]", formatted);
		
	}

	@Test(timeout = 4000)
	public void test_18_475() throws Throwable {
		FTPFile f = new FTPFile("JAVA");
		try{
		f.setPermission(FTPFile.FILE_TYPE,FTPFile.WRITE_PERMISSION,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertEquals("[Invalid: could not parse file entry]", formatted);
	}

	@Test(timeout = 4000)
	public void test_22_483() throws Throwable {
		FTPFile f = new FTPFile();
		try{
		f.setPermission(0,0,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertEquals("?r--------    0                         -1 null", formatted);
	}

	@Test(timeout = 4000)
	public void test_23_484() throws Throwable {
		FTPFile f = new FTPFile();
		assertFalse(f.hasPermission(FTPFile.GROUP_ACCESS, FTPFile.WRITE_PERMISSION));
	}

	@Test(timeout = 4000)
	public void test_24_488() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertTrue(f.isDirectory());
	}

	@Test(timeout = 4000)
	public void test_25_489() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		
		assertEquals(true, f.isDirectory());
	}

	@Test(timeout = 4000)
	public void test_28_497() throws Throwable {
		FTPFile f = new FTPFile();
		java.util.Calendar timestamp = new java.util.GregorianCalendar ();
		f.setTimestamp(timestamp);
		try{
		f.setPermission(0,0,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertTrue(formatted.startsWith("?r--------    0                         -1"));
	}

	@Test(timeout = 4000)
	public void test_30_501() throws Throwable {
		FTPFile f = new FTPFile();
		java.util.Calendar timestamp = new java.util.GregorianCalendar (2016,
                 2,
                 3,
                 4,
                 5,
                 6);
		f.setTimestamp(timestamp);
		try{
		f.setPermission(0,0,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertEquals("?r--------    0                         -1 2016-03-03 03:05:06.000 GMT null", formatted);
	}

	@Test(timeout = 4000)
	public void test_31_504() throws Throwable {
		FTPFile f = new FTPFile();
		java.util.Calendar timestamp = new java.util.GregorianCalendar (2016,
                 7,
                 3,
                 4,
                 5,
                 6);
		f.setName("jose");
		f.setTimestamp(timestamp);
		try{
		f.setPermission(0,0,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString("Returns a string representation of the FTPFile information.");
		assertEquals("?r--------    0                         -1 2016-08-03 02:05:06.000 GMT jose", formatted);
	}

	@Test(timeout = 4000)
	public void test_32_508() throws Throwable {
		FTPFile f = new FTPFile();
		java.util.Calendar timestamp = new java.util.GregorianCalendar (2016,
                 7,
                 3,
                 4,
                 5,
                 6);
		f.setName("jose");
		f.setTimestamp(timestamp);
		try{
		f.setPermission(1,0,true);
		}catch(NullPointerException npe){}
		String formatted = f.toFormattedString();
		assertEquals("?---r-----    0                         -1 2016-08-03 04:05:06 CEST jose", formatted);
	}

	@Test(timeout = 4000)
	public void test_33_510() throws Throwable {
		String rawVal = "blue monkey";
		FTPFile f = new FTPFile(rawVal);
		String raw = f.toString();		
		assertEquals(rawVal, raw);
	}

	@Test(timeout = 4000)
	public void test_35_536() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		String formatted = f.toFormattedString();
	  	assertEquals("d---------    0                         -1 null", formatted);
	}

	@Test(timeout = 4000)
	public void test_37_546() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.SYMBOLIC_LINK_TYPE);
		String formatted = f.toFormattedString();
		assertEquals("l---------    0                         -1 null", formatted);
	  	
	}

	@Test(timeout = 4000)
	public void test_40_549() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.SYMBOLIC_LINK_TYPE);
		assertTrue(f.isValid());
	}

	@Test(timeout = 4000)
	public void test_41_550() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.SYMBOLIC_LINK_TYPE);
		assertTrue(f.isSymbolicLink());
	}
  
  	@Test(timeout = 4000)
	public void test_41_550_2() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertFalse(f.isSymbolicLink());
	}

	@Test(timeout = 4000)
	public void test_42_552() throws Throwable {
		FTPFile f = new FTPFile();
		f.setSize(200);
		String expected = "?---------    0                        200 null";
		assertEquals(expected, f.toFormattedString());
	}
  
  	@Test(timeout = 4000)
	public void test_42_552_2() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.FILE_TYPE);
		String expected = "----------    0                         -1 null";
		assertEquals(expected, f.toFormattedString());
	}
  
  	 @Test(timeout = 4000)
	public void test_42_552_3() throws Throwable {
		FTPFile f = new FTPFile();
		f.setPermission(FTPFile.USER_ACCESS, FTPFile.EXECUTE_PERMISSION, true);
		String expected = "?--x------    0                         -1 null";
		assertEquals(expected, f.toFormattedString());
	}
  
  	@Test(timeout = 4000)
	public void test_42_552_4() throws Throwable {
		FTPFile f = new FTPFile();
		f.setPermission(FTPFile.GROUP_ACCESS, FTPFile.WRITE_PERMISSION, true);
		String expected = "?----w----    0                         -1 null";
		assertEquals(expected, f.toFormattedString());
	}
  
  	@Test(timeout = 4000)
	public void test_42_552_5() throws Throwable {
		FTPFile f = new FTPFile();
		f.setUser("TEST USER");
		String expected = "?---------    0 TEST USER                -1 null";
		assertEquals(expected, f.toFormattedString());
	}
  
	@Test(timeout = 4000)
	public void test_43_553() throws Throwable {
		FTPFile f = new FTPFile();
		assertTrue(f.isUnknown());
	}
  
  	@Test(timeout = 4000)
	public void test_43_553_2() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertFalse(f.isUnknown());
	}

	@Test(timeout = 4000)
	public void test_44_554() throws Throwable {
		FTPFile f = new FTPFile();
		assertFalse(f.isFile());
	}
  
  	@Test(timeout = 4000)
	public void test_44_554_2() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.FILE_TYPE);
		assertTrue(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_48_562() throws Throwable {
		FTPFile f = new FTPFile("TEST STRING");
		assertFalse(f.hasPermission(0,0));
	}

	@Test(timeout = 4000)
	public void test_49_566() throws Throwable {
		FTPFile f = new FTPFile();
		f.setRawListing("__hello__");
		assertEquals("__hello__", f.getRawListing());
	}

	@Test(timeout = 4000)
	public void test_50_567() throws Throwable {
		FTPFile f = new FTPFile();
		assertFalse(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_51_569() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.FILE_TYPE);
		assertTrue(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_52_570() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertFalse(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_53_571() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.SYMBOLIC_LINK_TYPE);
		assertFalse(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_54_572() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(-1);
		assertFalse(f.isFile());
	}

	@Test(timeout = 4000)
	public void test_56_574() throws Throwable {
		FTPFile ftp = new FTPFile();
		ftp.setHardLinkCount(2);
		ftp.setType(FTPFile.FILE_TYPE);
		assertTrue(ftp.isFile());
	}

	@Test(timeout = 4000)
	public void test_57_627() throws Throwable {
		FTPFile f = new FTPFile("");
		assertFalse(f.hasPermission(FTPFile.WORLD_ACCESS, FTPFile.WRITE_PERMISSION));
	}

	@Test(timeout = 4000)
	public void test_58_631() throws Throwable {
		FTPFile f = new FTPFile();
		f.setType(FTPFile.DIRECTORY_TYPE);
		assertEquals(FTPFile.DIRECTORY_TYPE, f.getType());
	}

	@Test(timeout = 4000)
	public void test_59_632() throws Throwable {
		
		String rawVal = null;
		FTPFile f = new FTPFile(rawVal);
		String raw = f.getRawListing();		
		assertEquals(rawVal, raw);
	}

	@Test(timeout = 4000)
	public void test_62_639() throws Throwable {
		FTPFile f = new FTPFile();
		f.setLink("www.google.com");
		assertEquals("www.google.com", f.getLink());
	}

	@Test(timeout = 4000)
	public void test_63_644() throws Throwable {
		FTPFile ftp = new FTPFile("test");
		ftp.setType(2);
		assertFalse(ftp.hasPermission(0,0));
	}

	@Test(timeout = 4000)
	public void test_64_646() throws Throwable {
		FTPFile ftp = new FTPFile();
		
		java.util.Calendar c = new java.util.GregorianCalendar(2016,8,5);
		ftp.setTimestamp(c);
		assertTrue(c.isSet(java.util.Calendar.YEAR));
	}

}
