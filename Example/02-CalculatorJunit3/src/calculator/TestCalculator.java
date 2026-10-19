package calculator;

import junit.framework.TestCase;

public class TestCalculator extends TestCase {

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

	public void testAdd() {
		//INPUT
		int a=22;
		int b=20;
		
		//ELABORAZIONE
		int s=c.add(a, b);
		
		assertEquals("Error in adding",42,s);
		
	}

	public void testAdd2() {
		//INPUT
		int a=41;
		int b=-5;
		
		//ELABORAZIONE
		int s=c.add(a, b);
		
		assertEquals("Error in adding",36,s);
		
	}
	
	
	
}
