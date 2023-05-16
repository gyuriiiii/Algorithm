class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Node start;

    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        char[][] map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String s = park[i];
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') { // 시작 위치
                    start = new Node(i, j);
                }
            }
        }

        for (String route : routes) {
            String op = route.split(" ")[0];
            int n = Integer.parseInt(route.split(" ")[1]);

            Node tmp = new Node(start.x, start.y);
            int nx = 0;
            int ny = 0;
            
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (op.equals("N")) {
                    nx = tmp.x + dx[0];
                    ny = tmp.y + dy[0];
                }
                else if (op.equals("S")) {
                    nx = tmp.x + dx[1];
                    ny = tmp.y + dy[1];

                }
                else if (op.equals("W")) {
                    nx = tmp.x + dx[2];
                    ny = tmp.y + dy[2];

                }
                else if (op.equals("E")) {
                    nx = tmp.x + dx[3];
                    ny = tmp.y + dy[3];
                }

                if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 'X') {
                    flag = false;
                    break;
                }

                tmp.x = nx;
                tmp.y = ny;
            }

            if(flag) {
                start = new Node(tmp.x, tmp.y);
            }
        }

        int[] answer = new int[]{start.x, start.y};
        return answer;
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}