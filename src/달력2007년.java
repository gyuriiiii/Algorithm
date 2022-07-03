import java.util.Scanner;

public class 달력2007년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 월
        int y = sc.nextInt(); // 일
        sc.close();

        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] weeks = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

        int totalDays = y; // 총 일수
        for(int i=0; i<x-1; i++) {
            totalDays += days[i]; 
        }
        System.out.println(weeks[totalDays%7]);
    }
}
