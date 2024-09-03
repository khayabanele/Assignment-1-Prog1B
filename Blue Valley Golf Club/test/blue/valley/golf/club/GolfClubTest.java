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
public class GolfClubTest {
    
    public GolfClubTest() {
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
     * Test of bookTeeTime method, of class GolfClub.
     */
    @Test
    public void testBookTeeTime() {
        System.out.println("bookTeeTime");
        Player player = null;
        int day = 0;
        int slot = 0;
        GolfClub instance = new GolfClub();
        instance.bookTeeTime(player, day, slot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTeeTimes method, of class GolfClub.
     */
    @Test
    public void testDisplayTeeTimes() {
        System.out.println("displayTeeTimes");
        int day = 0;
        GolfClub instance = new GolfClub();
        instance.displayTeeTimes(day);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
