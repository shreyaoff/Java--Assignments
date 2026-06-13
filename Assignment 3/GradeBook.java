// Question 7: Student Grade Book
// Create a class Student with private fields: name, rollNumber, marks[].
// Encapsulate with getters/setters. Method calculateAverage() returns average marks.
// Subclass GraduateStudent adds thesisTopic and a method printThesisTitle().
// Demonstrate both types of students.

class Student {
    private String name;
    private int rollNumber;
    private double[] marks;

    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public double[] getMarks() { return marks; }
    public void setMarks(double[] marks) { this.marks = marks; }

    public double calculateAverage() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Average Marks: " + calculateAverage());
    }
}

class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String name, int rollNumber, double[] marks, String thesisTopic) {
        super(name, rollNumber, marks);
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() { return thesisTopic; }
    public void setThesisTopic(String thesisTopic) { this.thesisTopic = thesisTopic; }

    public void printThesisTitle() {
        System.out.println("Thesis Topic: " + thesisTopic);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        printThesisTitle();
    }
}

public class GradeBook {
    public static void main(String[] args) {
        double[] undergraduateMarks = {85, 90, 78, 92, 88};
        Student student1 = new Student("Alice", 101, undergraduateMarks);
        System.out.println("--- Undergraduate Student ---");
        student1.displayInfo();

        System.out.println();

        double[] graduateMarks = {91, 95, 89, 94, 97};
        GraduateStudent student2 = new GraduateStudent("Bob", 201, graduateMarks, "Machine Learning in Healthcare");
        System.out.println("--- Graduate Student ---");
        student2.displayInfo();
    }
}
