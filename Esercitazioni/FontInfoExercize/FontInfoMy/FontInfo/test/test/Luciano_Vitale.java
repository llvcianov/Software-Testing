package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Font;
import ClassUnderTest.FontInfo;

public class Luciano_Vitale {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Font font = new Font("SansSerif", Font.PLAIN, 14);
	
	@Test
	//null pointer font object
	public void testFontNull() {
		assertThrows(java.lang.IllegalArgumentException.class,()->  new FontInfo(null));
	}
	
	@Test
	//Costruttore vuoto, verifico famiglia di default
	public void testGetFamily1() {
		FontInfo info = new FontInfo();
		assertEquals("Monospaced", info.getFamily());
		
	}
	
	@Test
	//Costruttore con oggetto font, verifico famiglia
	public void testGetFamily2() {
		Font font = new Font("SansSerif", Font.PLAIN, 14);
		FontInfo info = new FontInfo(font);
		assertEquals("SansSerif", info.getFamily());	
	}
	
	@Test
	//verifico metodo setFamily con parametro null
	public void testSetFamilyNull() {
		FontInfo info = new FontInfo();
		info.setFamily(null);
		assertEquals("Monospaced", info.getFamily());	
	}
	
	@Test
	//verifico metodo IsBold di default
	public void testIsBold1() {
		FontInfo info = new FontInfo();
		assertEquals(false, info.isBold());	
	}
	
	@Test
	//verifico metodo IsBold settato a true
	public void testIsBold2() {
		FontInfo info = new FontInfo();
		info.setIsBold(true);
		assertEquals(true, info.isBold());	
	}
	
	@Test
	//verifico metodo IsItalic di default
	public void testIsItalic1() {
		FontInfo info = new FontInfo();
		assertEquals(false, info.isItalic());	
	}
	
	@Test
	//verifico metodo IsItalic settato a true con setIsItalic
	public void testSetIsItalic1() {
		FontInfo info = new FontInfo();
		info.setIsItalic(true);
		assertEquals(true, info.isItalic());	
	}
	
	@Test
	//verifico metodo getSize di default
	public void testGetSize1() {
		FontInfo info = new FontInfo();
		assertEquals(12, info.getSize());	
	}
	
	
	@Test
	//verifico metodo setSize con parametro null 
	public void testSetFontNull() {
		FontInfo info = new FontInfo();
		assertThrows(java.lang.IllegalArgumentException.class,()->  info.setFont(null));
	}
	
	@Test
	//verifico metodo clone
	public void testClone1() {
		FontInfo info = new FontInfo();
		Object clone = info.clone();
		assertEquals(info, clone);
	}
	

	@Test
	//verifico metodo DoesFontMatch
	public void testDoesFontMatch1() {
		FontInfo info = new FontInfo();
		assertEquals(false, info.doesFontMatch(null));
	}
	
	@Test
	//verifico metodo DoesFontMatch quando è tutto diverso
	public void testDoesFontMatch2() {
		Font font = new Font("SansSerif", Font.PLAIN, 14);
		FontInfo info = new FontInfo();
		assertEquals(false, info.doesFontMatch(font));
	}
	
	@Test
	//verifico metodo DoesFontMatch quando la famiglia è uguale
	public void testDoesFontMatch3() {
		Font font = new Font("Monospaced", Font.PLAIN, 14);
		FontInfo info = new FontInfo();
		assertEquals(false, info.doesFontMatch(font));
	}
	
