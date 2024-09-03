/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package blue.valley.golf.club;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dell
 */
public class TeeTimeTest {
    
    public TeeTimeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of bookSlot method, of class TeeTime.
     */
    @Test
    public void testBookSlot() {
        System.out.println("bookSlot");
        int slotIndex = 0;
        String playerName = "";
        TeeTime instance = null;
        boolean expResult = false;
        boolean result = instance.bookSlot(slotIndex, playerName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySlots method, of class TeeTime.
     */
    @Test
    public void testDisplaySlots() {
        System.out.println("displaySlots");
        TeeTime instance = null;
        instance.displaySlots();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
