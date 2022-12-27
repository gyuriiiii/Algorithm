import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine(); // 문자열
        String bomb = br.readLine(); // 폭발 문자열
        int bomblen = bomb.length(); // 폭발 문자열 길이

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            stack.add(c);

            // 폭발 문자열 길이와 같거나 넘은 경우
            if(stack.size() >= bomblen) {
                boolean flag = true;

                // 폭발 문자열과 같은 지 검사
                for(int j=0; j<bomblen; j++) {
                    char c1 = stack.get(stack.size() - bomblen + j);
                    char c2 = bomb.charAt(j); 

                    if(c1 != c2) {
                        flag = false;
                        break;
                    }
                }

                // 폭발 문자열과 같은 경우 (단어 폭파시키기)
                if(flag) {
                    for(int k=0; k<bomblen; k++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.size() == 0) {
            System.out.println("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}