
package student.mangement;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StudentManagementTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        // Restore original System.out and reset the output stream
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testCaptureNewStudent() {
        // Simulate user input: launch menu, choose to capture new student, input student details, exit
        String input = "1\n1\n123\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke main to start the application and pass the simulated input
        StudentManagement.main(new String[]{});

        // Verify that the student was added
        assertFalse(StudentManagement.students.isEmpty());
        assertEquals("123", StudentManagement.students.get(0).getId());
        assertEquals("John Doe", StudentManagement.students.get(0).name);
    }

    @Test
    public void testSearchStudent() {
        // Add a student for testing
        StudentManagement.students.add(new Student("123", "John Doe", 20, "john.doe@example.com", "Computer Science"));

        // Simulate user input: launch menu, choose to search student, input student ID, exit
        String input = "1\n2\n123\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke main to start the application and pass the simulated input
        StudentManagement.main(new String[]{});
        String output = outputStream.toString();

        // Verify the output
        assertTrue(output.contains("Student found:"));
        assertTrue(output.contains("John Doe"));
    }

    @Test
    public void testDeleteStudent() {
        // Add a student for testing
        StudentManagement.students.add(new Student("123", "John Doe", 20, "john.doe@example.com", "Computer Science"));

        // Simulate user input: launch menu, choose to delete student, confirm deletion, exit
        String input = "1\n3\n123\nyes\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke main to start the application and pass the simulated input
        StudentManagement.main(new String[]{});
        String output = outputStream.toString();

        // Verify the student was deleted
        assertTrue(output.contains("Student with ID 123 has been successfully deleted."));
        assertTrue(StudentManagement.students.isEmpty());
    }

    @Test
    public void testPrintStudentReport() {
        // Add a student for testing
        StudentManagement.students.add(new Student("123", "John Doe", 20, "john.doe@example.com", "Computer Science"));

        // Simulate user input: launch menu, choose to print student report, exit
        String input = "1\n4\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke main to start the application and pass the simulated input
        StudentManagement.main(new String[]{});
        String output = outputStream.toString();

        // Verify the student report
        assertTrue(output.contains("Student Report:"));
        assertTrue(output.contains("John Doe"));
    }
}

