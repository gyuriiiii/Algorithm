import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        ArrayList<Integer> remove = new ArrayList<>();

        while (!dq.isEmpty()) {
            remove.add(dq.pollFirst());

            if(!dq.isEmpty()) {
                dq.addLast(dq.pollFirst());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : remove) {
            sb.append(r + " ");
        }
        System.out.println(sb);
    }
}