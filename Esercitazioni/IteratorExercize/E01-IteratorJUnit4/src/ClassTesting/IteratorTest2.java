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

public class IteratorTest2 {
	
   private List<String> list;          // test fixture
   private Iterator<String> itr;       // test fixture

   @Before
   public void setUp()         // set up test fixture
   {
	   list = List.of("Kvara","Lobotka","McTominay");
	   
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
   
   // Test 7 remove: verifica eccezione rimozione elemento quando la lista è non modificabile
   @Test 
   public void remove_test7_removeOnUnmodifiable()
   {
	   try {
		   itr.remove();
	   } catch (Exception e) {
		   return;
	   }
	   
	   fail("Attesa UnsupportedOperationException"); 
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}