package student.mangement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Student {

    public String id;
    public String name;
    public int age;
    public String email;
    public String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getId() {
        return id;
    }

  
    
    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
    //GeeksforGeeks (2016). Overriding in Java. [online] GeeksforGeeks. Available at: https://www.geeksforgeeks.org/overriding-in-java/#:~:text=In%20Java [Accessed 3 Sep. 2024].
    }

    
    }


public class StudentManagement {

    static final List<Student> students = new ArrayList<>();
//W3schools.com. (2024). W3Schools.com. [online] Available at: https://www.w3schools.com/java/java_arraylist.asp#:~:text=The%20ArrayList%20class%20is%20a%20resizable%20array [Accessed 3 Sep. 2024].


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*************************************");
            while (true) {
                System.out.print("Enter (1) to launch menu or any other key to exit: ");
                String input = scanner.nextLine();
                if ("1".equals(input)) {
                    showMenu(scanner);
                } else {
                    System.out.println("Exiting Application.");
                    break;
                }
            }
        }
    }

    private static void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Delete a student");
            System.out.println("(4) Print student report");
            System.out.println("(5) Exit Application");
            String choice = scanner.nextLine();

            switch (choice) {
                //‌W3Schools (n.d.). Java Switch. [online] www.w3schools.com. Available at: https://www.w3schools.com/java/java_switch.asp.


                case "1" ->
                    captureNewStudent(scanner);
                case "2" ->
                    searchStudent(scanner);
                case "3" ->
                    deleteStudent(scanner);
                case "4" ->
                    printStudentReport();
                case "5" -> {
                    System.out.println("Exiting Application.");
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void captureNewStudent(Scanner scanner) {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("********************************");
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        int age = getValidStudentAge(scanner);
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student captured successfully!");
    
    }

    private static int getValidStudentAge(Scanner scanner) {
        int age;
        while (true) {
            System.out.print("Enter the student age (must be 16 or older): ");
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (age >= 16) {
                    return age; 
                } else {
                    System.out.println("Age is invalid. Age must be 16 or older.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a valid age.");
            }
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter the student ID to search: ");
        String id = scanner.nextLine();
        Optional<Student> student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        System.out.println(student.map(s -> "Student found: " + s)
                .orElse("Error: Student with ID " + id + " cannot be located."));
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter the student ID to delete: ");
        String id = scanner.nextLine();
        Optional<Student> studentToDelete = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if (studentToDelete.isPresent()) {
            System.out.print("Are you sure you want to delete student with this ID " + id + "? (yes/no): ");
            String confirmation = scanner.nextLine();
            if ("yes".equalsIgnoreCase(confirmation)) {
                students.remove(studentToDelete.get());
                System.out.println("Student with ID " + id + " has been successfully deleted.");
            } else {
                System.out.println("Deleting was cancelled.");
            }
        } else {
            System.out.println("Error: Student with ID " + id + " cannot be located.");
        }
    }

    private static void printStudentReport() {
        System.out.println("Student Report:");
        if (students.isEmpty()) {
            System.out.println("No students was found.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
