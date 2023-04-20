import java.util.Scanner;

public class Main {
    static int N;
    static Consultant[] consultants;
    static boolean[] visited;

    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        consultants = new Consultant[N + 1];
        for (int i = 1; i <= N; i++) {
            consultants[i] = new Consultant(0, 0, 0);
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            consultants[i].time = sc.nextInt();
            consultants[i].money = sc.nextInt();

            consultants[i].end = i + consultants[i].time; // 상담 종료 시간
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && consultants[i].end <= N + 1) {
                visited[i] = true;
                sum = consultants[i].money;
                dfs(i);
            }
        }
        System.out.println(max);
    }

    private static void dfs(int day) {
        int end = consultants[day].end;

        for (int i = end; i <= N; i++) {
            if (!visited[i] && consultants[i].end <= N + 1) {
                visited[i] = true;
                sum += consultants[i].money;
                dfs(i);

                visited[i] = false;
                sum -= consultants[i].money;
            }
        }

        max = Math.max(max, sum);
        return;
    }

    public static class Consultant {
        int time;
        int money;
        int end;

        public Consultant(int time, int money, int end) {
            this.time = time;
            this.money = money;
            this.end = end;
        }
    }
}