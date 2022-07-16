import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[101]; 
        
        for (int i : arr) {
            i = 0;
        }

        for(int i=0; i<n; i++) {
            arr[sc.nextInt()]++;
        }

        int num = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 2) {
                num += arr[i]-1;
            }
        }
        System.out.println(num);
    }   
}