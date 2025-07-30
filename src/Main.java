import java.util.List;
import java.util.Scanner;

public class Main {
    // A constant string storing the file name/path where student data will be saved and loaded
    // static used to Shared by all methods
    // final used to indicate that the value will not change
    private static final String FILE_PATH = "students.csv";
7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradebookManager manager = new GradebookManager();

        // Load existing student data from the file
        manager.loadFromFile(FILE_PATH);

        // Menu Loop
        boolean running = true;
        while (running) {
            System.out.println("\n Gradebook MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search By Name");
            System.out.println("5. Show Average Grade And Highest Grade");
            System.out.println("6. Save");
            System.out.println("7. Exit");
            System.out.println("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // Process user choice
            switch (choice) {
                // 1. Add Student
                case 1 -> {
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Student Grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();
                    manager.addStudent(new Student(name, id, grade));
                    System.out.println("Student Added Successfully!");
                }

                // 2. Remove Student
                case 2 -> {
                    System.out.print("Enter Student ID to Remove: ");
                    String id = sc.nextLine();
                    manager.removeStudent(id);
                    System.out.println("Student removed successfully!");
                }

                // 3. Display All Students
                case 3 -> {
                    List<Student> students = manager.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students in Gradebook");
                    } else {
                        // Calls Student.toString() to print details
                        students.forEach(System.out::println);
                    }
                }

                // 4. Search by Name
                case 4 -> {
                    System.out.print("Enter Name Keyword: ");
                    String keyword = sc.nextLine();
                    List<Student> results = manager.searchByName(keyword);
                    if (results.isEmpty()) System.out.println("No Maches Found");
                    else results.forEach(System.out::println);
                }

                // 5. Show Average and Highest Grade
                case 5 -> {
                    System.out.println("Average Grade: " + manager.averageGrade());
                    Student top = manager.highestGrade();
                    if (top != null) System.out.println("Top Student: " + top);

                }

                // 6. Save Data
                case 6 -> manager.saveToFile(FILE_PATH);

                // 7. Exit
                case 7 -> {
                    manager.saveToFile(FILE_PATH);
                    running = false;
                }

                // Invalid Input
                default -> System.out.println("Invalid choice, try again.");
                    
            }
        }
        sc.close();
    }
}
