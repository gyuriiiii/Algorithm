import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> solution(String s) {
        String[] arr = s.split("},");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", "");
            arr[i] = arr[i].replace("}", "");
        }

        Arrays.sort(arr, ((o1, o2) -> Integer.compare(o1.length(), o2.length())));

        ArrayList<Integer> answer = new ArrayList<>();

        for (String num : arr) {
            String[] split = num.split(",");
            for (String sp : split) {
                if(!answer.contains(Integer.parseInt(sp))) {
                    answer.add(Integer.parseInt(sp));
                }
            }
        }

        return answer;
    }
}