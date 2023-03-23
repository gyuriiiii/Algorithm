import java.util.ArrayDeque;

class Solution {
    private static class Node {
        int x, y; 

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    static public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean [][] visited = new boolean[n][m];
        int [][] distance = new int[n][m];
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst(); // 현재 위치한 정점

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];

                // 맵 밖으로 나가는 경우 예외처리
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                // 벽(0)이라서 못 가는 경우
                if (maps[nextX][nextY] == 0) {
                    continue;
                }

                // 아직 방문하지 않은 경우
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true; // 방문 처리
                    queue.addLast(new Node(nextX, nextY)); // 큐에 넣기

                    distance[nextX][nextY] = distance[now.x][now.y] + 1; // 최단거리 update
                }
            }
        }
        return distance[n - 1][m - 1] == 0 ? -1 : distance[n - 1][m - 1] + 1;
    }
}