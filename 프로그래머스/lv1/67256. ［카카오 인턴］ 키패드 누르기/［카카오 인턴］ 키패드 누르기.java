import java.util.HashMap;

public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, int[]> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(idx++, new int[] { i, j }); // 키패드 숫자와 x, y 좌표 저장
            }
        }
        map.put(0, new int[] { 3, 1 });

        int posL[] = new int[] { 3, 0 }; // 현재 왼손의 x, y위치 저장
        int posR[] = new int[] { 3, 2 }; // 현재 오른손의 x, y위치 저장

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i]; // 눌러야 할 숫자

            if (n == 1 || n == 4 || n == 7) { // 왼손 엄지손가락 사용
                sb.append("L");
                posL[0] = map.get(n)[0];
                posL[1] = map.get(n)[1];
            }

            else if (n == 3 || n == 6 || n == 9) { // 오른손 엄지손가락 사용
                sb.append("R");
                posR[0] = map.get(n)[0];
                posR[1] = map.get(n)[1];
            }

            else { // 그 외 - 더 가까운 손가락으로 누르기
                int x = map.get(n)[0]; // 눌러야 할 숫자의 x 좌표
                int y = map.get(n)[1]; // 눌러야 할 숫자의 y 좌표

                // 왼손과 오른손 중 어떤 손이 더 가까운 지 체크
                if ((Math.abs(x - posL[0]) + Math.abs(y - posL[1])) < (Math.abs(x - posR[0]) + Math.abs(y - posR[1]))) {
                    sb.append("L");
                    posL[0] = x;
                    posL[1] = y;
                }
                else if ((Math.abs(x - posL[0]) + Math.abs(y - posL[1])) > (Math.abs(x - posR[0]) + Math.abs(y - posR[1]))) {
                    sb.append("R");
                    posR[0] = x;
                    posR[1] = y;
                }
                else {
                    sb.append(hand.equals("right") ? "R" : "L");

                    if (hand.equals("right")) {
                        posR[0] = x;
                        posR[1] = y;
                    }

                    else {
                        posL[0] = x;
                        posL[1] = y;
                    }
                }
            }
        }
        return sb.toString();
    }
}