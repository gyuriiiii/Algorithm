import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(); // 입력받을 숫자 개수
        
        String s = sc.next();
        String[] arr = s.split("");

        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += Integer.parseInt(arr[i]);
        }
        System.out.println(answer);
    }
}
