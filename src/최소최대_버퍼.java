import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소최대_버퍼 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 공백도 같이 입력됨
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        int[] arr = new int[n];
        while(st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        Arrays.sort(arr);
        System.out.print(arr[0] + " " + arr[n-1]);
    }
}

