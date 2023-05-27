import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> num = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                String product = discount[j];

                if (num.containsKey(product)) {
                    int cnt = num.get(product);
                    num.put(product, cnt + 1);
                }
                else {
                    num.put(product, 1);
                }
            }

            if (check(map, num)) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean check(HashMap<String, Integer> map, HashMap<String, Integer> num) {
        for (String product : map.keySet()) {
            if (!num.containsKey(product)) {
                return false;
            }

            if (map.get(product) > num.get(product)) {
                return false;
            }
        }
        return true;
    }
}