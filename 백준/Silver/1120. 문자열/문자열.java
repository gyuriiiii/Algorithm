import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int len = A.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < B.length() - len + 1; i++) {
            String newB = "";
            for (int j = i; j < i + len; j++) {
                newB += (B.charAt(j) + "");
            }
            min = Math.min(comp(A, newB), min);
        }
        System.out.println(min);
    }

    // 문자열 A와 B 차이 구하기
    private static int comp(String A, String B) {
        int cnt = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}