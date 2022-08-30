import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(list);

        for (Integer i : list) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
    
}
