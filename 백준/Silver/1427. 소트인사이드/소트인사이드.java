import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String N = Integer.toString(sc.nextInt());
        
        Integer[] arr = new Integer[N.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(N.charAt(i) + "");
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (Integer i : arr) {
            System.out.print(i);    
        }
    }
}