import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] visit = new int[N];
        for (int i = 0; i < N; i++) {
            visit[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visit[i];
        }
        map.put(sum, 1);

        int max = sum;

        int left = 0;
        int right = X;

        while (right < N) {
            sum -= visit[left];
            sum += visit[right];

            if (sum >= max) {
                max = sum;

                if (map.containsKey(max)) {
                    int cnt = map.get(max);
                    map.put(max, cnt + 1);
                }
                else {
                    map.put(max, 1);
                }
            }
            left++;
            right++;
        }

        if(max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(map.get(max));
        }
    }
}