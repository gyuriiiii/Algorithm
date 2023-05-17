import java.util.*;

public class Main {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];

        ArrayDeque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) { // 상어
                    dq.add(new Node(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        int size = 2; // 아기 상어 크기
        int eat = 0; // 먹은 물고기 개수
        int result = 0; // 소요 시간

        while (true) {
            ArrayList<Node> eatFish = new ArrayList<>();
            int[][] cnt = new int[N][N];

            while (!dq.isEmpty()) {
                Node now = dq.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    // 현재 상어의 크기보다 작거나 같은 경우 => 이동 가능
                    if (cnt[nx][ny] == 0 && map[nx][ny] <= size) {
                        cnt[nx][ny] = cnt[now.x][now.y] + 1;
                        dq.add(new Node(nx, ny, cnt[nx][ny]));

                        // 상어 크기보다 작은 경우 => 먹기 가능
                        if (map[nx][ny] > 0 && map[nx][ny] < size) {
                            eatFish.add(new Node(nx, ny, cnt[nx][ny]));
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기 없는 경우 => 종료
            if (eatFish.isEmpty()) {
                System.out.println(result);
                return;
            }

            Collections.sort(eatFish, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.dis == o2.dis) { // 거리 같으면
                        // 가장 위에 있는 물고기 여러마리면
                        if (o1.x == o2.x) {
                            // 가장 왼쪽에 있는 물고기
                            return Integer.compare(o1.y, o2.y);
                        }
                        return Integer.compare(o1.x, o2.x);
                    }
                    return Integer.compare(o1.dis, o2.dis);
                }
            });

            // 가장 가까운 물고기
            Node nowFish = eatFish.get(0);

            eat++;
            map[nowFish.x][nowFish.y] = 0;
            result += nowFish.dis;
            dq.add(nowFish);

            if (eat == size) { // 상어 크기만큼 물고기 먹은 경우 => 아기상어 크기 + 1
                size++;
                eat = 0;
            }
        }
    }

    static public class Node {
        int x;
        int y;
        int dis; 

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}