import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Score> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Score(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if (o1.korean == o2.korean && o1.math == o2.math && o1.english == o2.english) {
                    return o1.name.compareTo(o2.name);
                }
                else if (o1.korean == o2.korean && o1.english == o2.english) {
                    return Integer.compare(o2.math, o1.math);
                }
                else if (o1.korean == o2.korean) {
                    return Integer.compare(o1.english, o2.english);
                }
                else {
                    return Integer.compare(o2.korean, o1.korean);
                }
            }
        });

        for (Score score : list) {
            System.out.println(score.name);
        }
    }

    static public class Score {
        String name;
        int korean;
        int english;
        int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
