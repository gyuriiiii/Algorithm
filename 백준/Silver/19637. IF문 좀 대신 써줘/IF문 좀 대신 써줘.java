import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node> powers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            powers.add(new Node(name, power));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());

            int low = 0;
            int high = N - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int num = powers.get(mid).power;

                if (num < power) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            sb.append(powers.get(low).name).append("\n");
        }
        System.out.println(sb);
    }

    static public class Node {
        String name;
        int power;

        public Node(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
}