import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            ArrayList<Grade> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int document = sc.nextInt();
                int interview = sc.nextInt();

                list.add(new Grade(document, interview));
            }

            list.sort(((o1, o2) -> Integer.compare(o1.document, o2.document)));

            int cnt = 1;
            int min = list.get(0).interview;

            for (int j = 1; j < N; j++) {
                if (list.get(j).interview < min) {
                    cnt++;
                    min = list.get(j).interview;
                }
            }

            System.out.println(cnt);
        }
    }

    static public class Grade {
        int document;
        int interview;

        public Grade(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}