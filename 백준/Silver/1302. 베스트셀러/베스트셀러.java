import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = sc.next();
            if(!hash.containsKey(s)) {
                hash.put(s, 1);
            }
            else {
                hash.put(s, hash.get(s)+1);
            }
        }

        int max = -1;
        String result = "";

        int cnt = 0;
        for (String key : hash.keySet()) { 
            if(hash.get(key) >= max) {
                max = hash.get(key);
                result = key;
                cnt++;
            }
        }

        ArrayList<String> list = new ArrayList<>();
        if(cnt > 1) {
            for (String key : hash.keySet()) { 
                if(hash.get(key) == max) {
                    list.add(key);
                }
            }
            Collections.sort(list);
            System.out.println(list.get(0));
        }

        else {
            System.out.println(result);
        }
    }
}