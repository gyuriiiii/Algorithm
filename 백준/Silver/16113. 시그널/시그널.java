import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String s = sc.next();

        map = new char[5][N / 5];

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N / 5; j++) {
                map[i][j] = s.charAt(idx++);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N / 5; i++) {
            // ###인 경우 => 0, 2, 3, 5, 6, 7, 8, 9 중 하나
            if (map[0][i] == '#') {
                if (i + 2 <= N / 5) {
                    if (map[0][i + 1] == '#' && map[0][i + 2] == '#') {
                        list.add(checkNum(i));

                        i += 3;
                        if (i >= N / 5) {
                            break;
                        }
                        continue;
                    }
                }

                if (map[3][i] == '#') {
                    list.add(1);
                }
                else {
                    list.add(4);

                    i += 3;
                    if (i >= N / 5) {
                        break;
                    }
                }
            }
        }

        for (int l : list) {
            System.out.print(l);
        }
    }

    private static int checkNum(int idx) {
        String[] num = new String[10];
        String s = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                s += map[i][j + idx];
            }
        }

        num[0] = "####.##.##.####";
        num[2] = "###..#####..###";
        num[3] = "###..####..####";
        num[5] = "####..###..####";
        num[6] = "####..####.####";
        num[7] = "###..#..#..#..#";
        num[8] = "####.#####.####";
        num[9] = "####.####..####";

        int result = 10;
        for (int i = 0; i < 10; i++) {
            if (s.equals(num[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
}