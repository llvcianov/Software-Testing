package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.*;

import org.junit.Before;
import org.junit.Test;

public class Calculator {

	//private static final float accuracy = (float) 1.0e-6;
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public float division (int a, int b) {
		return (float)a/ (float)b;
	}
	
	@Before
	public void precond() {
	}
	
	
	@Test
	public void testAdd() {
		//INPUT
		int a=22;
		int b=20;
		
		//ELABORAZIONE
		int s=add(a, b);
		
		assertEquals("Somma errata",42,s);		
	}

	@Test
	public void testDivision() {
		//INPUT
		int a=1000;
		int b=3;
		
		//ELABORAZIONE
		float s=division(a, b);
		
		//assertEquals("Divisione errata",0.3333,s);
		//SOLUZIONE CON ACCURACY RELATIVA
		//assertTrue("Divisione errata",(Math.abs(333.3333-s)/333.3333)<accuracy);
		assertEquals("Divisione errata",333.3333,s,0.0001);
	}

	@Test
	public void testDivideBy2() {
		int num =5;
		int den=2;
		float s=division(num,den);
		assertEquals("Divisione errata",2.5,s,0.01);
	}

	@Test
	public void testDivideBy2Bis() {
		int num =8;
		int den=2;
		float s=division(num,den);
		assertEquals("Divisione errata",4,s,0.01);
	}

}
