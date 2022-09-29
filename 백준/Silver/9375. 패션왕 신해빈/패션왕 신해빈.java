import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // 테스트 케이스 개수
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();

            // n개의 해빈이가 가진 의상 이름과 의상 종류
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String name = sc.next();
                String type = sc.next();

                if (!map.containsKey(type)) {
                    map.put(type, 1);
                } 
                else {
                    map.put(type, map.get(type) + 1);
                }
            }

            int result = 1;
            for (Integer value : map.values()) {
                result *= (value+1);
            }

            System.out.println(result-1);
        }
    }
}