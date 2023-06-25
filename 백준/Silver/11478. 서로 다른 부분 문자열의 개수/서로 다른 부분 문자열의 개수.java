import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String s;
    static HashMap<String, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.next();
        map = new HashMap<>();

        for (int i = 1; i <= s.length(); i++) {
            makeWord(i);
        }
        System.out.println(map.size());
    }

    private static void makeWord(int len) {
        for (int i = 0; i < s.length() - len + 1; i++) {
            String word = s.substring(i, i + len);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}