import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();
            if(cmd.equals("all")) {
                list.clear();
                for(int j=1; j<=20; j++) {
                    list.add(j);
                }
                continue;
            }
            if(cmd.equals("empty")) {
                list.clear();
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if(cmd.equals("add")) {
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
            else if(cmd.equals("remove")) {
                if(list.contains(num)) {
                    for(int j=0; j<list.size(); j++) {
                        if(list.get(j) == num) {
                            list.remove(j);
                        }
                    }
                }
            }
            else if(cmd.equals("check")) {
                if(list.contains(num)) {
                    sb.append("1").append("\n");
                }
                else {
                    sb.append("0").append("\n");
                }
            }
            else if(cmd.equals("toggle")) {
                if(list.contains(num)) {
                    for(int j=0; j<list.size(); j++) {
                        if(list.get(j) == num) {
                            list.remove(j);
                        }
                    }
                }
                else {
                    list.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}