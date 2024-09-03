
package blue.valley.golf.club;
import java.util.Scanner;

class Player {
    String name;
    String type; // Member or Guest

    Player(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class TeeTime {
    String date;
    String[] slots;

    TeeTime(String date) {
        this.date = date;
        this.slots = new String[8]; // 8 available slots
    }

    boolean bookSlot(int slotIndex, String playerName) {
        if (slots[slotIndex] == null) {
            slots[slotIndex] = playerName;
            return true;
        }
        return false;
    }

    void displaySlots() {
        System.out.println("Available slots for " + date + ":");
        for (int i = 0; i < slots.length; i++) {
            System.out.println((i + 1) + ": " + (slots[i] == null ? "Available" : slots[i]));
        }
    }
}

class GolfClub {
    TeeTime[] teeTimes;

    GolfClub() {
        teeTimes = new TeeTime[30]; // 30 days of booking
        for (int i = 0; i < teeTimes.length; i++) {
            teeTimes[i] = new TeeTime("Day " + (i + 1));
        }
    }

    void bookTeeTime(Player player, int day, int slot) {
        if (day < 1 || day > 30 || slot < 1 || slot > 8) {
            System.out.println("Invalid day or slot.");
            return;
        }
        if (teeTimes[day - 1].bookSlot(slot - 1, player.name)) {
            System.out.println("Booking successful for " + player.name + " on " + teeTimes[day - 1].date + " at slot " + slot);
        } else {
            System.out.println("Slot already booked. Please choose another slot.");
        }
    }

    void displayTeeTimes(int day) {
        if (day < 1 || day > 30) {
            System.out.println("Invalid day.");
            return;
        }
        teeTimes[day - 1].displaySlots();
    }
}

public class BlueValleyGolfClub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GolfClub golfClub = new GolfClub();
//W3Schools (2019). Java User Input (Scanner class). [online] W3schools.com. Available at: https://www.w3schools.com/java/java_user_input.asp.

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Are you a Member or Guest? ");
        String type = scanner.nextLine();
        Player player = new Player(name, type);

        while (true) {
            System.out.print("Enter the day you wish to book (1-30) or 0 to exit: ");
            int day = scanner.nextInt();
            if (day == 0) break;

            golfClub.displayTeeTimes(day);

            System.out.print("Choose a slot to book (1-8): ");
            int slot = scanner.nextInt();
            golfClub.bookTeeTime(player, day, slot);
        }

        scanner.close();
    }
}
