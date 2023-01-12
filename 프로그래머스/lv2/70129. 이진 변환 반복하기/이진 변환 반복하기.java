import java.util.ArrayList;

class Solution {
    static int zeroCnt;
    static int changeCnt;
    
        static public ArrayList<Integer> solution(String s) {
        changeCnt = 1;

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1') {
                list.add(c);
            }

            else {
                zeroCnt++;
            }
        }

        int len = list.size();
        while (true) {
            // 이진 변환
            s = Integer.toString(len, 2);
            if (s.equals("1")) {
                break;
            }
            len = removeZero(s);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(changeCnt);
        answer.add(zeroCnt);
        
        return answer;
    }

    // 0 제거하는 메소드
    private static int removeZero(String s) {
        ArrayList<Character> list = new ArrayList<>();

        changeCnt++;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1') {
                list.add(c);
            } else {
                zeroCnt++;
            }
        }
        return list.size();
    }
}