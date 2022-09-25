import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤토리에 든 블록 개수

        // N개의 줄에 각각 M개의 정수로 땅 높이 주어짐
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] height = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, height[i][j]);
                min = Math.min(min, height[i][j]);
            }
        }

        int result = 0; // 땅 높이

        // 블록 최소 높이 ~ 최대 높이까지 각 높이마다 소요되는 시간 계산
        // 최소 소요시간 찾기
        int minTime = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int time = 0; // 걸리는 시간
            int blocks = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 땅에서 블록 제거해 인벤토리에 추가 (2초)
                    if(height[j][k] > i) {
                        time += (height[j][k]-i)*2;
                        blocks += (height[j][k]-i);
                    }

                    // 인벤토리에서 꺼내서 블록 쌓기 (1초)
                    else {
                        time += (i-height[j][k]);
                        blocks -= (i-height[j][k]);
                    }
                }
            }

            if(blocks>=0 && time <= minTime) {
                minTime = time;
                result = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(minTime).append(" ").append(result);
        System.out.println(sb);
    }
}