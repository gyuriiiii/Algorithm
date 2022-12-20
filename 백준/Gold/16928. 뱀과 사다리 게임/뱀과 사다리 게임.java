import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] game = new int[101]; // 게임판
    static int [] check = new int[101]; // 방문 여부
    static int [] count = new int[101]; // count
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 사다리의 수
        int M = sc.nextInt(); // 뱀의 수

        // 사다리 정보
        for(int i=0; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            game[x] = y;
        }

        // 뱀 정보
        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            game[x] = y;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        
        check[1] = 1; // 방문 표시
        queue.add(1); // 큐에 추가

        while(!queue.isEmpty()) { // 큐가 빌 때까지
            int current = queue.poll();

            if(current==100) {
                System.out.println(count[current]);
                return;
            }

            // 주사위 굴리기
            for(int i=1; i<=6; i++) {
                int x = current + i; // 주사위 굴린 후 위치

                if(x>100) continue; // 100 넘으면
                if(check[x] == 1) continue; // 이미 방문했으면

                check[x] = 1;

                if(game[x] != 0) { // 사다리 혹은 뱀의 위치일 때
                    if(check[game[x]] == 0) { // 해당 위치 간 적 없을 때
                        queue.add(game[x]); // 큐에 추가
                        check[game[x]] = 1; // 방문 표시
                        count[game[x]] = count[current] + 1;
                    }
                }
                else { // 아무 것도 없을 때
                    queue.add(x);
                    count[x] = count[current] + 1;
                }
            }
        }
    }
}
