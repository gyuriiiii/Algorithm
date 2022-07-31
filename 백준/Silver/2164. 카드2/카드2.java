import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(queue.size()>1) {
            queue.poll(); // 제일 위의 카드 버리기
            int number = queue.poll(); // 그 다음 위의 카드 옮기기
            queue.offer(number);
        }
        System.out.println(queue.poll());
    }
}