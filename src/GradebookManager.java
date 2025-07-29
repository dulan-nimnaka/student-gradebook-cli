import java.io.*;
import java.util.*;
import java.util.stream.Collectors; //For processing collections using Java Streams

public class GradebookManager {
    private Map<String, Student> students;

    // Constructor
    public GradebookManager() {
        students = new HashMap<>();
    }

    // Add a student
    public void addStudent(Student student) {
        // put() Adds or replaces the student with the same ID
        students.put(student.getStudentId(), student);
    }

    // Remove a student(by ID)
    public void removeStudent(String studentId) {
        studentId.remove(studentId);
    }

    // Get a All students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // Average grade
    public double averageGrade() {
        // If no students: return 0
        return students.isEmpty() ? 0 :
            // Process each student as a stream.
            students.values().stream()
                    // Convert each student to their grade.
                    .mapToDouble(Student::getGrade)
                    .average()
                    // Default to 0 if no grades
                    .orElse(0);
    }

    // Highest grade student
    public Student highestGrade() {
        return students.values().stream()
                // Find the student with the highest grade
                .max(Comprator.compringDouble(Student::getGrade)) // Compares based on grades
                .orElse(null); // Return null if no students exist
    }

    // Search by name
    public List<Student> searchByName(String keyword) {
        return students.values().stream()
                // Filters students whose names contain the given keyword(turned to lower case for case-insensitive search)
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                // Return list of matching students
                .collect(Collectors.toList());
    }

    // Save to File
    public void saveToFile(String path) {
        // BufferedWriter + FileWriter = Writes data to file efficiently / try, Closes file automatically.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Student s : students.values()) {
                writer.write(s.toCSV());
                writer.newLine();
            }
            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from File
    public void loadFromFile(String path) {
        File file = new File(path);
        // Check if file exists
        // If not, print message and return
        if (!file.exists()) {
            System.out.println("No saved data found at: " + path);
            return;
        }
        // BufferedReader + FileReader = Reads data from file efficiently
        // try, Closes file automatically.
        //  Read line by line → Each line = "id,name,grade", create Student object, add to students map
        // Clear existing students before loading new data
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            students.clear(); // Clear existing students before loading
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double grade = Double.parseDouble(parts[2]);
                    addStudent(new Student(id, name, grade));
                }
            }
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getmessage());
        }
    }

}
