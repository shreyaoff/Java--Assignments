// Question 5: Employee Management System
// Base class Employee with private fields name, id, and method calculateSalary().
// Subclasses: Manager (bonus), Developer (overtimeHours).
// Manager salary = base + bonus. Developer salary = base + overtimeHours * rate.

class Employee {
    private String name;
    private int id;
    private double baseSalary;

    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: " + calculateSalary());
    }
}

class Manager extends Employee {
    private double bonus;

    Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private int overtimeHours;
    private double overtimeRate;

    Developer(String name, int id, double baseSalary, int overtimeHours, double overtimeRate) {
        super(name, id, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + overtimeHours * overtimeRate;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice", 101, 80000, 15000),
            new Developer("Bob", 102, 70000, 20, 500),
            new Manager("Carol", 103, 90000, 20000),
            new Developer("Dave", 104, 65000, 10, 500)
        };

        System.out.println("Employee Salary Report:");
        System.out.println("------------------------");
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}
