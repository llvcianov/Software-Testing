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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestTimeStamp {
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
  
  	//Costruttore con long ntpTime
	@Test
	public void Test1() {
		TimeStamp prova = new TimeStamp(946684800000L);
		assertNotNull(prova);
		assertEquals(946684800000L,prova.ntpValue());	
	}
	
	//Costruttore con hexStamp
	@Test
	public void Test2() {
		TimeStamp prova = new TimeStamp("d1a089bd.fc904f6d");
		assertNotNull(prova);
		assertEquals(-3341519474429767827L,prova.ntpValue());	
	}
	
	//Costruttore con date null
	@Test
	public void Test3() {
		Date d = null;
		TimeStamp prova = new TimeStamp(d);
		assertNotNull(prova);	
		assertEquals(0,prova.ntpValue());	
	}
	
	//Costruttore con date 
	@Test
	public void Test4() {
		long timestamp = 946684800000L;
		Date specificDate = new Date(timestamp);
		TimeStamp prova = new TimeStamp(specificDate);
		assertNotNull(prova);	
		assertEquals(-4893229164858966016L,prova.ntpValue());	
	}
	
	//Get Seconds
	@Test
	public void Test5() {
		TimeStamp prova = new TimeStamp(946684800000L);
		assertEquals(220,prova.getSeconds());
	}
	
	//Get Seconds
	@Test
	public void Test6() {
		TimeStamp prova = new TimeStamp(946684800000L);
		assertEquals(1791994880,prova.getFraction());
	}
	
	//Get Time senza argomenti
	@Test
	public void Test7() {
		TimeStamp prova = new TimeStamp(946684800000L);
		assertEquals(2085978716417L,prova.getTime());
	}
	
	//Get Time msb = 1
	@Test
	public void Test8() {
		TimeStamp prova = new TimeStamp(0);
		assertEquals(-61505152000L,prova.getTime(Long.MAX_VALUE + 1));
	}
	
	//Get Time msb = 0
	@Test
	public void Test9() {
		TimeStamp prova = new TimeStamp(0);
		assertEquals(2085978496000L,prova.getTime(0));
	}
	
	//getCurrentTime
	@Test
	public void Test10() {
		TimeStamp prova = new TimeStamp(0);
		assertEquals(TimeStamp.getNtpTime(System.currentTimeMillis()),prova.getCurrentTime());
	}
	
	//decodeNtpHexString con parametro null
	@Test
	public void Test11() {
		String s = null;
		Exception e = assertThrows(java.lang.NumberFormatException.class,()-> new TimeStamp(s));	
		assertEquals("null", e.getMessage());
	}
	
	//decodeNtpHexString con parametro 0
	@Test
	public void Test12() {
		String s = "0";
		TimeStamp prova = new TimeStamp(s);
		assertEquals(0,prova.ntpValue());
	}
	
	//decodeNtpHexString con parametro stringa vuota
	@Test
	public void Test13() {
		String s = "";
		TimeStamp prova = new TimeStamp(s);
		assertEquals(0,prova.ntpValue());
	}
	
	//parseNtpString
	@Test
	public void Test14() {
		String s = "d1a089bd.fc904f6d";
		TimeStamp prova = new TimeStamp(0);
		TimeStamp prova1 = prova.parseNtpString(s);
		assertEquals(-3341519474429767827L,prova1.ntpValue());
	}
	
	//toNtpTime con data > Febbraio 2036
	@Test
	public void Test15() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(2036, java.util.Calendar.MARCH, 1, 0, 0, 0);  // 1 marzo 2036
        calendar.set(java.util.Calendar.MILLISECOND, 0); 
        Date date = calendar.getTime();
		TimeStamp prova = new TimeStamp(date);
		assertEquals("Sat, Mar 01 2036 00:00:00.000",prova.toDateString());
	}
	
	//hashcode
	@Test
	public void Test16() {
		TimeStamp prova = new TimeStamp(Integer.MAX_VALUE);
		assertEquals(2147483647,prova.hashCode());
	}
	
	//equals 
	@Test
	public void Test17() {
		TimeStamp prova = new TimeStamp(Integer.MAX_VALUE);
		TimeStamp prova1 = new TimeStamp(0);
		assertEquals(false,prova.equals(prova1));
	}
	
	//equals con oggetto non TimeStamp
	@Test
	public void Test18() {
		TimeStamp prova = new TimeStamp(0);
		Integer a = 0;
		assertEquals(false,prova.equals(a));
	}
	
	//toString senza parametri
	@Test
	public void Test19() {
		TimeStamp prova = new TimeStamp(0);
		assertEquals("00000000.00000000",prova.toString());
	}
	
	//toUTCString
	@Test
	public void Test20() {
		TimeStamp prova = new TimeStamp(0);
		assertEquals("Thu, Feb 07 2036 06:28:16.000 UTC",prova.toUTCString());
	}
	
	//compareTo con TimeStamp maggiore
	@Test
	public void Test21() {
		TimeStamp prova = new TimeStamp(0);
		TimeStamp prova1 = new TimeStamp(Integer.MAX_VALUE);
		assertEquals(-1,prova.compareTo(prova1));
	}
	
	//compareTo con TimeStamp uguali
	@Test
	public void Test22() {
		TimeStamp prova = new TimeStamp(0);
		TimeStamp prova1 = new TimeStamp(0);
		assertEquals(0,prova.compareTo(prova1));
	}
	
	//compareTo con TimeStamp minore
	@Test
	public void Test23() {
		TimeStamp prova = new TimeStamp(Integer.MAX_VALUE);
		TimeStamp prova1 = new TimeStamp(0);
		assertEquals(1,prova.compareTo(prova1));
	}
	
}

						