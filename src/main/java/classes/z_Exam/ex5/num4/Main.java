package classes.z_Exam.ex5.num4;

public class Main {
    public static void main(String[] args) {
        PlaylistManager pl = new PlaylistManager();

        pl.addSong("Ditto");
        pl.addSong("OMG");
        pl.addSong("Hype Boy");

        pl.PlayNext();
        pl.PlayNext();
        pl.addFirstSong("Attention");   //우선 예약
        pl.printPlaylist();
        pl.PlayNext();
        pl.PlayNext();
        pl.PlayNext();
        pl.printPlaylist();
    }
}
