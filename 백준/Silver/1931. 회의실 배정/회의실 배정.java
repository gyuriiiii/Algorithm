import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 회의 수

        // time[][0] = 시작
        // time[][1] = 종료
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt(); // 시작 시간
            int end = sc.nextInt(); // 종료 시간

            time[i][0] = start;
            time[i][1] = end;
        }

        // 종료 시간 기준으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] n1, int[] n2) {
                // 종료 시간이 같은 경우
                // 시작 시간이 빠른 순으로 정렬
                if(n1[1] == n2[1]) {
                    return n1[0] - n2[0];
                }
                
                return n1[1] - n2[1]; // 종료 시간이 빠른 순으로 정렬
            }
        });

        int cnt = 0;
        int prev_end_time = 0;
        for (int i = 0; i < N; i++) {
            // 이전의 끝나는 시간과 시작 시간이 겹치지 않는 경우
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}