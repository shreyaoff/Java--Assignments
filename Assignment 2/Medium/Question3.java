public class Question3 {
    public static void main(String[] args) {
        Student student1 = new Student("Shreya", 83);
        Student student2 = new Student("Kala", 84);
        Student student3 = new Student("Shahisha", 82);

        System.out.println("Name: " + student1.fullName);
        student1.calculateGrade();

        System.out.println("Name: " + student2.fullName);
        student2.calculateGrade();

        System.out.println("Name: " + student3.fullName);
        student3.calculateGrade();
    }
}

class Student {
    String fullName;
    int totalMarks;

    public Student(String fullName, int totalMarks) {
        this.fullName = fullName;
        this.totalMarks = totalMarks;
    }

    public void calculateGrade() {
        if (totalMarks < 0 || totalMarks > 100) {
            System.out.println("Invalid Marks!");
        }
        switch (totalMarks / 10) {
            case 10, 9 -> System.out.println("Grade: A");
            case 8     -> System.out.println("Grade: B");
            case 7     -> System.out.println("Grade: C");
            case 6     -> System.out.println("Grade: D");
            default    -> System.out.println("Grade: F");
        }
    }
}