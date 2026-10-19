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

public class TestHSLColor {
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
  
  	//get e set Hue
	@Test
	public void Test1() {	
		HSLColor c = new HSLColor(); 
		c.setHue(90);
		assertEquals(90,c.getHue());
	}
	
	//get e set Hue < 0
	@Test
	public void Test2() {	
		HSLColor c = new HSLColor(); 
		c.setHue(-90);
		assertEquals(165,c.getHue());
	}
	
	//get e set Hue > 255
	@Test
	public void Test3() {	
		HSLColor c = new HSLColor(); 
		c.setHue(360);
		assertEquals(105,c.getHue());
	}
	
	//get e set Saturation 
	@Test
	public void Test4() {	
		HSLColor c = new HSLColor(); 
		c.setSaturation(90);
		assertEquals(90,c.getSaturation());
	}
	
	//get e set Saturation < 0
	@Test
	public void Test5() {	
		HSLColor c = new HSLColor(); 
		c.setSaturation(-90);
		assertEquals(0,c.getSaturation());
	}
	
	//get e set Saturation > 255 0
	@Test
	public void Test6() {	
		HSLColor c = new HSLColor(); 
		c.setSaturation(360);
		assertEquals(255,c.getSaturation());
	}
	
	//get e set Luminence
	@Test
	public void Test7() {	
		HSLColor c = new HSLColor(); 
		c.setLuminence(90);
		assertEquals(90,c.getLuminence());
	}
	
	//get e set Luminence< 0
	@Test
	public void Test8() {	
		HSLColor c = new HSLColor(); 
		c.setLuminence(-90);
		assertEquals(0,c.getLuminence());
	}
	
	//get e set Luminence > 255 
	@Test
	public void Test9() {	
		HSLColor c = new HSLColor(); 
		c.setLuminence(360);
		assertEquals(255,c.getLuminence());
	}
	
	//getRed con initHSLbyRGB
	@Test
	public void Test10() {	
		HSLColor c = new HSLColor();
		c.initHSLbyRGB(255, 0, 0);
		assertEquals(255,c.getRed());
	}
	
	//getGreen con initHSLbyRGB
	@Test
	public void Test11() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(0, 255, 0);
		assertEquals(255,c.getGreen());
	}
	
	//getBlue con initHSLbyRGB
	@Test
	public void Test12() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(0, 0, 255);
		assertEquals(255,c.getBlue());
	}
	
	//initHSLbyRGB - copro greyscale 
	@Test
	public void Test13() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(0, 0, 0);
		assertEquals(170,c.getHue());
		assertEquals(0,c.getLuminence());
		assertEquals(0,c.getSaturation());
	}
	
	
	//initHSLbyRGB - copro color saturation 
	@Test
	public void Test14() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(210, 210, 33);
		assertEquals(42,c.getHue());
		assertEquals(122,c.getLuminence());
		assertEquals(185,c.getSaturation());
	}
	
	//initHSLbyRGB - copro pHue < 0
	@Test
	public void Test15() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(255, 50, 100);
		assertEquals(244,c.getHue());
		assertEquals(153,c.getLuminence());
		assertEquals(255,c.getSaturation());
	}
	
	//initRGBbyHSL - copro secondo if
	@Test
	public void Test16() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(0, 10, 255);
		assertEquals(255,c.getRed());
		assertEquals(255,c.getGreen());
		assertEquals(255,c.getBlue());
	}
	
	//HueToRgb - copro primo if
	@Test
	public void Test17() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(200, 255, 200);
		assertEquals(224,c.getRed());
		assertEquals(145,c.getGreen());
		assertEquals(255,c.getBlue());
	}
	
	//HueToRgb - copro ultimo if
	@Test
	public void Test18() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(55, 255, 200);
		assertEquals(224,c.getRed());
		assertEquals(255,c.getGreen());
		assertEquals(145,c.getBlue());
	}
	
	//initRGBbyHSL - copro if finali
	@Test
	public void Test19() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(900, 500, 500);
		assertEquals(255,c.getRed());
		assertEquals(255,c.getGreen());
		assertEquals(255,c.getBlue());
	}
	
	//reverse color
	@Test
	public void Test20() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(255, 0, 0);
		c.reverseColor();
		assertEquals(255,c.getGreen());
		assertEquals(1,c.getRed());
		assertEquals(255,c.getBlue());
	}
	
	//brighten con parametro 0
	@Test
	public void Test21() {	
		HSLColor c = new HSLColor(); 
		c.initHSLbyRGB(255, 0, 0);
		c.brighten(0);
		assertEquals(255,c.getRed());
		assertEquals(0,c.getGreen());
		assertEquals(0,c.getBlue());
	}
	
	//brighten con parametro in range
	@Test
	public void Test22() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(90,255,50);
		c.brighten(150);
		assertEquals(90,c.getHue());
		assertEquals(255,c.getLuminence());
		assertEquals(255,c.getSaturation());
	}
	
	//brighten con parametro < 0
	@Test
	public void Test23() {	
		HSLColor c = new HSLColor(); 
		c.initRGBbyHSL(90,255,50);
		c.brighten(-8);
		assertEquals(90,c.getHue());
		assertEquals(0,c.getLuminence());
		assertEquals(255,c.getSaturation());
	}
	
	//blend con precentuale minore
	@Test
	public void Test24() {		
		HSLColor c = new HSLColor(); 
		int valueOfRed = 10;
		int valueOfGreen = 10;
		int valueOfBlue = 10;
		float percent = -2f;
		c.blend(valueOfRed, valueOfGreen, valueOfBlue, percent);		
		assertNotEquals(valueOfRed, c.getRed());
		assertNotEquals(valueOfGreen, c.getGreen());
		assertNotEquals(valueOfBlue, c.getBlue());
	}
	
	//blend con precentuale maggiore
	@Test
	public void Test25() {		
		HSLColor c = new HSLColor(); 
		int valueOfRed = 10;
		int valueOfGreen = 10;
		int valueOfBlue = 10;
		float percent = 5f;
		c.blend(valueOfRed, valueOfGreen, valueOfBlue, percent);	
		assertEquals(valueOfRed, c.getRed());
		assertEquals(valueOfGreen, c.getGreen());
		assertEquals(valueOfBlue, c.getBlue());	
	}
	
	//blend con precentuale 0.5
	@Test
	public void Test26() {		
		HSLColor c = new HSLColor(); 
		int valueOfRed = 10;
		int valueOfGreen = 10;
		int valueOfBlue = 10;
		float percent = (float)0.5;
		c.blend(valueOfRed, valueOfGreen, valueOfBlue, percent);	
		assertEquals(5, c.getRed());
		assertEquals(5, c.getGreen());
		assertEquals(5, c.getBlue());	
	}
	
}

						