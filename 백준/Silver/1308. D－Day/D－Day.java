import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 오늘 날짜
        int todayYear = sc.nextInt();
        int todayMonth = sc.nextInt();
        int todayDay = sc.nextInt();

        // D-Day 날짜 (캠프 끝나는 날짜)
        int ddayYear = sc.nextInt();
        int ddayMonth = sc.nextInt();
        int ddayDay = sc.nextInt();

        // 캠프가 1000년 이상 지속된다면 gg 출력
        if (todayYear + 1000 < ddayYear ||
                todayYear + 1000 == ddayYear && todayMonth < ddayMonth ||
                todayYear + 1000 == ddayYear && todayMonth == ddayMonth && todayDay <= ddayDay) {
            System.out.println("gg");
        }

        else {
            int today = addDay(todayYear, todayMonth, todayDay);
            int dday = addDay(ddayYear, ddayMonth, ddayDay);

            int x = dday - today;
            System.out.println("D-" + x);
        }
    }

    // 1년 1월 1일 부터 year년 month년 day일 까지 총 며칠인지 계산
    private static int addDay(int year, int month, int day) {
        int result = 0;
        int[] dayArr;

        for (int i = 1; i < year; i++) {
            dayArr = checkYear(i); // 년도 check

            for (int j = 0; j < 12; j++) {
                result += dayArr[j]; // 년도에 따른 달의 일수 더해주기
            }
        }

        dayArr = checkYear(year); // 해당 년도는 따로 계산
        for (int i = 0; i < month - 1; i++) {
            result += dayArr[i];
        }
        result += day;

        return result;
    }

    private static int[] checkYear(int year) {
        int[] dayArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 윤년의 경우
        // 2월달이 29일까지 있음
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            dayArr[1] = 29;
        }
        return dayArr;
    }
}