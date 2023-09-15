import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int j = 0; j < T; j++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = sc.nextInt();

            for (int i = 0; i < k; i++) {
                char order = sc.next().charAt(0);
                int n = sc.nextInt();

                if (order == 'D') {
                    if (!map.isEmpty()) {
                        int num = 0;

                        if (n == 1) {
                            num = map.lastKey();
                        }
                        else {
                            num = map.firstKey();
                        }

                        if (map.get(num) > 1) {
                            map.put(num, map.get(num) - 1);
                        }
                        else {
                            map.remove(num);
                        }
                    }
                }
                else {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
            }

            if (map.size() == 0) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}