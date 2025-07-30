# **Student Gradebook System (Java CLI)**

## **Overview**

This is a simple **Command-Line Interface (CLI)** based **Student Gradebook System** built using **Java Object-Oriented Programming (OOP)** principles.
It allows you to:

* Add students with unique Names, IDs and grades
* Remove students
* Search students by name
* Display all students
* Calculate the average grade and find the highest grade
* Save and load student data from a file (`students.csv`)

---

## **Features**

* **Unique Student ID** based storage for quick lookup
* **Search by Name** (case-insensitive partial match)
* **Grade Statistics**: average grade and top student
* **File Persistence** using CSV format
* **Extensible Design** (easy to add edit feature, sorting, multiple grades, etc.)

---

## **Technologies**

* **Language:** Java 17+ (works with Java 8+)
* **Paradigm:** Object-Oriented Programming
* **Data Storage:** CSV file (via `BufferedReader`/`BufferedWriter`)

---

## **Screenshot**

(`/Users/dulannimnaka1/Documents/github/student-gradebook-cli/mainscreenshot.png`)
(`/Users/dulannimnaka1/Documents/github/student-gradebook-cli/studentscreenshot.png`)
(`/Users/dulannimnaka1/Documents/github/student-gradebook-cli/gradebookscreenshot.png`)

---

## **How to Run**

### **1. Clone the Repository**

```bash
git clone https://github.com/dulan-nimnaka/student-gradebook-cli.git
cd student-gradebook-cli
```

### **2. Compile the Code**

```bash
javac Student.java GradebookManager.java Main.java
```

### **3. Run the Application**

```bash
java Main
```

---

## **Usage**

### **Main Menu**

```
=== Gradebook Menu ===
1. Add Student
2. Remove Student
3. Display All Students
4. Search by Name
5. Show Average & Highest
6. Save
7. Exit
```

### **Example**

1. Add a student:

   ```
   Enter Student ID: S001
   Enter Student Name: Dulan Nimnaka
   Enter Grade: 85.5
   ```
2. View all students:

   ```
   ID: S001 | Name: Dulan Nimnaka | Grade: 85.5
   ```
3. Save and Exit → creates/updates `students.csv`.

---

## **File Format**

Data is saved in a simple CSV format:

```
S001,Dulan N,85.5
S002,Jane Smith,92.0
```

---

## **Project Structure**

```
src
├── Student.java           # Student class
├── GradebookManager.java  # Manages students and file handling
├── Main.java              # CLI menu (entry point)
└── students.csv           # Data file (auto-generated after first save)
```

---

## **Author**

**Dulan Nimnaka** – [LinkedIn](https://www.linkedin.com/in/dulannimnaka/) | [GitHub](https://github.com/dulan-nimnaka/)
