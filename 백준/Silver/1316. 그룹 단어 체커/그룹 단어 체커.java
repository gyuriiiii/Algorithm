import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            boolean[] check = new boolean[26]; // 사용여부 표시
            boolean flag = true;

            for (int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a'; // 알파벳 -> 숫자

                // 사용한 적 있는 문자
                if (check[idx]) {
                    // 직전 문자와 다른 경우 (그룹문자 X)
                    if (s.charAt(j) != s.charAt(j - 1)) {
                        flag = false; 
                    }
                }

                // 사용한 적 없는 문자
                else {
                    check[idx] = true;
                }

            }
            if(flag) { // 그룹 문자인 경우
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}