import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 나무 개수
        int M = sc.nextInt(); // 집으로 가져가려는 나무 길이
        
        int[] arr = new int[N];

        int min = 0;
        int max = 0;

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();

            if(max < arr[i]) {
                max = arr[i];
            }
        }

        while(min <= max) {
            int mid = (min+max)/2;
            long sum = 0;

            for (int i : arr) {
                if(i-mid > 0) {
                    sum += (i-mid);
                }
            }

            if(sum < M) {
                max = mid-1;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}