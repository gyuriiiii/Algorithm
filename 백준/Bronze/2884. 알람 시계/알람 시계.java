import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int hour = h;
        int min = 0;

        if(m-45 < 0) {
            --hour;
            min = m + 60 - 45;
            if(hour<0) {
                hour += 24;
            }
        }
        else {
            min = m - 45;
        }
        System.out.print(hour + " " + min);
    }
}
