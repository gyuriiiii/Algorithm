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
            if (wordsMap.get(s1) < wordsMap.get(s2)) {
                return 1;
            }
            else if (wordsMap.get(s1) > wordsMap.get(s2)) {
                return -1;
            }
            else {
                // 길이 긴 순으로 정렬
                if (s1.length() < s2.length()) {
                    return 1;
                }
                else if (s1.length() > s2.length()) {
                    return -1;
                }
                // 길이 같은 경우
                else if (s1.length() == s2.length()) {
                    // 알파벳 사전 순으로 앞에 있는 단어부터 정렬
                    if (s1.compareTo(s2) > 0) {
                        return 1;
                    }
                    else if (s1.compareTo(s2) < 0) {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }
}