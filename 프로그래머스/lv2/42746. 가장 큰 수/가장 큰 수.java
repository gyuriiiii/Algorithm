import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.toString(numbers[i]));
        }

        Collections.sort(list, (o1, o2) -> {
            int a = Integer.parseInt(o1 + "" + o2);
            int b = Integer.parseInt(o2 + "" + o1);

            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}