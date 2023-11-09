import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); // 스위치 수

        arr = new int[s + 1];
        for (int i = 1; i <= s; i++) {
            arr[i] = sc.nextInt();
        }

        int stu = sc.nextInt(); // 학생 수
        for (int i = 0; i < stu; i++) {
            int gender = sc.nextInt(); // 성별
            int num = sc.nextInt(); // 학생이 받은 수

            if (gender == 1) {
                mode1(num);
            }
            else if (gender == 2) {
                mode2(num);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void mode2(int num) {
        int left = num - 1;
        int right = num + 1;

        while (left >= 1 && right <= arr.length-1) {
            if (arr[left] == arr[right]) {
                left--;
                right++;
            }
            else {
                break;
            }
        }
        left++;
        right--;

        for (int i = left; i <= right; i++) {
            change(i);
        }
    }

    private static void mode1(int num) {
        for (int i = 1; i < arr.length; i++) {
            if(i % num == 0) {
                change(i);
            }
        }
    }

    private static void change(int idx) {
        if (arr[idx] == 1) {
            arr[idx] = 0;
        }
        else {
            arr[idx] = 1;
        }
    }
}