import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pq.add(sc.nextInt());
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}