import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = Integer.MAX_VALUE;

        // 뺄셈 기준으로 분리
        String [] arr = sc.nextLine().split("-");
        
        for(int i=0; i<arr.length; i++) {
            int temp = 0; // 더해준 값

            // 덧셈으로 분리 후 더해주기
            String[] plus = arr[i].split("\\+");
            for(int j=0; j<plus.length; j++) {
                temp += Integer.parseInt(plus[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            }
            else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}