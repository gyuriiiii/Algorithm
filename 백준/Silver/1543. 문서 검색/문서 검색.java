import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String word = sc.nextLine();

        int len = word.length();
        int idx = 0;

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(idx + len > s.length()) {
                break;
            }
            String comp = s.substring(idx, idx + len);
            
            if(comp.equals(word)) {
                idx += len;
                cnt++;
            }
            else {
                idx++;
            }
        }
        System.out.println(cnt);
    }
}