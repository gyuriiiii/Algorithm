import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt(); 
        int small = Math.min(a, b);
        int big = Math.max(a, b);

        int gcd = gcd(small, big); // 최대 공약수
        int lcm = small*big/gcd; // 최소 공배수

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int big, int small) {
        if(big%small==0) {
            return small;
        }
        return gcd(small, big%small);
    }
}
