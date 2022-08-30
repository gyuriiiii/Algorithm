import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 럭비클럽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 나이 17세보다 많거나 몸무게 80이상이면 성인부
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(name == "#" && age == 0 && weight == 0) {
                break;
            }

            if(age >= 17 && weight >= 80) {
                sb.append(name).append(" Senior");
            }
            else {
                sb.append(name).append(" Junior");
            }
        }
        System.out.println(sb);
    }
}
