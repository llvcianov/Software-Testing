package calculator;

import junit.framework.TestCase;

public class TestDivision extends TestCase {

	Calculator c;
	protected void setUp() throws Exception {
		c=new Calculator();
		
		//PRECONDIZIONE
		assertNotNull(c);
	}

	protected void tearDown() throws Exception {
		c=null;
		
		//POSTCONDIZIONE
		assertNull(c);
	}

	public void testDivision(){
		
		int a=15,b=2;
		double s=c.division(a,b);
		assertEquals("Division Error",7.5,s);
	}
	
	public void testDivisionDelta(){
		
		int a=8,b=3;
		double s=c.division(a,b);
		assertEquals("Division Error",2.66,s,0.01);
	}
	
	public void testDivisionZero(){
		
		int a=8,b=0;
		double s=c.division(a,b);
		assertEquals("Division Error",Double.POSITIVE_INFINITY,s);
	}
}
