import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        double a = Integer.parseInt(st.nextToken()); // 낮에 올라간 높이
        double b = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 높이
        double v = Integer.parseInt(st.nextToken()); // 나무 막대 높이
        
        int day = (int) Math.ceil((v-b)/(a-b)); // 며칠 걸리는 지
        System.out.println(day);
    }
}