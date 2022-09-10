import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();

        int a6 = (a1*a2);
        int a3 = (a1*(a2%10));
        a2/=10;
        int a4 = (a1*(a2%10));
        a2/=10;
        int a5 = (a1*(a2%10));

        StringBuilder sb = new StringBuilder();
        sb.append(a3).append("\n").append(a4).append("\n").append(a5).append("\n").append(a6);
        System.out.println(sb);
    }
}