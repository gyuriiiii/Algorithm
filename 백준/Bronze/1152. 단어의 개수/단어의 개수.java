import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr = s.split(" "); 

        int num = 0;
        for (String i : arr) {
            if(i != "") {
                num++;
            }
        }
        System.out.println(num);
    }
    
}
