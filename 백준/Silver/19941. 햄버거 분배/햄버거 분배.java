import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> person = new ArrayList<>();
        ArrayList<Integer> hamburger = new ArrayList<>();

        String s = sc.next();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'H') {
                hamburger.add(i + 1);
            }
            else {
                person.add(i + 1);
            }
        }

        int answer = 0;
        int idx = 0;
        boolean[] eat = new boolean[hamburger.size()];

        for (int p : person) {
            for (int i = idx; i < hamburger.size(); i++) {
                if (Math.abs(p - hamburger.get(i)) <= k) {
                    if (!eat[i]) {
                        eat[i] = true;
                        answer++;
                        idx = i + 1;
                        break;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}