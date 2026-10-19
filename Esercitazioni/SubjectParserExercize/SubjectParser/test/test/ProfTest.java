package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ClassUnderTest.SubjectParser;

public class ProfTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubjectParser() {
		new SubjectParser("2023 sw testing (2/10)");
	}
	
	// INIZIO TEST GETID
	@Test
	public void testGetId() {
		// Caso di test 0: Stringa valida con identificatore numerico
        SubjectParser subjectParser = new SubjectParser("2023 sw testing (2/10)");
        // mi prendo l'identificatore numerico (sarà di tipo long)
        long id = subjectParser.getId();
        assertEquals(2023L, id);
	}
	
	@Test
	public void testGetId1() {
		// Caso di test 1: Stringa senza identificatore numerico
        SubjectParser subjectParser1 = new SubjectParser("sw testing (2/10)");
        assertEquals(-1, subjectParser1.getId());
	}
	
	@Test
	public void testGetId2() {
		// Caso di test 2: Stringa con identificatore numerico non valido
        SubjectParser subjectParser2 = new SubjectParser("2023sw testing (2/10)");
        assertEquals(-1, subjectParser2.getId());
	}
	
	// INIZIO TEST THIS RANGE (LOWER RANGE)
	@Test
	public void testGetThisRange() {
		// Caso di test 0: Assumo che il LowerRange di default sia 1
		SubjectParser subjectParser = new SubjectParser("2023 sw testing");
	    assertEquals(1, subjectParser.getThisRange());
	}
	
	@Test
	public void testGetThisRange1() {
	    // Caso di test 1: Stringa con formato non valido
	    SubjectParser subjectParser1 = new SubjectParser("sw testing");
	    assertNotNull(subjectParser1.getThisRange());
	}
	
	@Test
	public void testGetThisRange2() {
		// Caso di test 2: Stringa con range specificato
	    SubjectParser subjectParser2 = new SubjectParser("2023 sw testing (3/8)");
	    assertEquals(3, subjectParser2.getThisRange());
	}
	
	@Test
	public void testGetThisRange3() {
		// Caso di test 3: Stringa valida con range specificato con parentesi quadre
	    SubjectParser subjectParser3 = new SubjectParser("2023 sw testing [3/8]");
	    assertEquals(3, subjectParser3.getThisRange());
	}
	
	// INIZIO TEST UPPER RANGE
	@Test
	public void testGetUpperRange() {
		// Caso di test 0: Assumo che l'UpperRange di default sia 1
		SubjectParser subjectParser = new SubjectParser("2023 sw testing");
		assertEquals(1, subjectParser.getUpperRange());
	}
	
	@Test
	public void testGetUpperRange1() {
	    // Caso di test 1: Stringa con formato non valido
	    SubjectParser subjectParser1 = new SubjectParser("sw testing");
	    assertNotNull(subjectParser1.getThisRange());
	}
	
	@Test
	public void testGetUpperRange2() {
		// Caso di test 2: Stringa con range specificato
	    SubjectParser subjectParser2 = new SubjectParser("2023 sw testing (3/8)");
	    assertEquals(8, subjectParser2.getUpperRange());
	}
	
	@Test
	public void testGetUpperRange3() {
		// Caso di test 3: Stringa valida con range specificato con parentesi quadre
	    SubjectParser subjectParser2 = new SubjectParser("2023 sw testing [3/8]");
	    assertEquals(8, subjectParser2.getUpperRange());
	}
	
	// INIZIO TEST RANGE STRING
	@Test
	public void testGetRangeString() {
		SubjectParser subjectParser = new SubjectParser("2023 sw testing");
		assertEquals(null, subjectParser.getRangeString());
	}
	
	// INIZIO TEST GET TITLE
	@Test
	public void testGetTitle() {
		// Caso 0: nella stringa in ingresso non è specificato il range (null)
		SubjectParser subjectParser = new SubjectParser(null);	
		assertNull(subjectParser.getTitle());
		// ATTENZIONE: in JUnit 4 e' una assertNull anzichè assertThrows poichè l'eccezione è gestita nel metodo getTile(), che al termine della sua gestione ritorna null
		//assertThrows sarebbe servita in assenza di catch. JUnit 5 invece sarebbe stata in grado di intercettarla e si sarebbe potuta scrivere un'asserzione sul tipo di eccezione
        //assertThrows(java.lang.NullPointerException.class,()->subjectParser.getTitle());		
	}
	
	@Test
	public void testGetTitle1() {
		// Caso 1: ultimo carattere )
		SubjectParser subjectParser1 = new SubjectParser("2023 sw testing )");
	    String result = subjectParser1.getTitle();
	    assertNotNull(result);
	    assertTrue(result.contains(")"));
	}
	
	@Test
	public void testGetTitle2() {
		// Caso 3: ultimo carattere ]
		SubjectParser subjectParser2 = new SubjectParser("2023 sw testing ]");
	    String result = subjectParser2.getTitle();
	    assertNotNull(result);
	    assertTrue(result.contains("]"));
	}
	
	@Test
	public void testGetTitle3() {
		// Caso 4: ()
		SubjectParser subjectParser3 = new SubjectParser("2023 sw testing ()");
	    String result = subjectParser3.getTitle();
	    assertNotNull(result);
	}
	
	@Test
	public void testGetTitle4() {
		// Caso 5: []
		SubjectParser subjectParser4 = new SubjectParser("2023 sw testing []");
	    String result = subjectParser4.getTitle();
	    assertNotNull(result);
	}
	

	@Test
	public void testGetTitle5() {
		// Caso 5: Double range
		SubjectParser subjectParser4 = new SubjectParser("2023 sw testing (3/4)[4/5]");
	    String result = subjectParser4.getTitle();
	    assertNotNull(result);
	}
}
