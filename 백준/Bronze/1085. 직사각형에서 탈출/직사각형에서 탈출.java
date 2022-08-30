import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현 위치
        int x = sc.nextInt();   
        int y = sc.nextInt();   

        // 직사각형 꼭짓점 위치
        int w = sc.nextInt();   
        int h = sc.nextInt();   

        double[] arr = new double[4];
        arr[0] = Math.sqrt(Math.pow(x-x,2) + Math.pow(y-h, 2));
        arr[1] = Math.sqrt(Math.pow(x-w,2) + Math.pow(y-y, 2));
        arr[2] = Math.sqrt(Math.pow(x-0,2) + Math.pow(y-y, 2));
        arr[3] = Math.sqrt(Math.pow(x-x,2) + Math.pow(y-0, 2));
        Arrays.sort(arr);

        System.out.println((int) arr[0]);
    }
    
}
