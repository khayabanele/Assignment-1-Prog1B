
package blue.valley.golf.club;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlueValleyGolfClubTest {

    private Player player;
    private TeeTime teeTime;
    private GolfClub golfClub;

    @Before
    public void setUp() {
       
        player = new Player("John Doe", "Member");
        teeTime = new TeeTime("Day 1");
        golfClub = new GolfClub();
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals("John Doe", player.name);
        assertEquals("Member", player.type);
    }

    @Test
    public void testTeeTimeBookingSlot() {
        boolean result = teeTime.bookSlot(0, "John Doe");
        assertTrue(result);
        result = teeTime.bookSlot(0, "Jane Doe");
        assertFalse(result); // Slot should be taken
    }

    @Test
    public void testTeeTimeDisplaySlots() {
        teeTime.bookSlot(0, "John Doe");
       
    }

    @Test
    public void testGolfClubBooking() {
        golfClub.bookTeeTime(player, 1, 1);
       
    }

    @Test
    public void testGolfClubDisplayTeeTimes() {
        
    }
}
