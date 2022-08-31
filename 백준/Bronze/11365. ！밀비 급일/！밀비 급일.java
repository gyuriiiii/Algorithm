import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();

            if(s.equals("END")) {
                break;
            }

            String[] arr = s.split("");

            StringBuilder sb = new StringBuilder();
            for(int i=arr.length-1; i>=0; i--) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }
}