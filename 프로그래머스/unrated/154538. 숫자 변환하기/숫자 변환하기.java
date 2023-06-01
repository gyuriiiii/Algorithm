import java.util.ArrayDeque;

class Solution {
    static int[] cnt;
    static int answer = -1;

    public int solution(int x, int y, int n) {
        cnt = new int[y + 1];
        for (int i = 0; i < y + 1; i++) {
            cnt[i] = Integer.MAX_VALUE;
        }

        bfs(x, y, n);
        return answer;
    }

    private static void bfs(int x, int y, int n) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(x);
        cnt[x] = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == y) {
                answer = cnt[now];
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx = 0;

                if (i == 0) {
                    nx = now + n;
                }
                else if (i == 1) {
                    nx = now * 2;
                }
                else {
                    nx = now * 3;
                }

                if (nx <= y && cnt[nx] > cnt[now] + 1) {
                    cnt[nx] = cnt[now] + 1;
                    dq.add(nx);
                }
            }
        }
    }
}