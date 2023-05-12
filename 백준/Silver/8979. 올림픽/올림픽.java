import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.gold == o2.gold && o1.silver == o2.silver) {
                    return Integer.compare(o2.bronze, o1.bronze);
                }
                else if (o1.gold == o2.gold) {
                    return Integer.compare(o2.silver, o1.silver);
                }
                else {
                    return Integer.compare(o2.gold, o1.gold);
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).num == K) {
                System.out.println(i);
                break;
            }
        }
    }

    static public class Node {
        int num;
        int gold;
        int silver;
        int bronze;

        public Node(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}