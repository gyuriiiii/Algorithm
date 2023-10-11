import java.util.*;

public class Main {
    static int[][] arr;
    static int xLen, yLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[101][101];

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        xLen = 3; // 행의 크기
        yLen = 3; // 열의 크기

        int answer = -1;

        for (int i = 0; i <= 100; i++) {
            if (arr[r][c] == k) {
                answer = i;
                break;
            }
            operating();
        }

        System.out.println(answer);
    }

    private static void operating() {
        // 모든 행에 대해 정렬
        if (xLen >= yLen) {
            for (int i = 1; i <= xLen; i++) {
                r(i);
            }
        }
        // 모든 열에 대해 정렬
        else {
            for (int i = 1; i <= yLen; i++) {
                c(i);
            }
        }
    }

    private static void r(int idx) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= yLen; i++) {
            int num = arr[idx][i];

            if (num == 0) {
                continue;
            }

            if (map.containsKey(num)) {
                int cnt = map.get(num);
                map.put(num, cnt + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        int i = 1;

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            arr[idx][i++] = p.num;
            arr[idx][i++] = p.cnt;
        }

        yLen = Math.max(yLen, i);

        while (i < 101) {
            arr[idx][i++] = 0;
            arr[idx][i++] = 0;
        }
    }

    private static void c(int idx) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= xLen; i++) {
            int num = arr[i][idx];

            if (num == 0) {
                continue;
            }

            if (map.containsKey(num)) {
                int cnt = map.get(num);
                map.put(num, cnt + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        int i = 1;

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            arr[i++][idx] = p.num;
            arr[i++][idx] = p.cnt;
        }

        xLen = Math.max(xLen, i);

        while (i < 101) {
            arr[i++][idx] = 0;
            arr[i++][idx] = 0;
        }
    }

    private static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            // 횟수 같은 경우 => 숫자 오름차순
            if (this.cnt == o.cnt) {
                return Integer.compare(this.num, o.num);
            }
            // 횟수 다른 경우 => 횟수 오름차순
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}