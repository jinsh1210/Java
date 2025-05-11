package classes.z_Exam.ex5.num4;

import java.util.LinkedList;
import java.util.Stack;

public class PlaylistManager {
    private LinkedList<String> playlist;

    public PlaylistManager() {
        playlist = new LinkedList<>();
    }

    void addSong(String title) {
        playlist.add(title);
    }

    void addFirstSong(String title) {
        playlist.addFirst(title);
    }

    void PlayNext() {
        if (playlist != null && playlist.size() > 0) {    //재생 목록이 존재할 때
            System.out.print("지금 재생 중: ");
            System.out.println(playlist.peek());
            playlist.pop();
        } else {    // 리스트가 비어 있을 때
            System.out.println("재생할 노래가 없습니다.");
        }
    }

    void printPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("재생 목록이 비어 있습니다.");
        } else {
            System.out.println("현재 재생 목록: ");
            for (String s : playlist) {
                System.out.println(s);
            }
        }
    }
}