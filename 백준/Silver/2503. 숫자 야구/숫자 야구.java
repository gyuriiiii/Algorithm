import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[] check = new boolean[1000];

        for (int j = 123; j < 1000; j++) {
            String s = Integer.toString(j);

            if (s.contains("0")) {
                continue;
            }
            else if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2)) {
                continue;
            }

            check[j] = true;
        }

        for (int i = 0; i < N; i++) {
            String num = Integer.toString(sc.nextInt());
            int strike = sc.nextInt();
            int ball = sc.nextInt();

            for (int j = 123; j < 1000; j++) {
                if (check[j]) {
                    String n = Integer.toString(j);

                    int s = 0;
                    int b = 0;

                    for (int k = 0; k < 3; k++) {
                        if (num.charAt(k) == n.charAt(k)) {
                            s++;
                        }
                        else {
                            if (num.contains(n.charAt(k) + "")) {
                                b++;
                            }
                        }
                    }

                    if (s == strike && b == ball) {
                        check[j] = true;
                    }
                    else {
                        check[j] = false;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 123; i < 1000; i++) {
            if (check[i]) answer++;
        }
        System.out.println(answer);
    }
}