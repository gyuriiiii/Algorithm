import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int A, B, N, M;
    static int[][] map;
    static HashMap<Integer, int[]> robots = new HashMap<>(); // 로봇 위치
    static HashMap<Integer, String> directions = new HashMap<>(); // 로봇 방향

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int[] location;
    static String direction;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        map = new int[B + 1][A + 1];

        N = sc.nextInt();
        M = sc.nextInt();

        // 로봇의 초기 위치 (x, y) 및 방향
        for (int i = N; i >= 1; i--) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String direction = sc.next();

            map[y][x] = N - i + 1;

            robots.put(N - i + 1, new int[]{y, x});
            directions.put(N - i + 1, direction);
        }

        // 로봇에 내릴 명령
        for (int j = 1; j <= M; j++) {
            sb = new StringBuilder();

            int robot = sc.nextInt(); // 로봇 번호
            String op = sc.next(); // 명령
            int re = sc.nextInt(); // 반복 횟수

            if (!simulate(robot, op, re)) {
                System.out.println(sb);
                return;
            }
        }
        System.out.println("OK");
    }

    private static boolean simulate(int robot, String op, int re) {
        for (int i = 0; i < re; i++) {
            location = robots.get(robot); // 로봇 위치
            direction = directions.get(robot); // 로봇 방향

            switch (direction) {
                case "N":
                    switch (op) {
                        case "L":
                            direction = "W";
                            directions.put(robot, direction);
                            break;
                        case "R":
                            direction = "E";
                            directions.put(robot, direction);
                            break;
                        case "F":
                            if (!movingForward(robot, location, direction)) {
                                return false;
                            }
                            break;
                    }
                    break;

                case "W":
                    switch (op) {
                        case "L":
                            direction = "S";
                            directions.put(robot, direction);
                            break;
                        case "R":
                            direction = "N";
                            directions.put(robot, direction);
                            break;
                        case "F":
                            if (!movingForward(robot, location, direction)) {
                                return false;
                            }
                            break;
                    }
                    break;

                case "S":
                    switch (op) {
                        case "L":
                            direction = "E";
                            directions.put(robot, direction);
                            break;
                        case "R":
                            direction = "W";
                            directions.put(robot, direction);
                            break;
                        case "F":
                            if (!movingForward(robot, location, direction)) {
                                return false;
                            }
                            break;
                    }
                    break;

                case "E":
                    switch (op) {
                        case "L":
                            direction = "N";
                            directions.put(robot, direction);
                            break;
                        case "R":
                            direction = "S";
                            directions.put(robot, direction);
                            break;
                        case "F":
                            if (!movingForward(robot, location, direction)) {
                                return false;
                            }
                            break;
                    }
                    break;

            }
        }
        return true;
    }

    private static boolean movingForward(int robot, int[] location, String direction) {
        int nextx = 0;
        int nexty = 0;

        switch (direction) {
            case "N": // 상
                nextx = location[0] + dx[0];
                nexty = location[1] + dy[0];
                break;
            case "W": // 좌
                nextx = location[0] + dx[2];
                nexty = location[1] + dy[2];
                break;
            case "S": // 하
                nextx = location[0] + dx[1];
                nexty = location[1] + dy[1];
                break;
            case "E": // 우
                nextx = location[0] + dx[3];
                nexty = location[1] + dy[3];
                break;
        }

        // 벽에 충돌한 경우 (땅 밖으로 벗어남)
        if (nextx < 1 || nexty < 1 || nextx > B || nexty > A) {
            sb.append("Robot " + robot + " crashes into the wall").append("\n");
            return false;
        }

        // 다른 로봇과 충돌한 경우
        if (map[nextx][nexty] != 0) {
            sb.append("Robot " + robot + " crashes into robot " + map[nextx][nexty]).append("\n");
            return false;
        }

        // 로봇 위치 업데이트
        map[location[0]][location[1]] = 0;
        map[nextx][nexty] = robot;
        robots.put(robot, new int[]{nextx, nexty});

        return true;
    }
}