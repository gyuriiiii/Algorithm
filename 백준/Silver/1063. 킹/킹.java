import java.util.Scanner;

public class Main {
    static int kingx, kingy;
    static int stonex, stoney;

    static int mx, my;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String k = sc.next();
        String s = sc.next();

        kingx = k.charAt(1) - '0';
        kingy = k.charAt(0) - 'A' + 1;
        stonex = s.charAt(1) - '0';
        stoney = s.charAt(0) - 'A' + 1;

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String op = sc.next();

            switch (op) {
                case "R":
                    mx = 0;
                    my = 1;
                    break;
                case "L":
                    mx = 0;
                    my = -1;
                    break;
                case "B":
                    mx = -1;
                    my = 0;
                    break;
                case "T":
                    mx = 1;
                    my = 0;
                    break;
                case "RT":
                    mx = 1;
                    my = 1;
                    break;
                case "LT":
                    mx = 1;
                    my = -1;
                    break;
                case "RB":
                    mx = -1;
                    my = 1;
                    break;
                case "LB":
                    mx = -1;
                    my = -1;
                    break;
            }
            move(mx, my);
        }

        System.out.println((char) (kingy + 'A' - 1) + "" + kingx + "\n" + (char) (stoney + 'A' - 1) + "" + stonex);
    }

    static public void move(int mx, int my) {
        int nx = kingx + mx;
        int ny = kingy + my;

        if (checkRange(nx, ny)) {
            if (nx == stonex && ny == stoney) {
                if (checkRange(stonex + mx, stoney + my)) {
                    stonex += mx;
                    stoney += my;
                    kingx = nx;
                    kingy = ny;
                }
            } 
            else {
                kingx = nx;
                kingy = ny;
            }
        }
    }

    static public boolean checkRange(int nx, int ny) {
        if (nx < 1 || ny < 1 || nx > 8 || ny > 8)
            return false;
        return true;
    }
}