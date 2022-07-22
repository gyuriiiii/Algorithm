import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int index = 0;
        for(int i=0; i<k; i++) {
            int num = Integer.parseInt(bf.readLine());
            
            if(num == 0 && i!=0) {
                list.remove(--index);
                continue;
            }
            list.add(num);
            index++;
        }
        
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }   
}