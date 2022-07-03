import java.util.Scanner;

public class 열개씩끊어출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0; 
        
        String s = sc.next();
        String[] arr = s.split("");

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            num++;

            if(num>0 && num%10==0) {
                System.out.println();
            }
        }
    }
}
