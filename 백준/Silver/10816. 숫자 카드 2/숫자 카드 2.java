import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> hash = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (hash.get(num) == null) { 
                hash.put(num, 1);
            } 
            else { 
                hash.put(num, hash.get(num) + 1);
            }
        }

        int m = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine(), " ");
        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(check(hash, num)).append(' ');
        }
        System.out.println(sb);
    }

    static int check(HashMap<Integer, Integer> hash, int num) {
        if (hash.get(num) != null) {
            return hash.get(num);
        }
        return 0;
    }
}