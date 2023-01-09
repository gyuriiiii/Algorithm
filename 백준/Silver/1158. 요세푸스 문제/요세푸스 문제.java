import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        
        int idx = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                if(idx % K == 0) {
                    int q = queue.peek();
                    list.add(q);
                    queue.poll();
                }
                else {
                    int q = queue.peek();
                    queue.offer(q);
                    queue.poll();
                }
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder("<");
        for(int i=0; i<list.size(); i++) {
            if(i==list.size()-1) {
                sb.append(list.get(i) +">");
                continue;
            }
            sb.append(list.get(i) + ", ");
        }
        System.out.println(sb);
    }
}