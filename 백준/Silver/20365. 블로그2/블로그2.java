import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();
        char[] color = new char[n];

        int redNum = 0;
        int blueNum = 0;
        
        char current = s.charAt(0);

        if (current == 'B') blueNum++;
        else redNum++;

        for (int i = 0; i < n; i++) {
            color[i] = s.charAt(i);

            if (color[i] == 'R') {
                if (current == 'B') {
                    redNum++;
                }
                current = 'R';
            }
            else {
                if (current == 'R') {
                    blueNum++;
                }
                current = 'B';
            }
        }

        int answer = Math.min(redNum, blueNum) + 1;
        System.out.println(answer);
    }
}