import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int[] sanguen = new int[N];
        for (int i = 0; i < N; i++) {
            sanguen[i] = sc.nextInt();
        }
        Arrays.sort(sanguen);

        int M = sc.nextInt();
        int[] card = new int[M];
        for (int i = 0; i < M; i++) {
            card[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i : card) {
            int idx = Arrays.binarySearch(sanguen, i);
            if(idx < 0) {
                sb.append("0 ");
            }
            else {
                sb.append("1 ");
            }
        }
        System.out.println(sb);
    }
}