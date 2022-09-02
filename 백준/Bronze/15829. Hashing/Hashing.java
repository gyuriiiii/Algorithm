import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int M = 1234567891;

        int l = Integer.parseInt(bf.readLine()); // 문자열 길이
        String s = bf.readLine();
        char[] arr = s.toCharArray();

        long a = 1;
        long sum = 0;
        for (int i = 0; i < l; i++) {
            sum += (arr[i] - 'a' + 1) * a % M;
            a = a * 31 % M;
        }
        System.out.println(sum%M);
    }
}