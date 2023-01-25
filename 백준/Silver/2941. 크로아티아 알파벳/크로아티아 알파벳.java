import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static char c1;
    static char c2;
    static String word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String[] arr = new String[s.length()];

        Deque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) + "";

            queue.offer(s.charAt(i));
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            c1 = queue.poll();

            if(queue.isEmpty()) {
                cnt++;
                break;
            }
            c2 = queue.poll();

            word = c1 + "" + c2;

            if (word.equals("c=") || word.equals("c-") || word.equals("d-") || word.equals("lj") || word.equals("nj")
                    || word.equals("s=") || word.equals("z=")) {
                cnt++;
            } 
            else if (word.equals("dz")) {
                if (!queue.isEmpty() && queue.peek() == '=') {
                    queue.poll();
                    cnt++;
                } 
                else {
                    cnt++;
                    queue.offerFirst(c2);
                }
            } 
            else {
                cnt++;
                queue.offerFirst(c2);
            }
        }
        System.out.println(cnt);
    }
}