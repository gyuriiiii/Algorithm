import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        int sum = 0;

        String s = br.readLine();
        while (true) {
            if (map.containsKey(s)) {
                int cnt = map.get(s);
                map.put(s, cnt + 1);
            }
            else {
                map.put(s, 1);
            }
            sum ++;

            s = br.readLine();
            if (s == null || s.length() == 0) {
                break;
            }
        }

        ArrayList<String> name = new ArrayList<>(map.keySet());
        Collections.sort(name, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String n : name) {
            double per = map.get(n) * 100.0 / sum;
            sb.append(n + " " + String.format("%.4f\n", per));
        }
        System.out.println(sb);
    }
}