import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<4; j++) {
                arr[i] += sc.nextInt();
            }
        }

        int max = arr[0];
        int maxNum = 0;
        for(int i=0; i<5; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxNum = i;
            }
        }
        System.out.println((maxNum+1) + " " + max);
    }
}