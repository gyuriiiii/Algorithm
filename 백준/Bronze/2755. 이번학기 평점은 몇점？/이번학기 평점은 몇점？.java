import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double sum = 0.00; // 학점*성적
        int numTotal = 0; // 총 학점
        for (int i = 0; i < N; i++) {
            double score = 0.00; // 성적

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String title = st.nextToken();

            int total = Integer.parseInt(st.nextToken());
            numTotal += total;

            switch (st.nextToken()) {
                case "A+":
                    score = 4.3;
                    break;
                case "A0":
                    score = 4.0;
                    break;
                case "A-":
                    score = 3.7;
                    break;
                case "B+":
                    score = 3.3;
                    break;
                case "B0":
                    score = 3.0;
                    break;
                case "B-":
                    score = 2.7;
                    break;
                case "C+":
                    score = 2.3;
                    break;
                case "C0":
                    score = 2.0;
                    break;
                case "C-":
                    score = 1.7;
                    break;
                case "D+":
                    score = 1.3;
                    break;
                case "D0":
                    score = 1.0;
                    break;
                case "D-":
                    score = 0.7;
                    break;
                case "F":
                    score = 0.0;
                    break;
            }
            sum += (total*score);
        }
        System.out.printf("%.2f", sum/numTotal);
    }
}