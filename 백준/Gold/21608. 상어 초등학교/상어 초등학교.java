import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] table;
    static ArrayList<Integer> order;
    static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        table = new int[N + 1][N + 1]; // 자리배치표

        order = new ArrayList<>(); // 학생 자리배치 순서

        map = new HashMap<>(); // 학생 - 좋아하는 학생

        for (int i = 0; i < N * N; i++) {
            int stu = sc.nextInt();
            order.add(stu);

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                tmp.add(sc.nextInt());
            }
            map.put(stu, tmp);
        }

        for (int i = 0; i < order.size(); i++) {
            int stu = order.get(i);


            if (isEmpty()) { // 교실의 모든 칸이 비어있는 경우
                table[2][2] = stu; // 인접한 칸 중 비어있는 칸이 가장 많은 칸
            }
            else {
                int[] answer = step1(stu);
                table[answer[0]][answer[1]] = stu;
            }
        }

        // 학생 만족도 구하기
        int satisfy = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int likeCnt = 0;
                ArrayList<Integer> like = map.get(table[i][j]);

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // table 벗어남
                    if (nx < 1 || ny < 1 || nx > N || ny > N) {
                        continue;
                    }
                    // 좋아하는 학생이 있는 경우
                    if (like.contains(table[nx][ny])) {
                        likeCnt++;
                    }
                }

                switch (likeCnt) {
                    case 1:
                        satisfy += 1;
                        break;
                    case 2:
                        satisfy += 10;
                        break;
                    case 3:
                        satisfy += 100;
                        break;
                    case 4:
                        satisfy += 1000;
                        break;
                }
            }
        }
        System.out.println(satisfy);
    }

    // 인접한 칸에 좋아하는 학생이 가장 많은 자리
    private static int[] step1(int stu) {
        ArrayList<Integer> like = map.get(stu); // 좋아하는 학생 목록
        ArrayList<int[]> equal = new ArrayList<>(); // 1번 만족하는 칸

        int max = Integer.MIN_VALUE;
        int[] answer = new int[2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (table[i][j] == 0) { // 비어있는 칸
                    int likeCnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // table 벗어남
                        if (nx < 1 || ny < 1 || nx > N || ny > N) {
                            continue;
                        }
                        // 좋아하는 학생이 있는 경우
                        if (like.contains(table[nx][ny])) {
                            likeCnt++;
                        }

                    }
                    if (max < likeCnt) {
                        equal.clear();
                        equal.add(new int[]{i, j});

                        max = likeCnt;
                    }
                    // 좋아하는 학생이 인접한 칸이 같은 경우
                    // 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리 정하기
                    else if (max == likeCnt) {
                        equal.add(new int[]{i, j});
                    }
                }
            }
        }

        // 1번 만족하는 칸이 한 개인 경우
        if (equal.size() == 1) {
            answer[0] = equal.get(0)[0];
            answer[1] = equal.get(0)[1];
        }
        // 여러 개인 경우
        else {
            answer = step2(equal);
        }

        return answer;
    }

    // 인접한 칸 중 비어있는 칸이 가장 많은 칸
    private static int[] step2(ArrayList<int[]> equal) {
        int[] answer = new int[2];
        int result = Integer.MIN_VALUE; // 비어있는 칸의 개수

        for (int i = 0; i < equal.size(); i++) {
            int sum = 0;
            int[] e = equal.get(i);

            for (int k = 0; k < 4; k++) {
                int nx = e[0] + dx[k];
                int ny = e[1] + dy[k];

                // table 벗어남
                if (nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }

                // 비어있는 칸
                if (table[nx][ny] == 0) {
                    sum++;
                }
            }

            if (result < sum) {
                result = sum;

                answer[0] = e[0];
                answer[1] = e[1];
            }
        }
        return answer;
    }

    // 현재 교실의 모든 칸이 비어있는 지 체크
    private static boolean isEmpty() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 교실의 모든 칸이 비어있지 않은 경우
                if (table[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}