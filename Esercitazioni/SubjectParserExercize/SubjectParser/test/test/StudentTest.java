package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ClassUnderTest.SubjectParser;

public class StudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Esempio di test
	// Caso di test 0: Stringa valida con identificatore numerico
	@Test
	public void testGetId() {
        SubjectParser subjectParser = new SubjectParser("2023 sw testing (2/10)");
        // mi prendo l'identificatore numerico (sarà di tipo long)
        long id = subjectParser.getId();
        assertEquals(2023L, id);
	}

	
	// Caso di test 0.1: solo identificatore numerico
	@Test
	public void testGetId0_1() {
        SubjectParser subjectParser = new SubjectParser("2023");
        // mi prendo l'identificatore numerico (sarà di tipo long)
        long id = subjectParser.getId();
        assertEquals(2023L, id);
	}
		
	
	// Caso di test 0.2: identificatore numerico invalido
	@Test
	public void testGetId0_2() {
        SubjectParser subjectParser = new SubjectParser("@ sw testing (2/10)");
        // mi prendo l'identificatore numerico (sarà di tipo long)
        long id = subjectParser.getId();
        assertEquals(-1L, id);
	}

	
	// Caso di test 1: lower range in parentesi tonde
	@Test
	public void testGetThisRange1() {
        SubjectParser subjectParser = new SubjectParser("2023 sw testing (2/10)");
        int range = subjectParser.getThisRange();
        assertEquals(2, range);
	}
	
	
	// Caso di test 1.1: lower range con solo parentesi finale
	@Test
	public void testGetThisRange1_1() {
        SubjectParser subjectParser = new SubjectParser("2023 sw testing 2/10)");
        int range = subjectParser.getThisRange();
        assertEquals(1, range);
	}
	
	
	// Caso di test 1.3: lower range in parentesi quadre
	@Test
	public void testGetThisRange1_3() {	
        SubjectParser subjectParser = new SubjectParser("2023 sw testing [2/10]");
        int range = subjectParser.getThisRange();
        assertEquals(2, range);
	}
	
	
	// Caso di test 1.4: lower range con carattere ) nella stringa
	@Test
	public void testGetThisRange1_4() {	
        SubjectParser subjectParser = new SubjectParser("2023 sw testing) [6/10]");
        int range = subjectParser.getThisRange();
        assertEquals(6, range);
	}
	
	
	// Caso di test 2: upper range in parentesi tonde
	@Test
	public void testGetUpperRange2() {
        SubjectParser subjectParser = new SubjectParser("2023 sw testing (2/10)");
        int range = subjectParser.getUpperRange();
        assertEquals(10, range);
	}
	

	// Caso di test 3: carattere / mancante nel range
	@Test
	public void testGetTitle() {
		SubjectParser subjectParser = new SubjectParser("2023 sw testing (210)");
		int range = subjectParser.getUpperRange();
		assertEquals(1, range);
			
	}
	
	
	// Caso di test 4: prova eccezioni
	@Test
	public void testGetTitle2() {
		SubjectParser subjectParser = new SubjectParser(null);
		assertNull(subjectParser.getTitle());
		//assertEquals(1, range);
			
	}

	
	@Test
	public void testSubjectParser() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetRangeString() {
		fail("Not yet implemented");
	}

	




}
