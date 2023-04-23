import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<String> words;
    static HashMap<String, Integer> wordsMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        wordsMap = new HashMap<>(); // 단어 나온 횟수

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.length() < M) {
                continue;
            }
            wordsMap.put(s, wordsMap.getOrDefault(s, 0) + 1); // 나온 횟수 저장
        }

        words = new ArrayList<>(wordsMap.keySet());
        Collections.sort(words, new WordsComparator());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i) + "\n");
        }
        System.out.println(sb);
    }

    static class WordsComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if(wordsMap.get(s1) == wordsMap.get(s2)) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s2.length() - s1.length();
            }
            return wordsMap.get(s2) - wordsMap.get(s1);
        }
    }
}