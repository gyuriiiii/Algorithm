import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        StringBuilder sb = new StringBuilder();  
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        sb.append("<");
        while(!queue.isEmpty()) { // 큐가 빌 때 까지
            for(int i=0; i<k-1; i++) {
                int num = queue.poll(); // 큐의 첫번째 값
                queue.offer(num); // 뒤로 보내기
            }
            if(queue.size()==1) {
                sb.append(queue.poll()).append(">");                
            }
            else {
                sb.append(queue.poll()).append(", ");
            }
        }
        System.out.println(sb);
    }
}