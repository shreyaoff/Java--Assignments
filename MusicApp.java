// Question 10: Music Player App
// Class Song with fields title, artist and method play().
// Subclasses: PopSong, RockSong, JazzSong override play() with unique messages.
// Demonstrate polymorphic behavior using a playlist of Song[].

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    public void play() {
        System.out.println("Now playing: " + title + " by " + artist);
    }
}

class PopSong extends Song {
    public PopSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    public void play() {
        System.out.println("[POP] Catchy beats and bright vibes! Playing: " + getTitle() + " by " + getArtist());
    }
}

class RockSong extends Song {
    public RockSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    public void play() {
        System.out.println("[ROCK] Guitar riffs and power chords! Playing: " + getTitle() + " by " + getArtist());
    }
}

class JazzSong extends Song {
    public JazzSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    public void play() {
        System.out.println("[JAZZ] Smooth improvisation! Playing: " + getTitle() + " by " + getArtist());
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Song[] playlist = {
            new PopSong("Blinding Lights", "The Weeknd"),
            new RockSong("Bohemian Rhapsody", "Queen"),
            new JazzSong("Take Five", "Dave Brubeck"),
            new PopSong("Levitating", "Dua Lipa"),
            new RockSong("Smells Like Teen Spirit", "Nirvana")
        };

        System.out.println("===== Your Playlist =====");
        for (Song song : playlist) {
            song.play();
        }
    }
}
