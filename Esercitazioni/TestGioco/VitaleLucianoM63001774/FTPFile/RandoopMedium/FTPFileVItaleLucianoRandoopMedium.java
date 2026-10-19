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
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

public class TestFTPFile {
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
  
  	//Costruttore vuoto
	@Test
	public void Test1() {
		FTPFile file = new FTPFile();
		assertNotNull(file);
	}
	
	//Get e Set RawListing
	@Test
	public void Test2() {
		FTPFile file = new FTPFile();
		file.setRawListing("ciao");
		assertEquals("ciao",file.getRawListing());
	}
	
	//isDirectory default
	@Test
	public void Test3() {
		FTPFile file = new FTPFile();
		assertEquals(false,file.isDirectory());
	}
	
	//isFile default
	@Test
	public void Test4() {
		FTPFile file = new FTPFile();
		assertEquals(false,file.isFile());
	}
	
	//isSymbolicLink default
	@Test
	public void Test5() {
		FTPFile file = new FTPFile();
		assertEquals(false,file.isSymbolicLink());
	}
	
	//isUnknown default
	@Test
	public void Test6() {
		FTPFile file = new FTPFile();
		assertEquals(true,file.isUnknown());
	}
	
	//isValid default
	@Test
	public void Test7() {
		FTPFile file = new FTPFile();
		assertEquals(true,file.isValid());
	}
	
	//Get e Set type
	@Test
	public void Test8() {
		FTPFile file = new FTPFile();
		file.setType(7);
		assertEquals(7,file.getType());
	}
	
	//isDirectory con type = 1
	@Test
	public void Test9() {
		FTPFile file = new FTPFile();
		file.setType(1);
		assertEquals(true,file.isDirectory());
	}
	
	//isFile con type = 0
	@Test
	public void Test10() {
		FTPFile file = new FTPFile();
		file.setType(0);
		assertEquals(true,file.isFile());
	}
	
	//isSymbolicLink con type = 2
	@Test
	public void Test11() {
		FTPFile file = new FTPFile();
		file.setType(2);
		assertEquals(true,file.isSymbolicLink());
	}
	
	//isUnknown con type = 7
	@Test
	public void Test12() {
		FTPFile file = new FTPFile();
		file.setType(7);
		assertEquals(false,file.isUnknown());
	}
	
	//Get e Set Name
	@Test
	public void Test13() {
		FTPFile file = new FTPFile();
		file.setName("pippo");
		assertEquals("pippo",file.getName());
	}
	
	//Get e Set size
	@Test
	public void Test14() {
		FTPFile file = new FTPFile();
		file.setSize(123456789);
		assertEquals(123456789,file.getSize());
	}
	
	//Get e Set HardLinkCount
	@Test
	public void Test15() {
		FTPFile file = new FTPFile();
		file.setHardLinkCount(9);
		assertEquals(9,file.getHardLinkCount());
	}
	
	//Get e Set Group
	@Test
	public void Test16() {
		FTPFile file = new FTPFile();
		file.setGroup("myGroup");
		assertEquals("myGroup",file.getGroup());
	}
	
	//Get e Set User
	@Test
	public void Test17() {
		FTPFile file = new FTPFile();
		file.setUser("Me");
		assertEquals("Me",file.getUser());
	}
	
	//Get e Set Link
	@Test
	public void Test18() {
		FTPFile file = new FTPFile();
		file.setLink("link");
		assertEquals("link",file.getLink());
	}
	
	//Get e Set TimeStamp
	@Test
	public void Test19() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1);
		file.setTimestamp(data);
		assertEquals(data,file.getTimestamp());
	}
	
	//Has e Set permission
	@Test
	public void Test20() {
		FTPFile file = new FTPFile();
		file.setPermission(1, 2, true);
		assertEquals(true,file.hasPermission(1, 2));
	}
	
	//toString(
	@Test
	public void Test21() {
		FTPFile file = new FTPFile();
		assertEquals(null,file.toString());
	}
	
	//toFormattedString default
	@Test
	public void Test22() {
		FTPFile file = new FTPFile();
		assertEquals("?---------    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con timestamp e custom timezone
	@Test
	public void Test23() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-02-28 16:00:00.000 GMT-08:00 null",file.toFormattedString("GMT-8:00"));
	}
	
	//toFormattedString  con timestamp e timezone null
	@Test
	public void Test24() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 00:00:00.000 UTC null",file.toFormattedString());
	}
	
	//toFormattedString con timestamp e timezone uguali
	@Test
	public void Test25() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 01:00:00.000 CET null",file.toFormattedString("Europe/Rome"));
	}
	
	//toFormattedString con timestamp e Hour of day unsetted
	@Test
	public void Test26() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		data.clear(data.HOUR_OF_DAY);
        file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 null",file.toFormattedString());
	}
	
	//toFormattedString con timestamp e minute unsetted
	@Test
	public void Test27() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		data.clear(data.MINUTE);
        file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 00 UTC null",file.toFormattedString());
	}
	
	//toFormattedString con timestamp e second unsetted
	@Test
	public void Test28() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		data.clear(data.SECOND);
        file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 00:00 UTC null",file.toFormattedString());
	}
	
	//toFormattedString con timestamp e millisecond unsetted
	@Test
	public void Test29() {
		FTPFile file = new FTPFile();
		Calendar data = Calendar.getInstance();
		data.set(2025, Calendar.MARCH, 1, 0, 0, 0); 
		data.set(java.util.Calendar.MILLISECOND, 0); 
		data.clear(data.MILLISECOND);
        file.setTimestamp(data);
		assertEquals("?---------    0                         -1 2025-03-01 00:00:00 UTC null",file.toFormattedString());
	}
	
	//toFormattedString con type = 0 
	@Test
	public void Test30() {
		FTPFile file = new FTPFile();
		file.setType(0);
		assertEquals("----------    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con type = 1 
	@Test
	public void Test31() {
		FTPFile file = new FTPFile();
		file.setType(1);
		assertEquals("d---------    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con type = 2 
	@Test
	public void Test32() {
		FTPFile file = new FTPFile();
		file.setType(2);
		assertEquals("l---------    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con read permission
	@Test
	public void Test33() {
		FTPFile file = new FTPFile();
		file.setPermission(1, 0, true);
		assertEquals("?---r-----    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con write permission
	@Test
	public void Test34() {
		FTPFile file = new FTPFile();
		file.setPermission(1, 1, true);
		assertEquals("?----w----    0                         -1 null",file.toFormattedString());
	}
	
	//toFormattedString con executable permission
	@Test
	public void Test35() {
		FTPFile file = new FTPFile();
		file.setPermission(1, 2, true);
		assertEquals("?-----x---    0                         -1 null",file.toFormattedString());
	}
	
	//Costruttore con parametro
	@Test
	public void Test36() {
		FTPFile file = new FTPFile("rawListing");
		assertNotNull(file);
	}
	
	//is valid con Costruttore con parametro
	@Test
	public void Test37() {
		FTPFile file = new FTPFile("rawListing");
		assertEquals(false,file.isValid());
	}
	
	//hasPermission con Costruttore con parametro
	@Test
	public void Test38() {
		FTPFile file = new FTPFile("rawListing");
		assertEquals(false,file.hasPermission(0, 0));
	}
	
	//toFormattedString con Costruttore con parametro
	@Test
	public void Test39() {
		FTPFile file = new FTPFile("rawListing");
		assertEquals("[Invalid: could not parse file entry]",file.toFormattedString());
	}
	
}

						