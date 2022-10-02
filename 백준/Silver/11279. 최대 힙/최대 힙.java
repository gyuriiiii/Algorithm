import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산 개수

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x==0) {
                if(queue.size()==0) sb.append("0").append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else {
                queue.add(x);
            }
        }
        System.out.println(sb);
    }
}