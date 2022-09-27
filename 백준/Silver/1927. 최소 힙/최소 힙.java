import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산 개수

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x->x));
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num==0) {
                if(queue.size()==0) {
                    sb.append("0").append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else {
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}