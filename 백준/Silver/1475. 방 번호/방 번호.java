import java.util.Scanner;

public class Main {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);        

        String s = sc.next();
        String[] arr = s.split("");
        int[] number = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            if( n == 6 || n == 9) {
                number[6]++;
                continue;
            }
            number[n]++;
        }

        if(number[6]%2==0) {
            number[6] = number[6]/2;
        }
        else {
            number[6] = number[6]/2+1;
        }

        int max = number[0];
        for (int i = 0; i < number.length; i++) {
            if(number[i] > max) {
                max = number[i];
            }
        }
        System.out.println(max);
    }
}