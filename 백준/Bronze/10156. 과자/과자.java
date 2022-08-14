import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken()); // 과자 하나 가격
        int n = Integer.parseInt(st.nextToken()); // 사려는 과자 수
        int m = Integer.parseInt(st.nextToken()); // 현재 가진 돈

        int result = k*n;
        if(result >= m) {
            System.out.println(result-m);
        }
        else {
            System.out.println(0);
        }
    }
}