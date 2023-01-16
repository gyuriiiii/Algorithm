import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static long A;
    static long B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        bfs(A, B);
    }

    private static void bfs(long a, long b) {
        Queue<Long> queue = new ArrayDeque<>();
        HashMap<Long, Integer> map = new HashMap<>();

        queue.add(a);
        map.put(a, 1);

        while (!queue.isEmpty()) {
            long q = queue.poll();

            if (q == B) {
                System.out.println(map.get(q));
                return;
            }

            if (q * 2 <= B && !map.containsKey(q * 2)) {
                queue.add(q * 2);
                map.put(q * 2, map.get(q) + 1);
            }

            if (q * 10 + 1 <= B && !map.containsKey(q * 10 + 1)) {
                queue.add(q * 10 + 1);
                map.put(q * 10 + 1, map.get(q) + 1);
            }
        }
        System.out.println(-1);
        return;
    }
}