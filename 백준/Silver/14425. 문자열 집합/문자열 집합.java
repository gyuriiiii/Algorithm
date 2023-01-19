import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String word = sc.next();

            if(list.contains(word)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}