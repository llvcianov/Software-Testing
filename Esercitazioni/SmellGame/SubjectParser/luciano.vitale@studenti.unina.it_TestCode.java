import org.junit.*;
import static org.junit.Assert.*;
import java.lang.Thread;

// Game: 1015
public class SubjectParserTest {

	@Test(timeout = 4000)
	public void test_1_1847_1() throws Throwable {
		// test here!
		String input = " asd asd asd hello Hello HELLO test[] ()";
		SubjectParser sp = new SubjectParser(input);
	  	String verify = "" + sp.getUpperRange();
		assertEquals("1", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_1_1847_2() throws Throwable {
		// test here!
		String input = " asd asd asd hello Hello HELLO test[] ()";
		SubjectParser sp = new SubjectParser(input);
		String verify = "" + sp.getThisRange();
		assertEquals("1", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_1_1847_3() throws Throwable {
		// test here!
		String input = " asd asd asd hello Hello HELLO test[] ()";
		SubjectParser sp = new SubjectParser(input);
		String verify = "" + sp.getId();
		assertEquals("-1", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_1_1847_4() throws Throwable {
		// test here!
		String input = " asd asd asd hello Hello HELLO test[] ()";
		SubjectParser sp = new SubjectParser(input);
		String verify = "" + sp.getTitle();
		assertEquals("asd asd asd hello Hello HELLO test ", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_1_1847_5() throws Throwable {
		// test here!
		String input = " asd asd asd hello Hello HELLO test[] ()";
		SubjectParser sp = new SubjectParser(input);
		String verify = "" + sp.getRangeString();
		assertEquals("null", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_2_1849_4() throws Throwable {
		// test here!
		String input = " [hello] (world) , test";
		SubjectParser sp = new SubjectParser(input);
		String verify = "" + sp.getTitle();
		assertEquals("[hello] (world) , test", verify);
	}
  
	@Test(timeout = 4000)
	public void test_7_1908() throws Throwable {
		String input = "1 ((2)) (((3/4))) / 2/2/3/4 [42] (1)";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getUpperRange();
		assertEquals("4", verify);
	}
  	
  	@Test(timeout = 4000)
	public void test_7_1908_1() throws Throwable {
		String input = "1 ((2)) (((3/4))) / 2/2/3/4 [42] (1)";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getThisRange();
		assertEquals("3", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_7_1908_2() throws Throwable {
		String input = "1 ((2)) (((3/4))) / 2/2/3/4 [42] (1)";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getId();
		assertEquals("1", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_7_1908_3() throws Throwable {
		String input = "1 ((2)) (((3/4))) / 2/2/3/4 [42] (1)";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getTitle();
		assertEquals("((2)) (()) / 2/2/3/4  ", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_7_1908_4() throws Throwable {
		String input = "1 ((2)) (((3/4))) / 2/2/3/4 [42] (1)";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getRangeString();
		assertEquals("(3/4)", verify);
	}

	@Test(timeout = 4000)
	public void test_11_1942() throws Throwable {
		String input = "0 [11/42/720]";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
	  
		verify = "" + sp.getUpperRange();
		assertEquals("42", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_11_1942_1() throws Throwable {
		String input = "0 [11/42/720]";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		
		verify = "" + sp.getThisRange();
		assertEquals("11", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_11_1942_2() throws Throwable {
		String input = "0 [11/42/720]";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		verify = "" + sp.getId();
		assertEquals("0", verify);
	}
  
  	@Test(timeout = 4000)
	public void test_11_1942_3() throws Throwable {
		String input = "0 [11/42/720]";
		SubjectParser sp = new SubjectParser(input);
		String verify = "";
		verify = "" + sp.getTitle();
		assertEquals("", verify);
	}

}
