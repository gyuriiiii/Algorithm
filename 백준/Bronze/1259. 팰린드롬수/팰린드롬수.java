import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String s = "";
            int num = sc.nextInt();
            int n = num;  

            if(num == 0) {
                break;
            }  
            
            while(n>0) {
                s += n%10;
                n/=10;
            }
            
            if(s.equals(Integer.toString(num))) {
                System.out.println("yes");
                continue;
            }
            else {
                System.out.println("no");
                continue;
            }
        }
    }
    
}
