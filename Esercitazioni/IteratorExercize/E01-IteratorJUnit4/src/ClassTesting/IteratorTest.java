package ClassTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest {
	
   private List<String> list;          // test fixture
   private Iterator<String> itr;       // test fixture
 
   @Before
   public void setUp()         // set up test fixture
   {
	   list = new ArrayList<String>();
	   
	   list.add("Kvara");
	   list.add("Lobotka");
	   list.add("McTominay");
	   
	   itr = list.iterator();
	   
	   //assume
	   assumeNotNull("Errore creazione lista",list);
	   assumeNotNull("Errore creazione iteratore",itr);
	   assumeTrue("Errore numero elementi",list.size() == 3);
   }

   @After
   public void tearDown()
   {      
	   list = null;
	   itr = null;
	   
	   //assume
	   assumeTrue(list ==null);
	   assumeTrue(itr == null);
   }
  
   // Test 1 hasNext: verifica l'esistenza 
   @Test 
   public void hasNext_test1_exist()
   {
	   assertTrue("Non c'e' il prossimo elemento",itr.hasNext());
   }
   
   // Test 2 hasNext: verifica che non ci sono più elementi
   @Test 
   public void hasNext_test2_noMore()
   {
	   for (int i = 0; i < 3; i++) {
           itr.next();
       }
       
	   assertFalse("C'è un altro elemento",itr.hasNext());
   }
   
   // Test 3 hasNext: verifica eccezione iteratore null
   @Test 
   public void hasNext_test3_nullIterator()
   {
	   itr = null;
	   
	   try {
		   itr.hasNext();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa NullPointerException");
   }
   
   // Test 1 next: verifica lettura del primo elemento
   @Test 
   public void next_test1_readFirst()
   {
	   assertEquals("Lettura elemento sbagliato","Kvara",itr.next());
   }
   
   // Test 2 next: verifica lettura oltre l'ultimo elemento
   @Test 
   public void next_test2_readAboveLast()
   {
	   try {
		   for (int i = 0; i < 4; i++) {
			   itr.next();
		   }
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa NoSuchElementException");
   }
   
   // Test 3 next: verifica eccezione iteratore null
   @Test 
   public void next_test3_nullIterator()
   {
	   itr = null;
	   
	   try {
		   itr.next();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa NullPointerException");
   }
   
   // Test 4 next: verifica lettura dopo modifica
   @Test 
   public void next_test4_readAfterModification()
   {
	   list.add("Politano");
	   
	   try {
		   itr.next();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa ConcurrentModificationException");
   }
   
   // Test 1 remove: verifica rimozione del primo elemento
   @Test 
   public void remove_test1_removeFirst()
   {
	   itr.next();
	   itr.remove();
	   
	   assertEquals("Errore rimozione primo elemento",2,list.size());
	   assertEquals("Errore rimozione primo elemento",list.get(0),"Lobotka");
	   assertEquals("Errore rimozione primo elemento",list.get(1),"McTominay");   
   }
   
   // Test 2 remove: verifica rimozione dell'ultimo elemento
   @Test 
   public void remove_test2_removeLast()
   {
	   for (int i = 0; i < 3; i++) {
		   itr.next();
	   }
	   
	   itr.remove();
	   
	   assertEquals("Errore rimozione ultimo elemento",2,list.size());
	   assertEquals("Errore rimozione ultimo elemento",list.get(0),"Kvara");
	   assertEquals("Errore rimozione ultimo elemento",list.get(1),"Lobotka");	   
   }
   
   // Test 3 remove: verifica rimozione senza selezione 
   @Test 
   public void remove_test3_NoSelection()
   {
	   try {
		   itr.remove();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa IllegalStateException");  
   }
   
   // Test 4 remove: verifica rimozione dopo modifica
   @Test 
   public void remove_test4_removeAfterModification()
   { 
	   itr.next();
	   
	   list.add("Politano");
	   
	   try {
		   itr.remove();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa ConcurrentModificationException");
   }
   
   // Test 5 remove: verifica rimozione di tutti gli elementi
   @Test 
   public void remove_test5_removeAll()
   {
	   for (int i = 0; i < 3; i++) {
		   itr.next();
		   itr.remove();
	   }
	   
	   assertEquals("Errore rimozione elementi",0,list.size());
   }
   
   // Test 6 remove: verifica errore rimozione dello stesso elemento 
   @Test 
   public void remove_test6_removeSame()
   {
	   itr.next();
	   
	   itr.remove();
	   
	   try {
		   itr.remove();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa IllegalStateException");
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}