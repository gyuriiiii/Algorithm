import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 컵 위치 바꾼 횟수
        int[] arr = new int[3];
        arr[0] = 1;

        for(int i=0; i<M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            int temp = arr[X-1];
            arr[X-1] = arr[Y-1];
            arr[Y-1] = temp;
        }

        int result = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                result = i+1; 
                break;
            }
        }
        System.out.println(result);
    }
}