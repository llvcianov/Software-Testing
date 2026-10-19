/*Compila i campi "Nome" e "Cognome" con le informazioni richieste
Nome: "Luciano"
Cognome: "Vitale"
Username: lucianovitale.99@gmail.com
UserID: 5
Date: 19/11/2024
*/

import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOutputFormat {
	@BeforeClass
	public static void setUpClass() {
		// Eseguito una volta prima dell'inizio dei test nella classe
		// Inizializza risorse condivise 
		// o esegui altre operazioni di setup
	}
				
	@AfterClass
	public static void tearDownClass() {
		// Eseguito una volta alla fine di tutti i test nella classe
		// Effettua la pulizia delle risorse condivise 
		// o esegui altre operazioni di teardown
	}
				
	@Before
	public void setUp() {
		// Eseguito prima di ogni metodo di test
		// Preparazione dei dati di input specifici per il test
	}
				
	@After
	public void tearDown() {
		// Eseguito dopo ogni metodo di test
		// Pulizia delle risorse o ripristino dello stato iniziale
	}
				
	@Test
	public void testMetodo() {
		// Preparazione dei dati di input
		// Esegui il metodo da testare
		// Verifica l'output o il comportamento atteso
		// Utilizza assert per confrontare il risultato atteso 
		// con il risultato effettivo
	}
				
	// Aggiungi altri metodi di test se necessario
  
  	//Costruttore Vuoto
	@Test
	public void Test1() {
		OutputFormat prova = new OutputFormat();
		assertNotNull(prova);
		
	}
	
	//Costruttore con 1 argomento
	@Test
	public void Test2() {
		OutputFormat prova = new OutputFormat("MyIndent");
		assertNotNull(prova);
		assertEquals("MyIndent",prova.getIndent());	
	}
	
	//Costruttore con 2 argomenti
	@Test
	public void Test3() {
		OutputFormat prova = new OutputFormat("MyIndent",true);
		assertNotNull(prova);
		assertEquals("MyIndent",prova.getIndent());
		assertEquals(true,prova.isNewlines());
	}
	
	//Costruttore con 3 argomenti
	@Test
	public void Test4() {
		OutputFormat prova = new OutputFormat("MyIndent",true,"MyEncoding");
		assertNotNull(prova);
		assertEquals("MyIndent",prova.getIndent());
		assertEquals(true,prova.isNewlines());
		assertEquals("MyEncoding",prova.getEncoding());
	}
	
	//Get e Set Separator
	@Test
	public void Test5() {
		OutputFormat prova = new OutputFormat();
		prova.setLineSeparator("MySeparator");
		assertEquals("MySeparator",prova.getLineSeparator());
	}
	
	//Get e Set NewLine
	@Test
	public void Test6() {
		OutputFormat prova = new OutputFormat();
		prova.setNewlines(false);
		assertEquals(false,prova.isNewlines());
	}
	
	//OmitEncoding
	@Test
	public void Test7() {
		OutputFormat prova = new OutputFormat();
		assertEquals(false,prova.isOmitEncoding());
	}
	
	//Set e OmitEncoding
	@Test
	public void Test8() {
		OutputFormat prova = new OutputFormat();
		prova.setEncoding("MyEncoding");
		assertEquals(false,prova.isOmitEncoding());
	}
	
	//Set Null Encoding
	@Test
	public void Test9() {
		OutputFormat prova = new OutputFormat();
		prova.setEncoding(null);
		assertEquals(false,prova.isOmitEncoding());
	}
	
	//SetOmitEncoding
	@Test
	public void Test10() {
		OutputFormat prova = new OutputFormat();
		prova.setOmitEncoding(true);
		assertEquals(true,prova.isOmitEncoding());
	}
	
	//Get e Set SuppressDeclaration
	@Test
	public void Test11() {
		OutputFormat prova = new OutputFormat();
		prova.setSuppressDeclaration(false);
		assertEquals(false,prova.isSuppressDeclaration());
	}
	
	//Get e Set NewLineAfterDeclaration
	@Test
	public void Test12() {
		OutputFormat prova = new OutputFormat();
		prova.setNewLineAfterDeclaration(false);
		assertEquals(false,prova.isNewLineAfterDeclaration());
	}
	
	//Get e Set ExpandEmptyElements
	@Test
	public void Test13() {
		OutputFormat prova = new OutputFormat();
		prova.setExpandEmptyElements(false);
		assertEquals(false,prova.isExpandEmptyElements());
	}
	
	// Get e Set TrimText
	@Test
	public void Test14() {
		OutputFormat prova = new OutputFormat();
		prova.setTrimText(true);
		assertEquals(true,prova.isTrimText());
	}
	
	// Get e Set PadText
	@Test
	public void Test15() {
		OutputFormat prova = new OutputFormat();
		prova.setPadText(true);
		assertEquals(true,prova.isPadText());
	}
	
	// SetIndent length <= 0
	@Test
	public void Test16() {
		OutputFormat prova = new OutputFormat();
		prova.setIndent("");
		assertEquals(null,prova.getIndent());
	}
	
	// SetIndent null
	@Test
	public void Test17() {
		OutputFormat prova = new OutputFormat();
		prova.setIndent(null);
		assertEquals(null,prova.getIndent());
	}
	
	// SetIndent Custom
	@Test
	public void Test18() {
		OutputFormat prova = new OutputFormat();
		prova.setIndent("MyIndent");
		assertEquals("MyIndent",prova.getIndent());
	}
	
	// SetIndent true
	@Test
	public void Test19() {
		OutputFormat prova = new OutputFormat();
		prova.setIndent(true);
		assertEquals("  ",prova.getIndent());
	}
	
	// SetIndent false
	@Test
	public void Test20() {
		OutputFormat prova = new OutputFormat();
		prova.setIndent(false);
		assertEquals(null,prova.getIndent());
	}
	
	//SetIndentSize
	@Test
	public void Test21() {
		OutputFormat prova = new OutputFormat();
		prova.setIndentSize(5);
		assertEquals("     ",prova.getIndent());
	}
	
	//Get e Set XHTML
	@Test
	public void Test22() {
		OutputFormat prova = new OutputFormat();
		prova.setXHTML(true);
		assertEquals(true,prova.isXHTML());
	}
	
	//Get e Set NewLineAfterNTags
	@Test
	public void Test23() {
		OutputFormat prova = new OutputFormat();
		prova.setNewLineAfterNTags(4);
		assertEquals(4,prova.getNewLineAfterNTags());
	}
	
	//Get e Set AttributeQuoteCharacter '\''
	@Test
	public void Test24() {
		OutputFormat prova = new OutputFormat();
		prova.setAttributeQuoteCharacter('\'');
		assertEquals('\'',prova.getAttributeQuoteCharacter());
	}
	
	//Get e Set AttributeQuoteCharacter '"'
	@Test
	public void Test25() {
		OutputFormat prova = new OutputFormat();
		prova.setAttributeQuoteCharacter('"');
		assertEquals('"',prova.getAttributeQuoteCharacter());
	}
	
	//Invalid AttributeQuoteCharacter
	@Test
	public void Test26() {
		OutputFormat prova = new OutputFormat();
		Exception e = assertThrows(java.lang.IllegalArgumentException.class,()->prova.setAttributeQuoteCharacter('a'));	
		assertEquals("Invalid attribute quote character " + "(a)", e.getMessage());
	}
	
	//parseOptions -suppressDeclaration
	@Test
	public void Test27() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-suppressDeclaration"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isSuppressDeclaration());
	}
	
	//parseOptions -omitEncoding
	@Test
	public void Test28() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-omitEncoding"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isOmitEncoding());
	}
	
	//parseOptions -indent
	@Test
	public void Test29() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-indent",""};
		assertEquals(2,prova.parseOptions(vett, 0));
		assertEquals(null,prova.getIndent());
	}
	
	//parseOptions -indentSize
	@Test
	public void Test30() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-indentSize","1"};
		assertEquals(2,prova.parseOptions(vett, 0));
		assertEquals(" ",prova.getIndent());
	}
	
	//parseOptions -expandEmpty
	@Test
	public void Test31() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-expandEmpty"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isExpandEmptyElements());
	}
	
	//parseOptions -encoding
	@Test
	public void Test32() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-encoding",""};
		assertEquals(2,prova.parseOptions(vett, 0));
		assertEquals("",prova.getEncoding());
	}
	
	//parseOptions -newlines
	@Test
	public void Test33() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-newlines"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isNewlines());
	}
	
	//parseOptions -lineSeparator
	@Test
	public void Test34() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-lineSeparator",""};
		assertEquals(2,prova.parseOptions(vett, 0));
		assertEquals("",prova.getLineSeparator());
	}
	
	//parseOptions -trimText
	@Test
	public void Test35() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-trimText"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isTrimText());
	}
	
	//parseOptions -padText
	@Test
	public void Test36() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-padText"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isPadText());
	}
	
	//parseOptions -xhtml
	@Test
	public void Test37() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"-xhtml"};
		assertEquals(1,prova.parseOptions(vett, 0));
		assertEquals(true,prova.isXHTML());
	}
	
	//parseOptions -custom
	@Test
	public void Test38() {
		OutputFormat prova = new OutputFormat();
		String vett[] = {"Ueue"};
		assertEquals(0,prova.parseOptions(vett, 0));
	}
	
	//CreatePrettyPrint
	@Test
	public void Test39() {
		OutputFormat prova = new OutputFormat();
		OutputFormat pretty = prova.createPrettyPrint();
		assertEquals("  ",pretty.getIndent());
		assertEquals(true,pretty.isNewlines());
		assertEquals(true,pretty.isTrimText());
		assertEquals(true,pretty.isPadText());
	}
	
	//createCompactFormat
	@Test
	public void Test40() {
		OutputFormat prova = new OutputFormat();
		OutputFormat compact = prova.createCompactFormat();
		assertEquals(null,compact.getIndent());
		assertEquals(false,compact.isNewlines());
		assertEquals(true,compact.isTrimText());
	}
	
}

						