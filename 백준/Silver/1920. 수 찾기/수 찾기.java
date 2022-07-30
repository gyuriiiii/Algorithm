import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a);

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0; i<m; i++) {
            b.add(Integer.parseInt(st2.nextToken()));
        }

        for(int i=0; i<m; i++) {
            int target = b.get(i);
            boolean result = check(a, n, target);
            
            if(result == true) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean check(ArrayList<Integer> a, int n, int target) {
        int start = 0;
        int end = n-1;
        
        while(start<=end) {
            int idx = (start+end)/2;

            if(a.get(idx) == target) {
                return true;
            }
            else if(a.get(idx) < target) {
                start = idx + 1;
            }
            else {
                end = idx - 1;
            }
        }
        return false;
    }
}