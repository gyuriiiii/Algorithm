import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] origin = new int[N]; 
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            origin[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if(map.containsKey(arr[i])) {
                continue;
            }
            map.put(arr[i], rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(origin[i]) + " ");
        }
        System.out.println(sb);
    }
}