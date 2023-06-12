import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Integer> map;
    static int[] parent;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int F = sc.nextInt();

            parent = new int[F * 2];
            cnt = new int[F * 2];

            for (int j = 0; j < F * 2; j++) {
                parent[j] = j;
                cnt[j] = 1;
            }

            map = new HashMap<>();

            int idx = 0;
            for (int j = 0; j < F; j++) {
                String person1 = sc.next();
                String person2 = sc.next();

                if (!map.containsKey(person1)) {
                    map.put(person1, idx++);
                }
                if (!map.containsKey(person2)) {
                    map.put(person2, idx++);
                }

                int cnt = union(person1, person2);
                System.out.println(cnt);
            }
        }
    }


    private static int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }

    private static int union(String person1, String person2) {
        int x = find(map.get(person1));
        int y = find(map.get(person2));

        if (x != y) {
            parent[x] = y;
            cnt[y] += cnt[x];
            return cnt[y];
        }
        return cnt[x];
    }
}