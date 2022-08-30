import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        int cook = Integer.parseInt(bf.readLine());

        if (cook >= 60) {
            hour += (cook / 60);
            min += (cook %= 60);
        } 
        else {
            min += cook;
        }
        
        if (min >= 60) {
            hour += (min / 60);
            min -= 60;
        }
        if (hour >= 24) {
            hour -= 24;
        }
        System.out.println(hour + " " + min);
    }
}