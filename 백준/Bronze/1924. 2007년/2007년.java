import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] answer = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] dayArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int x = sc.nextInt();
        int y = sc.nextInt();

        int day = y;
        for (int i = 1; i <= x - 1; i++) {
            day += dayArr[i];
        }

        System.out.println(answer[day % 7]);
    }
}