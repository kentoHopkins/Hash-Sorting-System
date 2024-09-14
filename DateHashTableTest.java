/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for DateHashTable.
 * @author Kento Hopkins
 * @version 2024.02.20
 */
public class DateHashTableTest
{
    private DateHashTable table;
    private DatedEntry a;
    private DatedEntry b;
    private DatedEntry c;
    private DatedEntry d;
    private DatedEntry e;
    private DatedEntry f;
    private DatedEntry g;
    private DatedEntry h;
    
    // ----------------------------------------------------------
    /**
     * Create DatedEntry and insert two of them to list.
     */
    @Before
    public void setUp()
    {
        a = new DatedEntry("2024/01/07", "Dear journal, happy new year.");
        b = new DatedEntry("2024/02/08", "Dear journal, I see some code in my future.");
        c = new DatedEntry("2024/03/09", "Dear journal, today I wrote some code.");
        table = new DateHashTable(25);
        int indexA = table.hashKey(a);
        int indexB = table.hashKey(b);
        table.addingToTable(a,indexA);
        table.addingToTable(b,indexB);
    }
    
    // ----------------------------------------------------------
    /**
     * Check entryExists returns expected value which is either true or false.
     */
    @Test
    public void testEntryExists(){
        assertTrue(table.entryExists(a));
        assertTrue(table.entryExists(b));
        assertFalse(table.entryExists(c));
        assertFalse(table.entryExists(null));
    }
    
    // ----------------------------------------------------------
    /**
     * Check getEntry methods returns expected value which is DatedEntry class itself.
     */
    @Test
    public void testGetEntry(){
        assertEquals(a, table.getEntry("2024/01/07"));
        assertEquals(b, table.getEntry("2024/02/08"));
        assertNull(table.getEntry("2024/03/09"));
    }
    
    // ----------------------------------------------------------
    /**
     * Check getNumElements methods returns expected value which is integer.
     */
    @Test
    public void testGetNumElements(){
        int actualNum = table.getNumElements();
        assertEquals(2, actualNum);
    }
    
    // ----------------------------------------------------------
    /**
     * Check getNumElementsInMonth methods returns expected value which is integer.
     */
    @Test
    public void testGetNumElementsInMonth(){
        int testValue1 = table.getNumElementsInMonth(1);
        int testValue2 = table.getNumElementsInMonth(2);
        int testValue3 = table.getNumElementsInMonth(3);
        assertEquals(1,testValue1);
        assertEquals(1,testValue2);
        assertEquals(0,testValue3);
    }
    
    // ----------------------------------------------------------
    /**
     * Check bucketStartIdx methods returns expected value which is integer.
     */
    @Test
    public void testBucketStartIdx(){
        int testValue1 = table.bucketStartIdx(1);
        int testValue2 = table.bucketStartIdx(2);
        int testValue3 = table.bucketStartIdx(3);
        assertEquals(0,testValue1);
        assertEquals(2,testValue2);
        assertEquals(4,testValue3);
    }
    
    // ----------------------------------------------------------
    /**
     * Check bucketEndIdx methods returns expected value which is integer.
     */
    @Test
    public void testBucketEndIdx(){
        int testValue1 = table.bucketEndIdx(1);
        int testValue2 = table.bucketEndIdx(2);
        int testValue3 = table.bucketEndIdx(12);
        assertEquals(1,testValue1);
        assertEquals(3,testValue2);
        assertEquals(24,testValue3);
    }

    // ----------------------------------------------------------
    /**
     * Check addingToTable by create 9 DatedEntry and insert them.
     */
    @Test
    public void testHashKey(){
        int start = table.bucketStartIdx(12);
        int end = table.bucketEndIdx(12);

        d = new DatedEntry("2024/12/01", "Dear journal, this value 1 for hash key.");
        int indexD = table.hashKey(d);
        if(start <= indexD && indexD <= end){table.addingToTable(d,indexD);}
        assertEquals(22, indexD);

        e = new DatedEntry("2024/12/02", "Dear journal, this value 2 for hash key.");
        int indexE = table.hashKey(e);
        if(start <= indexE && indexE <= end){table.addingToTable(e,indexE);}
        assertEquals(23, indexE);

        f = new DatedEntry("2024/12/03", "Dear journal, this value 3 for hash key.");
        int indexF = table.hashKey(f);
        if(start <= indexF && indexF <= end){table.addingToTable(f,indexF);}
        assertEquals(24, indexF);

        g = new DatedEntry("2024/12/04", "Dear journal, this value 4 for hash key.");
        int indexG = table.hashKey(g);
        if(start <= indexG && indexG <= end){table.addingToTable(g,indexG);}
        assertEquals(-1, indexG);

        h = new DatedEntry(null, "Dear journal, this value 5 for hash key.");
        int indexH = table.hashKey(h);
        assertEquals(-1, indexH);
    }
        
    // ----------------------------------------------------------
    /**
     * Check storeEntry which return either true or false.
     */
    @Test
    public void testStoreEntry(){
        assertTrue(table.storeEntry(a));
        assertTrue(table.storeEntry(b));
        assertTrue(table.storeEntry(c));
        assertFalse(table.storeEntry(g));
    }
}
