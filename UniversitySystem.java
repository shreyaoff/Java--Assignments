// Question 16: University People System
// Base class Person with private fields name, id and method getRoleDetails().
// Subclasses:
//   Student: add program.
//   Teacher: add subject.
//   Admin: add department.
// Override getRoleDetails() to show respective info.

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public void getRoleDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class UniversityStudent extends Person {
    private String program;

    public UniversityStudent(String name, int id, String program) {
        super(name, id);
        this.program = program;
    }

    public String getProgram() { return program; }

    @Override
    public void getRoleDetails() {
        System.out.println("[STUDENT]");
        super.getRoleDetails();
        System.out.println("Program: " + program);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public void getRoleDetails() {
        System.out.println("[TEACHER]");
        super.getRoleDetails();
        System.out.println("Subject: " + subject);
    }
}

class Admin extends Person {
    private String department;

    public Admin(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public void getRoleDetails() {
        System.out.println("[ADMIN]");
        super.getRoleDetails();
        System.out.println("Department: " + department);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Person[] people = {
            new UniversityStudent("Alice Brown", 1001, "Computer Science"),
            new Teacher("Dr. Kevin Hall", 2001, "Data Structures"),
            new Admin("Maria Lopez", 3001, "Admissions Office")
        };

        System.out.println("===== University Directory =====");
        for (Person person : people) {
            System.out.println("--------------------------------");
            person.getRoleDetails();
        }
    }
}
