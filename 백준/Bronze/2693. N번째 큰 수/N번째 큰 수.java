import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                arr.add(sc.nextInt());
            }
            Collections.sort(arr, Collections.reverseOrder());
            System.out.println(arr.get(2));
        }
    }
}