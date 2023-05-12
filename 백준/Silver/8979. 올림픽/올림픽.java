import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();

            list.add(new Node(num, gold, silver, bronze, 0));
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

        list.get(0).rank = 1; // 1등

        for (int i = 1; i < list.size(); i++) {
            int tmp_g = list.get(i - 1).gold;
            int tmp_s = list.get(i - 1).silver;
            int tmp_b = list.get(i - 1).bronze;

            Node now = list.get(i);
            if (now.gold == tmp_g && now.silver == tmp_s && now.bronze == tmp_b) { // 동점
                list.get(i).rank = list.get(i - 1).rank;
            }

            else {
                list.get(i).rank = i + 1;
            }

            if(now.num == K) {
                System.out.println(now.rank);
                break;
            }
        }
    }

    static public class Node {
        int num;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Node(int num, int gold, int silver, int bronze, int sum) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = sum;
        }
    }
}