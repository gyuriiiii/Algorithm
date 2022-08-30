import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());
        int[] car = new int[5];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<5; i++) {
            car[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++) {
            if(car[i] % 10 == n) {
                sum++;
            }
        }
        System.out.println(sum);
    }   
}