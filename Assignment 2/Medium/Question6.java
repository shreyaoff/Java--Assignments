public class Question6 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Shreya", 70000.999, 7);
        Employee employee2 = new Employee("Kala", 60000.999, 4);

        System.out.println("Bonus of " + employee1.fullName + " is " + employee1.calculateBonus());
        System.out.println("Bonus of " + employee2.fullName + " is " + employee2.calculateBonus());
    }
}

class Employee {
    String fullName;
    double baseSalary;
    int yearsOfExperience;

    public Employee(String fullName, double baseSalary, int yearsOfExperience) {
        this.fullName = fullName;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public double calculateBonus() {
        if (yearsOfExperience > 5) {
            return (20 * baseSalary) / 100;
        } else {
            return (10 * baseSalary) / 100;
        }
    }
}