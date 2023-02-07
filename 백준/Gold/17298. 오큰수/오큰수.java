import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peekLast()) {
                stack.pollLast();
            }

            answer[i] = stack.isEmpty()? -1 : stack.peekLast();

            stack.addLast(arr[i]);
        }

        for (int i = N - 1; i >= 0; i--) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}