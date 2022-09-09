import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제 수

        HashMap<Integer, String> mapInt = new HashMap<>();
        HashMap<String, Integer> mapString = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            mapInt.put(i, s);
            mapString.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=M; i++) {
            String s = br.readLine();
            if(isNum(s)) { // 숫자인 경우
                sb.append(mapInt.get(Integer.parseInt(s))).append("\n");
            } 
            else {
                sb.append(mapString.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isNum(String s) {
        if(Character.isDigit(s.charAt(0))) {
            return true;
        }
        return false;
    }
}