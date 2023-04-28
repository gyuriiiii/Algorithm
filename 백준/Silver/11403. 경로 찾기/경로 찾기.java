import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        result = new int[N][N];

        HashMap<Integer, ArrayList<Integer>> route = new HashMap<>();
        for (int i = 0; i < N; i++) {
            route.put(i, new ArrayList<>());

            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    ArrayList<Integer> list = route.get(i);
                    list.add(j);
                    route.put(i, list);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean[] visit = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    result[i][j] = 1;

                    if (!visit[j]) {
                        visit[j] = true;
                        dq.add(j);
                    }

                    while (!dq.isEmpty()) {
                        int p = dq.poll();

                        ArrayList<Integer> list = route.get(p);
                        for (int k = 0; k < list.size(); k++) {
                            result[i][list.get(k)] = 1;
                            if (!visit[list.get(k)]) {
                                visit[list.get(k)] = true;
                                dq.add(list.get(k));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}