import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 격자 크기
        M = sc.nextInt(); // 색상 개수

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            ArrayList<ArrayList<Block>> groupList = new ArrayList<>(); // 블록 그룹 후보
            int maxSize = Integer.MIN_VALUE;

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= 0) {
                        continue;
                    }

                    if (!visited[i][j]) {
                        ArrayList<Block> block = bfs(i, j);
                        int size = block.size();

                        if (size < 2) {
                            continue;
                        }

                        if (size > maxSize) {
                            maxSize = size;
                            groupList.clear();
                            groupList.add(block);
                        }
                        else if (size == maxSize) {
                            groupList.add(block);
                        }

                        backRainbow();
                    }
                }
            }

            ArrayList<Block> blockGroup = new ArrayList<>(); // 최종 블록 그룹

            if (groupList.size() == 0) {
                break;
            } 
            else if (groupList.size() == 1) {
                blockGroup = groupList.get(0);
            }

            // 블록 그룹 여러 개인 경우 => 하나 정해주기
            else {
                int maxRainbow = Integer.MIN_VALUE;
                int maxStandardX = Integer.MIN_VALUE; // 기준 블록의 행
                int maxStandardY = Integer.MIN_VALUE; // 기준 블록의 열

                for (ArrayList<Block> group : groupList) {
                    int standardX = Integer.MAX_VALUE;
                    int standardY = Integer.MAX_VALUE;

                    int rainbow = 0;
                    for (Block block : group) {
                        if (map[block.x][block.y] == 0) {
                            rainbow++;
                        }
                        // 일반 블록인 경우
                        else {
                            if (standardX > block.x) {
                                standardX = block.x;
                                standardY = block.y;
                            }
                            else if (standardX == block.x) {
                                standardY = Math.min(standardY, block.y);
                            }
                        }
                    }

                    if (maxRainbow < rainbow) {
                        maxRainbow = rainbow;
                        maxStandardX = standardX;
                        maxStandardY = standardY;

                        blockGroup.clear();
                        blockGroup = group;
                    }

                    // 무지개 블록 개수가 같은 경우
                    else if (maxRainbow == rainbow) {
                        // 기준 블록 행이 가장 큰 것으로 기준 블록
                        if (standardX > maxStandardX) {
                            maxStandardX = standardX;
                            maxStandardY = standardY;
                            blockGroup.clear();
                            blockGroup = group;
                        }
                        // 기준 블록 행이 같은 경우 => 기준 블록의 열이 가장 큰 것으로
                        else if (standardX == maxStandardX) {
                            if (standardY > maxStandardY) {
                                maxStandardX = standardX;
                                maxStandardY = standardY;
                                blockGroup.clear();
                                blockGroup = group;
                            }
                        }
                    }

                }

            }

            removeBlock(blockGroup);
            gravity();
            rotate();
            gravity();
        }

        System.out.println(answer);
    }

    private static void backRainbow() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void rotate() {
        int count = N / 2; // 회전할 라인의 개수
        int rotateNum = N - 1;

        for (int j = 0; j < count; j++) {
            for (int i = 0; i < rotateNum; i++) {
                int tmp = map[j][j];

                // 왼
                for (int k = j; k < N - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }

                // 위
                for (int k = j; k < N - j - 1; k++) {
                    map[k][N - j - 1] = map[k + 1][N - j - 1];
                }

                // 오
                for (int k = N - j - 1; k > j; k--) {
                    map[N - j - 1][k] = map[N - j - 1][k - 1];
                }

                // 아래
                for (int k = N - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }

                map[j + 1][j] = tmp;
            }
            rotateNum -= 2;
        }
    }

    private static void gravity() {
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                // 검은 블록이나 빈칸은 중력에 영향받지 X
                if (map[i][j] == -1 || map[i][j] == -2) {
                    continue;
                }

                int idx = i;

                for (int k = idx + 1; k < N; k++) {
                    if (map[k][j] != -2) {
                        idx = k - 1;
                        break;
                    } else if (map[k][j] == -2 && k == N - 1) {
                        idx = k;
                        break;
                    }
                }

                if (idx == i) {
                    continue;
                }
                map[idx][j] = map[i][j];
                map[i][j] = -2;
            }
        }
    }

    // 블록 그룹에 있는 모든 블록 제거
    private static void removeBlock(ArrayList<Block> blockGroup) {
        answer += Math.pow(blockGroup.size(), 2);

        for (Block block : blockGroup) {
            map[block.x][block.y] = -2;
        }
    }

    // 블록 그룹 구하기
    private static ArrayList<Block> bfs(int i, int j) {
        ArrayList<Block> block = new ArrayList<>();
        ArrayDeque<Block> dq = new ArrayDeque<>();

        block.add(new Block(i, j));
        dq.add(new Block(i, j));
        visited[i][j] = true;

        while (!dq.isEmpty()) {
            Block now = dq.poll();

            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                // map 벗어남
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                // 검은 블록, 빈 칸, 이미 방문한 칸 => 제외
                if (map[nx][ny] == -1 || map[nx][ny] == -2 || visited[nx][ny]) {
                    continue;
                }

                // 무지개 블록인 경우, 색 같은 일반 블록인 경우
                if (map[nx][ny] == map[i][j] || map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    dq.add(new Block(nx, ny));
                    block.add(new Block(nx, ny));
                }
            }
        }

        return block;
    }

    private static class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}