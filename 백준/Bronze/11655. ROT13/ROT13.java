import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                int tmp = c + 13;
                if (Character.isUpperCase(c) && tmp > 90) {
                    tmp -= 26;
                }
                else if (Character.isLowerCase(c) && tmp > 122) {
                    tmp -= 26;
                }
                char word = (char) tmp;
                answer += word;
            }
            else {
                answer += c;
            }
        }
        System.out.println(answer);
    }
}