import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 입력 데이터 수

        for(int i=0; i<T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int k = sc.nextInt(); // 큐에 적용할 연산의 개수

            for(int j=0; j<k; j++) {
                String s = sc.next();
                int n = sc.nextInt();

                if(s.equals("I")) { // 삽입
                    map.put(n, map.getOrDefault(n, 0) + 1); 
                }
                else if(s.equals("D")) { // 삭제
                    if(map.isEmpty()) {
                        continue;
                    }

                    int num = n == -1 ? map.firstKey() : map.lastKey();

                    if(map.get(num) > 1) {
                        map.put(num, map.get(num)-1);
                    }
                    else {
                        map.remove(num);
                    }
                }
            }

            if(map.size() == 0) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}