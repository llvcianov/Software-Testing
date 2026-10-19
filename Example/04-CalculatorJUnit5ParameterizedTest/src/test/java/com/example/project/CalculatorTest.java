package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	private Calculator c;
	private float accuracy = (float) 1e-3;

	@BeforeEach
	void setUp() {
		c = new Calculator();
		assumeNotNull(c);
	}

	@AfterEach
	void tearDown() {
		c = null;
		assumeTrue(c == null);
	}

	@ParameterizedTest
	@CsvSource({ "-5,12,7", "0,-4,-4", "35,0,35" })
	void testAdd(int a, int b, int s) {
		System.out.println("Verifichiamo se la somma di " + a + " e " + b + " fa davvero " + s);
		assertEquals("Somma errata", s, c.add(a, b));
	}

	@ParameterizedTest
	@CsvSource({ "4,2,2", "5,2,2.5", "-5,3,-1.333", "3,0,0" })
	void testDivision(int a, int b, float d) {
		if (b != 0)
			assertEquals("Divisione errata", (float) a / b, c.division(a, b), 1e-5);
		else {
			assertTrue("Divisione errata", Float.isInfinite(c.division(a, b)));
			// assertThrows(ArithmeticException.class,()->c.divisione(a, b));
		}
	}

}
