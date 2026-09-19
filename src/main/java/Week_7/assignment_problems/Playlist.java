package Week_7.assignment_problems;


public class Playlist {

    private String[] songs;
    private int songCount;

    Playlist(int size) {
        songs = new String[size];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("First song: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}