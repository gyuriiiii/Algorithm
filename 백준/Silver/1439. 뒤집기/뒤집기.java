import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int cnt0 = 0;
        int cnt1 = 0;

        boolean flag = true;
        char tmp = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(0)) {
                flag = false;
            }

            if (tmp != S.charAt(i)) {
                if (tmp == '0') {
                    cnt0++;
                } 
                else {
                    cnt1++;
                }
                tmp = S.charAt(i);
            }
        }

        if (flag) {
            System.out.println(0);
        } 
        else {

            if (S.charAt(S.length() - 1) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
            System.out.println(cnt0 < cnt1 ? cnt0 : cnt1);
        }
    }
}