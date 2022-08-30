import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); // 개1 공격
        int B = sc.nextInt(); // 개1 휴식
        int C = sc.nextInt(); // 개2 공격
        int D = sc.nextInt(); // 개2 휴식

        // 개 몇마리에게 공격 받는지 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            int P = sc.nextInt();
            int sum = 0;

            if(P%(A+B)>=1 && P%(A+B)<=A) {
                sum++;
            }

            if(P%(C+D)>=1 && P%(C+D)<=C) {
                sum++;
            }

            sb.append(sum).append(" ");
        }
        System.out.println(sb);
    }
}