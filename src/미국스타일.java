import java.util.Scanner;

public class 미국스타일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            double num = sc.nextDouble();
            String unit = sc.next();

            double result = 0;

            // 킬로그램(kg) <-> 파운드(lb)
            // 갤런(g) <-> 리터(l)
            switch (unit) {
                case "kg":
                    result = (num / 1.000 * 2.2046);
                    sb.append(result).append(" lb").append("\n");
                    // sb.append(Math.round(result * 10000) / 10000.0).append(" lb").append("\n");
                    break;

                case "l":
                    result = (num / 1.0000 * 0.2642);
                    sb.append(result).append(" g").append("\n");
                    break;

                case "lb":
                    result = (num / 2.2046 * 1.000);
                    sb.append(result).append(" kg").append("\n");
                    // sb.append(Math.round(result * 10000) / 10000.0).append(" kg").append("\n");
                    break;

                case "g":
                    result = (num / 0.2642 * 1.0000);
                    sb.append(result).append(" l").append("\n");
                    // sb.append(Math.round(result * 10000) / 10000.0).append(" l").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
