import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int V = sc.nextInt();
            list.add(new Node(M, V));
        }
        Collections.sort(list, ((o1, o2) -> Integer.compare(o1.weight, o2.weight)));

        for (int i = 0; i < K; i++) {
            int C = sc.nextInt();
            bags.add(C);
        }
        Collections.sort(bags);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.cost, o1.cost)));
        
        long sum = 0;
        int idx = 0;

        for (int bag : bags) {
            while (idx < N && list.get(idx).weight <= bag) {
                pq.add(new Node(list.get(idx).weight, list.get(idx).cost));
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll().cost;
            }
        }

        System.out.println(sum);
    }

    static private class Node {
        int weight;
        int cost;

        public Node(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }
}