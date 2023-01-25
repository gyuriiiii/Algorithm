import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        ArrayList<Integer> list = new ArrayList<>();

        boolean flag = false; // 0 포함하는 지 확인
        int cnt = 0; // 0의 개수
        int sum = 0; // 각 자리 수의 합
        for (int i = 0; i < N.length(); i++) {
            int num = Integer.parseInt(N.charAt(i) + "");

            if (num == 0) {
                flag = true;
                cnt++;
            } 
            else {
                list.add(num);
                sum += num;
            }
        }
        Collections.sort(list);

        String answer = "";

        // 0을 포함하지 않거나 각 자리수의 합이 3이 아닌 경우
        if (!flag || sum % 3 != 0) {
            System.out.println(-1);
        } 
        else {
            for (int i = list.size() - 1; i >= 0; i--) {
                answer = answer + list.get(i);
            }

            for (int i = 0; i < cnt; i++) {
                answer = answer + 0;
            }
        }
        System.out.println(answer);
    }
}