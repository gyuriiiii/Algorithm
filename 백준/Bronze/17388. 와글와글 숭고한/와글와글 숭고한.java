import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        if (sum >= 100) {
            System.out.println("OK");
        }

        else {
            int min = arr[0];
            int result = 0;

            for (int i = 0; i < 3; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    result = i;
                }
            }

            switch (result) {
                case 0:
                    System.out.println("Soongsil");
                    break;
                case 1:
                    System.out.println("Korea");
                    break;
                case 2:
                    System.out.println("Hanyang");
                    break;
            }
        }
    }
}