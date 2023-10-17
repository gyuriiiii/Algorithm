import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        HashSet<Character> words = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            words.add(skill.charAt(i));
        }

        for (String s : skill_trees) {
            for (int i = 0; i < s.length(); i++) {
                if (!words.contains(s.charAt(i))) {
                    s = s.replace(s.charAt(i), 'x');
                }
            }

            s = s.replaceAll("x", "");

            if (skill.substring(0, s.length()).equals(s)) {
                answer++;
            }
        }

        return answer;
    }
}