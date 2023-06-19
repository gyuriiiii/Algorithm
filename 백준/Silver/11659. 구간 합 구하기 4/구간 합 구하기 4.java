import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());

            sb.append(arr[end] - arr[start-1] + "\n");
        }
        System.out.println(sb);
    }
}