	@Test
	//verifico metodo DoesFontMatch quando lo style è diverso
	public void testDoesFontMatch4() {
		Font font = new Font("SanSerif", Font.PLAIN, 12);
		Font font1 = new Font("SanSerif", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		assertEquals(false, info.doesFontMatch(font1));
	}
	
	
	@Test
	//verifico metodo DoesFontMatch quando la famiglia e la size è uguale
	public void testDoesFontMatch5() {
		Font font = new Font("Monospaced", Font.PLAIN, 12);
		FontInfo info = new FontInfo();
		assertEquals(true, info.doesFontMatch(font));
	}
	//0 plain 1 bold 2 italic
	
	@Test
	//verifico metodo generateStyle - 0 = plain; 1 = bold; 2 = italic;
	public void testGenerateStyle1() {
		FontInfo info = new FontInfo();
		assertEquals(0, info.generateStyle());
	}
	
	@Test
	//verifico metodo generateStyle - 0 = plain; 1 = bold; 2 = italic;
	public void testGenerateStyle2() {
		Font font = new Font("Monospaced", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		assertEquals(1, info.generateStyle());
	}
	
	@Test
	//verifico metodo generateStyle - 0 = plain; 1 = bold; 2 = italic;
	public void testGenerateStyle3() {
		Font font = new Font("Monospaced", Font.ITALIC, 12);
		FontInfo info = new FontInfo(font);
		assertEquals(2, info.generateStyle());
	}
	
	@Test
	//verifico metodo createfont
	public void testCreateFont1() {
		FontInfo info = new FontInfo();
		Font font = info.createFont();
		assertEquals("Monospaced", info.getFamily());
		assertEquals(0, info.generateStyle());
		assertEquals(12, info.getSize());
	}
	
	@Test
	//verifico metodo tostring
	public void testToString1() {
		FontInfo info = new FontInfo();
		assertEquals("Monospaced, 12", info.toString());
	}
	
	@Test
	//verifico metodo tostring con italic
	public void testToString2() {
		Font font = new Font("Monospaced", Font.ITALIC, 12);
		FontInfo info = new FontInfo(font);
		String stile = info.toString();
		assertEquals("Monospaced, 12, italic", info.toString());
	}
	
	@Test
	//verifico metodo tostring con bold
	public void testToString3() {
		Font font = new Font("Monospaced", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		String stile = info.toString();
		assertEquals("Monospaced, 12, bold", info.toString());
	}
	
	@Test
	//verifico metodo HashCode default
	public void testHashCode1() {
		FontInfo info = new FontInfo();
		assertEquals(-1059600276, info.hashCode());
	}
	
	@Test
	//verifico metodo HashCode con bold
	public void testHashCode2() {
		Font font = new Font("Monospaced", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		assertEquals(-1059606042, info.hashCode());
	}
	
	@Test
	//verifico metodo HashCode con italic
	public void testHashCode3() {
		Font font = new Font("Monospaced", Font.ITALIC, 12);
		FontInfo info = new FontInfo(font);
		assertEquals(-1059600462, info.hashCode());
	}
	
	@Test
	//verifico metodo HashCode con famiglia nulla
	public void testHashCode4() {
		FontInfo info = new FontInfo();
		info.setFamily(null);
		assertEquals(-1059600276, info.hashCode());
	}
	
	@Test
	//equals con se stesso
	public void testEqualsObject1() {
		FontInfo info = new FontInfo();
		assertEquals(true, info.equals(info));
	}
	
	@Test
	//equals con oggetto null
	public void testEqualsObject2() {
		FontInfo info = new FontInfo();
		assertEquals(false, info.equals(null));
	}
	
	@Test
	//equals con font
	public void testEqualsObject3() {
		Font font = new Font("Monospaced", Font.BOLD, 12);
		Font font1 = new Font("Monospaced", Font.ITALIC, 12);
		FontInfo info = new FontInfo(font1);
		assertEquals(false, info.equals(font));
	}
	
	@Test
	//equals con bold
	public void testEqualsObject4() {
		Font font = new Font("bella", Font.ITALIC, 12);
		Font font1 = new Font("ciao", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		FontInfo info2 = new FontInfo(font1);
		assertEquals(false, info.equals(info2));
	}
	
	@Test
	//equals con italic
	public void testEqualsObject5() {
		Font font = new Font("bella", Font.ITALIC, 12);
		Font font1 = new Font("ciao", Font.BOLD, 12);
		FontInfo info = new FontInfo(font);
		FontInfo info2 = new FontInfo(font1);
		assertEquals(false, info2.equals(info));
	}
	
	

}
