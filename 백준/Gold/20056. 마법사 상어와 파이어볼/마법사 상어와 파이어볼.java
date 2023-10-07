import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static ArrayList<Fire> map[][];
    static ArrayList<Fire> fireList = new ArrayList<>(); 

    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt(); // 위치
            int c = sc.nextInt(); // 위치
            int m = sc.nextInt(); // 질량
            int s = sc.nextInt(); // 속력
            int d = sc.nextInt(); // 방향

            map[r][c].add(new Fire(r, c, m, s, d)); 
            fireList.add(new Fire(r, c, m, s, d)); 
        }

        for (int i = 0; i < K; i++) {
            // 이동
            move();

            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (map[j][k].size() >= 2) {
                        divide(j, k);
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < fireList.size(); i++) {
            answer += fireList.get(i).m;
        }

        System.out.println(answer);
    }

    private static void divide(int r, int c) {
        ArrayList<Fire> fires = map[r][c];
        int size = fires.size();

        int totalM = 0;
        int totalS = 0;

        boolean allEven = true; // 방향이 모두 짝수인지
        boolean allOdd = true; // 방향이 모두 홀수인지

        for (int i = 0; i < size; i++) {
            totalM += fires.get(i).m;
            totalS += fires.get(i).s;

            // 짝수인 경우
            if (fires.get(i).d % 2 == 0) {
                allOdd = false;
            }
            // 홀수인 경우
            else {
                allEven = false;
            }
        }

        map[r][c].clear();

        int listSize = fireList.size();
        for (int i = listSize - 1; i >= 0; i--) {
            if (fireList.get(i).x == r && fireList.get(i).y == c) {
                fireList.remove(i);
            }
        }

        if (totalM / 5 == 0) {
            return;
        }

        if ((allEven && !allOdd) || (!allEven && allOdd)) {
            for (int i = 0; i <= 6; i += 2) {
                fireList.add(new Fire(r, c, totalM / 5, totalS / size, i));
                map[r][c].add(new Fire(r, c, totalM / 5, totalS / size, i));
            }
        }
        else {
            for (int i = 1; i <= 7; i += 2) {
                fireList.add(new Fire(r, c, totalM / 5, totalS / size, i));
                map[r][c].add(new Fire(r, c, totalM / 5, totalS / size, i));
            }
        }
    }

    private static void move() {
        int size = fireList.size();

        for (int i = size - 1; i >= 0; i--) {
            Fire now = fireList.remove(i); // 해당 파이어볼 제거

            ArrayList<Fire> removeBall = map[now.x][now.y];
            for (int j = 0; j < removeBall.size(); j++) {
                if (removeBall.get(j).m == now.m && removeBall.get(j).s == now.s && removeBall.get(j).d == now.d) {
                    removeBall.remove(j);
                    break;
                }
            }

            int nx = now.x;
            int ny = now.y;

            for (int j = 0; j < now.s; j++) {
                nx += dx[now.d];
                ny += dy[now.d];

                if (nx == 0) nx = N;
                else if (nx == N + 1) nx = 1;

                if (ny == 0) ny = N;
                else if (ny == N + 1) ny = 1;
            }

            fireList.add(new Fire(nx, ny, now.m, now.s, now.d)); 
            map[nx][ny].add(new Fire(nx, ny, now.m, now.s, now.d)); 
        }
    }

    static private class Fire {
        int x;
        int y;
        int m;
        int s;
        int d;

        public Fire(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}