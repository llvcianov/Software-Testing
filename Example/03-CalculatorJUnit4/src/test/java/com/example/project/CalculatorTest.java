package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	Calculator c;
	
	@BeforeClass
	public static void start() {
		System.out.println("All'inizio della classe di test");
	}
	
	@Before
	public void precond() {
		System.out.println("All'inizio di ogni test");
		c= new Calculator();
		assumeNotNull(c);
	}
	
	@After
	public void postcond() {
		System.out.println("Alla fine di ogni test");
		c=null;
		assumeTrue(c==null);
	}
	
	@AfterClass
	public static void end() {
		System.out.println("Alla fine dei test");
	}
	
	
	@Test
	public void testAdd() {
		System.out.println("test");
		//INPUT
		int a=22;
		int b=20;
		
		//ELABORAZIONE
		int s=c.add(a, b);
		
		assertEquals("Somma errata",42,s);		
	}

	@Test
	public void testDivision() {
		System.out.println("test");
		//INPUT
		int a=1000;
		int b=3;
		
		//ELABORAZIONE
		float s=c.division(a, b);
		
		//assertEquals("Divisione errata",0.3333,s);
		//SOLUZIONE CON ACCURACY RELATIVA
		//assertTrue("Divisione errata",(Math.abs(333.3333-s)/333.3333)<accuracy);
		assertEquals("Divisione errata",333.3333,s,0.0001);
	}

	@Test
	public void testDivideBy2() {
		System.out.println("test");
		int num =5;
		int den = 2;
		float s=c.division(num,den);
		assertEquals("Divisione errata",2.5,s,0.01);
	}

	@Test
	public void testDivideBy2Bis() {
		System.out.println("test");
		int num =8;
		int den = 2;
		float s=c.division(num,den);
		assertEquals("Divisione errata",4,s,0.01);
	}
}
