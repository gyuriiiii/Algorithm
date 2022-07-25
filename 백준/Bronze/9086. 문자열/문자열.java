import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        
        int t = sc.nextInt();
        String[] arr = new String[t];
        for(int i=0; i<t; i++) {
            arr[i] = sc.next();
        }

        for(int i=0; i<t; i++) {
            System.out.print(arr[i].charAt(0));
            System.out.print(arr[i].charAt(arr[i].length()-1));
            System.out.println();
        }
    }
}