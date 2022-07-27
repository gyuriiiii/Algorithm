import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String s = bf.readLine();
            String[] arr = s.split(" ");
            String command = arr[0];

            if(command.equals("push")) {
                list.add(Integer.parseInt(arr[1]));
                continue;
            }

            if(command.equals("pop")) {
                if(list.size() == 0) System.out.println(-1);

                else {
                    int num = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    System.out.println(num);
                }
                continue;
            }

            if(command.equals("size")) {
                System.out.println(list.size());
                continue;
            }

            if(command.equals("empty")) {
                if(list.isEmpty()) System.out.println(1);
                else System.out.println(0);
                continue;
            }

            if(command.equals("top")) {
                if(list.size() == 0) System.out.println(-1);
                else System.out.println(list.get(list.size()-1));
                continue;
            }
        }
    }
}