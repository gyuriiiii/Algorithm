import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        sc.nextLine();
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]) {
                    return arr1[1]-arr2[1];
                } 
                return arr1[0]-arr2[0];
            }
        });
        
        for (int[] i : arr) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
