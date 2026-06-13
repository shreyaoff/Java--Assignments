public class Question5 {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Bhootnath", "Hindi", 5);
        Movie movie2 = new Movie("Dreams", "Nepali", 3.5);
        Movie movie3 = new Movie("Ginny and Georgia", "American", 5);

        movie1.displayMovieDetails();
        movie2.displayMovieDetails();
        movie3.displayMovieDetails();
    }
}

class Movie{
    String name;
    String language;
    double rating;

    public Movie(String name, String lang, double rate){
        this.name = name;
        this.language = lang;
        this.rating = rate;
    }

    public void displayMovieDetails(){
        System.out.println("Movie Name: " + this.name);
        System.out.println("Language: " + this.language);
        System.out.println("Rating: " + this.rating);
    }
}