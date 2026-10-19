package ClassTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.*;

import java.util.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) 
public class IteratorTest2 {
	
   private List<String> list;          // test fixture
   private Iterator<String> itr;       // test fixture

   @BeforeEach
   public void setUp()         // set up test fixture
   {
	   list = List.of("Kvara","Lobotka","McTominay");
	   
	   itr = list.iterator();
	   
	   //assume
	   assumeNotNull("Errore creazione lista",list);
	   assumeNotNull("Errore creazione iteratore",itr);
	   assumeTrue("Errore numero elementi",list.size() == 3);
   }

   @AfterEach
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
	   Exception e = assertThrows(UnsupportedOperationException.class, () -> itr.remove());
	   assertEquals(null,e.getMessage());  
   }
   
   
   
   
}
