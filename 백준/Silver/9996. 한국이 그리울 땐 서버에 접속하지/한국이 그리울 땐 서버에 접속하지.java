import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 파일 개수
        String pattern = sc.next(); // 패턴

        int starIdx = pattern.indexOf("*");
        String front = pattern.substring(0, starIdx);
        String end = pattern.substring(starIdx + 1, pattern.length());

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            String file = sc.next();

            if (file.length() >= pattern.length() - 1) {
                String fileFront = file.substring(0, starIdx);
                String fileEnd = file.substring(file.length() - end.length(), file.length());

                if (fileFront.equals(front) && fileEnd.equals(end)) {
                    flag = true;
                }
            }

            if(flag) {
                sb.append("DA").append("\n");
            }
            else {
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb);
    }
}