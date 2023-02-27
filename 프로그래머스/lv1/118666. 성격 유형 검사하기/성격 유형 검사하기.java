import java.util.HashMap;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        int[] score = new int[] { 0, 3, 2, 1, 0, 1, 2, 3 }; // 각 항목별 점수

        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];

            if (choice <= 4) { // 비동의
                char s = survey[i].charAt(0);
                map.put(s, map.get(s) + score[choice]);
            } 
            else { // 동의
                char s = survey[i].charAt(1);
                map.put(s, map.get(s) + score[choice]);
            }
        }

        char[] result = new char[] {'R', 'C', 'J', 'A'};
        if (map.get('R') < map.get('T')) {
            result[0] = 'T';
        } 
        if (map.get('C') < map.get('F')) {
            result[1] = 'F';
        }
        if (map.get('J') < map.get('M')) {
            result[2] = 'M';
        }
        if (map.get('A') < map.get('N')) {
            result[3] = 'N';
        }
        
        StringBuilder sb=  new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }
}