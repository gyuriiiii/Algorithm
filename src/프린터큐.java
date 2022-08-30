import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 알아내려는 문서

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++) {
                queue.offer(new int[] { j, Integer.parseInt(st.nextToken()) }); // j번째 문서 / 중요도
            }

            int cnt = 0; // 출력 횟수
            while(!queue.isEmpty()) { // 큐가 빌 때 까지
                int front[] = queue.poll();
                boolean flag = true;

                for(int k=0; k<queue.size(); k++) {
                    if(front[1] < queue.get(k)[1]) {
                        queue.offer(front);

                        for(int h=0; h<k; h++) {
                            queue.offer(queue.poll()); 
                        }

                        flag = false;
                        break;
                    }
                }

                if(flag == false) { // 해당 문서가 가장 중요하지 않은 경우
                    continue;
                }
                
                cnt++;
                if(front[0] == m) { // 찾고자 하는 문서이면 종료
                    break;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    
}
