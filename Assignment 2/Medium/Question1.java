public class Question1 {
    public static void main(String[] args) {
        Book novel = new Book("1984", "George Orwell", "1001");
        Book selfHelp = new Book("Deep Work", "Cal Newport", "1002");
        Book fiction = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1003");
        Book science = new Book("A Brief History of Time", "Stephen Hawking", "1004");
        Book philosophy = new Book("Meditations", "Marcus Aurelius", "1005");

        novel.showDetails();
        selfHelp.showDetails();
        fiction.showDetails();
        science.showDetails();
        philosophy.showDetails();
    }
}

class Book {
    String title;
    String author;
    String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void showDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println();
    }
}