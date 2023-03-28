import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 

        String[] file = new String[N];
        for (int i = 0; i < N; i++) {
            file[i] = sc.next();
        }

        HashMap<String, Integer> map = new HashMap<>();
        
        // 각 확장자 파일의 개수 저장
        for (String f : file) {
            int idx = f.indexOf(".");
            String ex = f.substring(idx + 1, f.length());

            map.put(ex, map.getOrDefault(ex, 0) + 1);
        }

        // 사전순으로 정렬
        ArrayList<String> exList = new ArrayList<>(map.keySet());
        exList.sort((s1, s2) -> s1.compareTo(s2));

        StringBuilder sb = new StringBuilder();
        for (String s : exList) {
            sb.append(s + " " + map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}