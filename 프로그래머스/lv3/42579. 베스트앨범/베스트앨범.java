import java.util.*;

public class Solution {
    public ArrayList solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        /* 장르별 노래 재생 횟수 */
        HashMap<String, Integer> genreNum = new HashMap<>();
        for (String genre : genres) {
            genreNum.put(genre, 0);
        }

        for (int i = 0; i < plays.length; i++) {
            int num = genreNum.get(genres[i]);
            genreNum.put(genres[i], num + plays[i]);
        }

        /* 베스트 앨범에 실릴 장르 순서 */
        ArrayList<Map.Entry<String, Integer>> genreOrder = new ArrayList<>(genreNum.entrySet());
        genreOrder.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        /* 장르별 노래와 재생횟수 */
        HashMap<String, ArrayList<Song>> genreSong = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (genreSong.containsKey(genres[i])) {
                ArrayList list = genreSong.get(genres[i]);
                list.add(new Song(i, plays[i]));
                genreSong.put(genres[i], list);
            }
            else {
                ArrayList list = new ArrayList();
                list.add(new Song(i, plays[i]));
                genreSong.put(genres[i], list);
            }
        }
        
        for (Map.Entry<String, Integer> order : genreOrder) {
            ArrayList<Song> songs = genreSong.get(order.getKey());
            if(songs.size() == 1) {
                answer.add(songs.get(0).songNum);
            }
            else {
                songs.sort(new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        return o2.playNum - o1.playNum;
                    }
                });
                answer.add(songs.get(0).songNum);
                answer.add(songs.get(1).songNum);
            }
        }

        return answer;
    }

    static public class Song {
        int songNum; // 노래 고유 번호
        int playNum; // 재생 횟수

        public Song(int songNum, int playNum) {
            this.songNum = songNum;
            this.playNum = playNum;
        }
    }
}