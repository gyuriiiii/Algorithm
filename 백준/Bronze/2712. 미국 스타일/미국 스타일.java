import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            double num = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();

            if (unit.equals("kg")) { // -> lb
                double chg = num / 1.000 * 2.2046;
                String result = String.format("%.4f", chg);
                System.out.println(result + " lb");
            }
            if (unit.equals("lb")) { // -> kg
                double chg = num / 1.0000 * 0.4536;
                String result = String.format("%.4f", chg);
                System.out.println(result + " kg");
            }
            if (unit.equals("l")) { // -> g
                double chg = num / 1.0000 * 0.2642;
                String result = String.format("%.4f", chg);
                System.out.println(result + " g");
            }
            if (unit.equals("g")) { // -> l
                double chg = num / 1.0000 * 3.7854;
                String result = String.format("%.4f", chg);
                System.out.println(result + " l");
            }
        }
    }
}