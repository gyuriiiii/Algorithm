import java.util.HashMap;
import java.util.Scanner;

public class 베스트셀러 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i<N; i++) {
            if(hash.get(sc.next()) == null) {
                hash.put(sc.next(), 1);
            }
            else {
                hash.put(sc.next(), hash.get(sc.next())+1);
            }
        }

        int max = hash.get(0);
        String result = "";
        for(int j=0; j<hash.size(); j++) {
            if(hash.get(j) > max) {
                max = hash.get(j);
                result = hash.
            }
        }
    }
}
