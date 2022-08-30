import java.util.Scanner;

public class 방번호 {
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

        int max = number[0];
        for (int i = 0; i < number.length; i++) {
            if(number[i] > max) max = number[i];
        }
        
        int result = 0; 
        for (int i = 0; i < number.length; i++) {
            if(number[6] <= max) {
                result = max;
                break;
            }
            else {
                if(number[6]%2==0) {
                    result = number[6]/2;
                }
                else {
                    result = number[6]/2+1;
                }
            }
        }
        System.out.println(result);
    }
}
