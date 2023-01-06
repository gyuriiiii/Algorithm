import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();

        int cnt = 0;
        int answer = 0;
        for (int i = 1; i < M - 1;) {

            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;

                if (cnt == N) {
                    // 맨 앞에 I 맞는지 검사
                    if (S.charAt(i - (cnt * 2 - 1)) == 'I') {
                        answer++;
                    }
                    cnt--;
                }
                i += 2; // OI 맞는 경우엔 인덱스 + 2
            }

            // OI 아닌 경우엔 바로 다음 인덱스부터 검사
            else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(answer);
    }
}