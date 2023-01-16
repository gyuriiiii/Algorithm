import java.util.Scanner;

public class Main {
    static String num;
    static String newNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        if (N < 10) {
            num = 0 + "" + N;
        } 
        else {
            num = Integer.toString(N);
        }

        newNum = num;
        while (true) {
            cnt++;

            // 주어진 수 각 자리 수와
            // 각 자리 수 합 구하기
            int left = Integer.parseInt(newNum.charAt(0) + "");
            int right =Integer.parseInt(newNum.charAt(1) + ""); 
            int add = left + right;

            if(add < 10) {
                newNum = right + "" + add;
            }
            else {
                newNum = right + "" + (add-10);
            }

            if(Integer.parseInt(newNum) == N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}