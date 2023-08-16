import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String op = sc.next();

            int dir = 0;
            int nowX = 0;
            int nowY = 0;
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;

            for (int j = 0; j < op.length(); j++) {
                char c = op.charAt(j);

                if (c == 'F') {
                    nowX += dx[dir];
                    nowY += dy[dir];
                }
                else if (c == 'B') {
                    nowX -= dx[dir];
                    nowY -= dy[dir];
                }
                else if (c == 'L') {
                    if (dir == 0) {
                        dir = 3;
                    } else {
                        dir--;
                    }
                }
                else if (c == 'R') {
                    if (dir == 3) {
                        dir = 0;
                    } else {
                        dir++;
                    }
                }

                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            System.out.println((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)));
        }
    }
}