import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        HashMap<String, Integer> sound = new HashMap<>();
        sound.put("C#", 1);
        sound.put("D#", 2);
        sound.put("F#", 3);
        sound.put("G#", 4);
        sound.put("A#", 5);

        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == '#') {
                String tmp = m.substring(i - 1, i + 1);
                m = m.replaceFirst(tmp, sound.get(tmp) + "");
            }
        }

        ArrayList<Song> list = new ArrayList<>();

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");

            int start = Integer.parseInt(info[0].split(":")[0]) * 60 + Integer.parseInt(info[0].split(":")[1]);
            int end = Integer.parseInt(info[1].split(":")[0]) * 60 + Integer.parseInt(info[1].split(":")[1]);
            int playTime = end - start;
            String music = info[3];

            for (int i = 0; i < music.length(); i++) {
                if (music.charAt(i) == '#') {
                    String tmp = music.substring(i - 1, i + 1);
                    music = music.replaceFirst(tmp, sound.get(tmp) + "");
                }
            }

            int iter = playTime / music.length();
            int remain = playTime % music.length();

            String play = "";
            for (int i = 0; i < iter; i++) {
                play += music;
            }
            play += (music.substring(0, remain + 1));

            if (play.contains(m)) {
                list.add(new Song(info[2], playTime));
            }
        }

        if (list.isEmpty()) {
            return "(None)";
        }

        Collections.sort(list, ((o1, o2) -> Integer.compare(o2.playTime, o1.playTime)));
        return list.get(0).title;
    }

    static public class Song {
        String title;
        int playTime;

        public Song(String title, int playTime) {
            this.title = title;
            this.playTime = playTime;
        }
    }
}