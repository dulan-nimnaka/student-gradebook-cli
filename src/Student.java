public class Student {
    private String name;
    private String studentId;
    private double grade;

    //constructor
    public Student(String name, String studentId, double grade) {
        this.name = name;
        this.studentId = studentId;
        this.grade = grade;
    }

    //getters
    public String getName {
        return name;
    }
    public String getStudentId {
        return studentId;
    }
    public double getGrade {
        return grade;
    }

    //toCSV

    @Override
    public String toString() {
        return "ID: " + studentId + "| Name: " + name + "| Grade: " + grade;
    }
}