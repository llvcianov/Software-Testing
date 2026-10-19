// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 6; page ??
// JUnit for TriangleType.java

package triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

@RunWith(Theories.class)
public class TriangleTypeTheoryTest {

    @DataPoints("s1")
    public static int[] s1() {
         return new int[]{
                          -1,0,1,2,3,4,5,6,7,8};
    }

    @DataPoints("s2")
    public static int[] s2() {
         return new int[]{
                          -1,0,1,2,3,4,5,6,7,8};
    }
    
    @DataPoints("s3")
    public static int[] s3() {
         return new int[]{
                          -1,0,1,2,3,4,5,6,7,8};
    }
    
    @Theory
    public void triangularInequality1(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(a+b <= c);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }

    @Theory
    public void triangularInequality2(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(a+c <= b);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }

    @Theory
    public void triangularInequality3(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(b+c <= a);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }

    @Theory
    public void sideNegative1(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(a<=0);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }

    @Theory
    public void sideNegative2(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(b<=0);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }

    @Theory
    public void sideNegative3(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
  	  assumeTrue(c<=0);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : INVALID");
  	assertEquals("INVALID",t.toString());
    }
    
    @Theory
    public void equilateral(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
    //System.out.println(a+","+b+","+c+","+t+". Expected : EQUILATERAL");  
    assumeTrue(a>0 && b>0 && c>0);
    assumeTrue(a==b && b==c && a==c);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : EQUILATERAL");
  	assertEquals("EQUILATERAL",t.toString());
    }

    @Theory
    public void isosceles1(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
        assumeTrue(a>0 && b>0 && c>0);
    	assumeTrue(a==b && b!=c && a!=c);
    	assumeTrue(a+b > c);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : ISOSCELES");
  	assertEquals("ISOSCELES",t.toString());
    }

    @Theory
    public void isosceles2(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
        assumeTrue(a>0 && b>0 && c>0);
    	assumeTrue(a!=b && b!=c && a==c);
    	assumeTrue(a+c > b);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : ISOSCELES");
  	assertEquals("ISOSCELES",t.toString());
    }
    
    @Theory
    public void isosceles3(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
      assumeTrue(a>0 && b>0 && c>0);
  	  assumeTrue(a!=b && b==c && a!=c);
  	  assumeTrue(b+c > a);
	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : ISOSCELES");
  	assertEquals("ISOSCELES",t.toString());
    }
    
    @Theory
    public void scalene(@FromDataPoints("s1") int a, @FromDataPoints("s2") int b, @FromDataPoints("s3") int c) {
        assumeTrue(a>0 && b>0 && c>0);
    	assumeTrue(a!=b && b!=c && a!=c);
    	assumeTrue(b+c > a);
    	assumeTrue(a+b > c);
    	assumeTrue(a+c > b);


	Triangle t=TriangleType.triangle(a,b,c);
	System.out.println(a+","+b+","+c+","+t+". Expected : SCALENE");
  	assertEquals("SCALENE",t.toString());
    }

    }

