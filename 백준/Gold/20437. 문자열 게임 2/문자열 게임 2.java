import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            // 알파벳 개수 구하기
            for (int j = 0; j < W.length(); j++) {
                map.put(W.charAt(j), map.getOrDefault(W.charAt(j), 0) + 1);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < W.length(); j++) {
                char c = W.charAt(j);
                int len = 1; // 단어 길이
                int cnt = 1; // 같은 알파벳 개수

                if (map.get(c) < K) {
                    continue;
                }

                for (int k = j + 1; k < W.length(); k++) {
                    if (c == W.charAt(k)) {
                        cnt++;
                    }
                    len++;

                    if (cnt == K) {
                        min = Math.min(min, len);
                        max = Math.max(max, len);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println(-1);
            } 
            else {
                System.out.println(min + " " + max);
            }
        }
    }
}