import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
    
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        String[] arr = set.toArray(new String[set.size()]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) { 
                    return s1.compareTo(s2); 
                }
                return s1.length() - s2.length();
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
    
}
