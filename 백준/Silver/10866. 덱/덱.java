import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            String s = bf.readLine();
            String[] arr = s.split(" ");
            String command = arr[0];

            if(command.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(arr[1]));
                continue;
            }
            
            if(command.equals("push_back")) {
                deque.offerLast(Integer.parseInt(arr[1]));
                continue;
            }
            
            if(command.equals("pop_front")) {           
                try {
                    int number = deque.removeFirst();
                    System.out.println(number);
                    
                } catch (Exception e) {
                    System.out.println(-1);
                }
                continue;
            }
            
            if(command.equals("pop_back")) {      
                try {
                    int number = deque.removeLast();
                    System.out.println(number);
                    
                } catch (Exception e) {
                    System.out.println(-1);
                }
                continue;
            }

            if(command.equals("size")) {
                System.out.println(deque.size());
                continue;
            }
            
            if(command.equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
                continue;
            }
            
            if(command.equals("front")) {
                try {
                    int number = deque.peekFirst();
                    System.out.println(number);

                } catch (Exception e) {
                    System.out.println(-1);
                }
                continue;
            }
            
            if(command.equals("back")) {
                try {
                    int number = deque.peekLast();
                    System.out.println(number);
                    
                } catch (Exception e) {
                    System.out.println(-1);
                }
                continue;
            }
        }
    }
}