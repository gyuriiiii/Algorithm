import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int idx = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                if (idx % K == 0) {
                    int q = queue.peek();
                    list.add(q);
                    queue.poll();
                } else {
                    int q = queue.peek();
                    queue.offer(q);
                    queue.poll();
                }
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i) + ">");
                continue;
            }
            sb.append(list.get(i) + ", ");
        }
        System.out.println(sb);
    }
}