public class Question8 {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Shreya", "9806785678", "");
        Contact contact2 = new Contact("Riya", "9875436760", "purnima1@gmail.com");

        contact1.displayDetails();
        contact2.displayDetails();
    }
}

class Contact {
    String fullName;
    String phoneNumber;
    String emailAddress;

    public Contact(String fullName, String phoneNumber, String emailAddress) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void displayDetails() {
        if (!this.emailAddress.isEmpty()) {
            System.out.println("Name: " + this.fullName);
            System.out.println("Phone Number: " + this.phoneNumber);
            System.out.println("Email: " + this.emailAddress);
        }
    }
}