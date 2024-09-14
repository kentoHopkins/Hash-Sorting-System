/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * test class for DatedEntry.
 * @author Kento Hopkins
 * @version 2024.02.20
 */
public class DatedEntryTest
{
    DatedEntry a;
    DatedEntry b;
        
    // ----------------------------------------------------------
    /**
    * Create two DatedEntry for tests.
    */
    @Before
    public void setUp()
    {
        a = new DatedEntry("2024/02/08", "Dear journal, I see some code in my future.");
        b= new DatedEntry("2024/03/09", "Dear journal, today I wrote some code.");
    }
        
    // ----------------------------------------------------------
    /**
    * Check getDate that returns string which represents dates.
    */
    @Test
    public void testGetDate(){
        String dataA = a.getDate();
        String dataB = b.getDate();
        assertEquals("2024/02/08", dataA);
        assertEquals("2024/03/09", dataB);
    }
        
    // ----------------------------------------------------------
    /**
    * Check getMonth that returns int.
    */
    @Test
    public void testGetMonth(){
        int monthA = a.getMonth();
        int monthB = b.getMonth();
        assertEquals(2, monthA);
        assertEquals(3, monthB);
    }
        
    // ----------------------------------------------------------
    /**
    * Check getEntry which returns string of entry.
    */
    @Test
    public void testGetEntry(){    
        String entryA = a.getEntry();
        String entryB = b.getEntry();
        assertEquals("Dear journal, I see some code in my future.", entryA);
        assertEquals("Dear journal, today I wrote some code.", entryB);
    }
}
