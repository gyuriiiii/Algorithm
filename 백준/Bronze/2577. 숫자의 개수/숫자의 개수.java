import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String[] num = Integer.toString(a*b*c).split("");
        int[] arr = new int[10]; // 숫자 개수 저장 배열
        for (int i = 0; i < num.length; i++) {
            arr[Integer.parseInt(num[i])]++;
        }

        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
