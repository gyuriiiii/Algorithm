import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        String S = sc.next();
        
        String[] arr = new String[S.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        
        int idx = 0;
        for(int i=0; i<S.length(); i++) {
            for (int j = idx; j < S.length(); j++) {                
                arr[i]  = arr[i] + S.charAt(j);
            }
            idx++;
        }
        Arrays.sort(arr);

        for (String s : arr) {
            System.out.println(s);
        }
    }
}