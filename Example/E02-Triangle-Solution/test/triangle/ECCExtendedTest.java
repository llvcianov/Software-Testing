package triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.Assert.*;

import org.junit.Test;

public class ECCExtendedTest {
    public int x;
    public int y;
    public int z;
    public Triangle t;


	@ParameterizedTest
	@CsvFileSource(resources = "ECCExtended.csv")	
	void testECCExtended(int s1, int s2, int s3, String e) {
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
    
    }

