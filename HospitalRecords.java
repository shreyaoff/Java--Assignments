// Question 11: Hospital Patient Records
// Class Patient with private fields name, age and method getTreatmentPlan().
// Subclasses:
//   InPatient: add roomNumber, override getTreatmentPlan() with full plan.
//   OutPatient: add appointmentDate, override getTreatmentPlan() accordingly.
// Use encapsulation for all fields.

class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void getTreatmentPlan() {
        System.out.println("Patient: " + name + " | Age: " + age);
        System.out.println("Treatment Plan: General checkup and observation.");
    }
}

class InPatient extends Patient {
    private int roomNumber;

    public InPatient(String name, int age, int roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    @Override
    public void getTreatmentPlan() {
        System.out.println("Patient: " + getName() + " | Age: " + getAge());
        System.out.println("Type: In-Patient | Room Number: " + roomNumber);
        System.out.println("Treatment Plan: 24/7 monitoring, daily medication, specialist consultations, and physiotherapy.");
    }
}

class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String appointmentDate) {
        super(name, age);
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    @Override
    public void getTreatmentPlan() {
        System.out.println("Patient: " + getName() + " | Age: " + getAge());
        System.out.println("Type: Out-Patient | Appointment: " + appointmentDate);
        System.out.println("Treatment Plan: Prescribed medication, follow-up visit in 7 days, rest at home.");
    }
}

public class HospitalRecords {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("John Smith", 45, 302);
        OutPatient outPatient = new OutPatient("Sarah Lee", 30, "2025-06-15");

        System.out.println("===== Hospital Records =====");
        System.out.println("--- In-Patient ---");
        inPatient.getTreatmentPlan();

        System.out.println();
        System.out.println("--- Out-Patient ---");
        outPatient.getTreatmentPlan();
    }
}
