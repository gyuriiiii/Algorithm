import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 카드 개수
        int m = sc.nextInt(); // 딜러가 외친 숫자

        int[] card = new int[n];
        for (int i = 0; i < card.length; i++) {
            card[i] = sc.nextInt();
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                for (int k = j+1; k < n; k++) {
                    int max = card[i] + card[j] + card[k];

                    if(max > result && max <= m) {
                        result = max;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
 