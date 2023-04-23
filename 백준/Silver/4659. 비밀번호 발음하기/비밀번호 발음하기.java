import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Character> vowels = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while (true) {
            String s = sc.next();

            if (s.equals("end")) break;

            if (!step1(s) || !step2(s) || !step3(s)) {
                sb.append("<" + s + "> is not acceptable.").append("\n");
                continue;
            }
            sb.append("<" + s + "> is acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean step1(String s) {
        if (!(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u"))) {
            return false;
        }
        return true;
    }

    private static boolean step2(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            String word = s.substring(i, i + 3);

            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(1)) && vowels.contains(word.charAt(2))) {
                return false;
            }
            else if (!vowels.contains(word.charAt(0)) && !vowels.contains(word.charAt(1)) && !vowels.contains(word.charAt(2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean step3(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}