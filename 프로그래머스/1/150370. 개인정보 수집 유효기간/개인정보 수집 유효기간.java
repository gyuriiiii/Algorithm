import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Character, Integer> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0].charAt(0), Integer.parseInt(term[1]));
        }

        today = today.replace(".", "");

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            int year = Integer.parseInt(privacy[0].substring(0, 4));
            int month = Integer.parseInt(privacy[0].substring(5, 7));
            int day = Integer.parseInt(privacy[0].substring(8, 10));

            int plus = termMap.get(privacy[1].charAt(0));

            int plusYear = 0;
            int plusMonth = plus;

            if (plus >= 12) {
                plusYear = plus / 12;
                plusMonth = plus % 12;
            }

            year += plusYear;
            month += plusMonth;

            if (month > 12) {
                int plusY = month / 12;
                year += plusY;
                month -= 12;
            }

            if (day - 1 == 0) {
                day = 29;
                month--;
            }

            String date = String.format("%4d", year) + "" + String.format("%02d", month) + "" + String.format("%02d", day - 1);


            if (Integer.parseInt(date) < Integer.parseInt(today)) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}