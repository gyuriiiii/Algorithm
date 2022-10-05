import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] arr = new boolean[10]; 

        int N = sc.nextInt(); // 이동하려는 채널
        int M = sc.nextInt(); // 고장난 버튼 개수

        if (M != 0) {
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                arr[x] = true; // 고장난 버튼 true로 저장
            }
        }

        int result = Math.abs(100 - N); // +와- 버튼으로만 움직인 경우 저장
        for (int i = 0; i <= 999999; i++) {
            String s = Integer.toString(i);

            boolean check = true;

            // 고장난 버튼 때문에 못 누르면 스킵
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (arr[c - '0']) { // 고장 났으면 빠져나오기
                    check = false; 
                    break;
                }
            }

            if(check) { // 고장나지 않은 경우
                int min = s.length() + Math.abs(i-N); 
                result = Math.min(min, result); // +-로만 이동하는 것과 비교
            }
        }
        System.out.println(result);
    }
}