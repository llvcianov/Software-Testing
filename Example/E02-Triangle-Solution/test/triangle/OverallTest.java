package triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.Assert.*;

import org.junit.Test;

public class OverallTest {
    public int x;
    public int y;
    public int z;
    public Triangle t;


	@ParameterizedTest
	@CsvFileSource(resources = "ECC.csv")	
	public void testECC(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
    
	@ParameterizedTest
	@CsvFileSource(resources = "BCC.csv")	
	void testBCC(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "PairWise.csv")	
	void testPairWise(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "3WiseACOC.csv")	
	void testThreeWiseACOC(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}

	@ParameterizedTest
	@CsvFileSource(resources = "ECCExtended.csv")	
	void testECCExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
    
	@ParameterizedTest
	@CsvFileSource(resources = "BCCExtended.csv")	
	void testBCCExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "2WiseExtended.csv")	
	void testPairWiseExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "3WiseExtended.csv")	
	void testThreeWiseExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}

	@ParameterizedTest
	@CsvFileSource(resources = "OutputCoverage.csv")	
	void testOutputCoverage(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "InstructionCoverage.csv")	
	void testInstructionCoverage(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	




	@ParameterizedTest
	@CsvFileSource(resources = "DecisionTable.csv")	
	void testDecisionTable(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	

    }

