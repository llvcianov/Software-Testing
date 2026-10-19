package triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.Assert.*;

import org.junit.Test;

public class PairWiseExtendedTest {
	@ParameterizedTest
	@CsvFileSource(resources = "2WiseExtended.csv")	
	void testPairWiseExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
    }

