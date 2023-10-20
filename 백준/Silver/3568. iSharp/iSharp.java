import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll(",", "");
            arr[i] = arr[i].replaceAll(";", "");
            arr[i] = arr[i].trim();
        }

        String standard = arr[0];

        for (int i = 1; i < arr.length; i++) {
            String a = arr[i];

            String variable_name = ""; // 변수명
            String variable_type = ""; // 변수형

            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) >= 'a' && a.charAt(j) <= 'z' || a.charAt(j) >= 'A' && a.charAt(j) <= 'Z') {
                    variable_name += a.charAt(j);
                }
                else {
                    variable_type += a.charAt(j);
                }
            }

            variable_type = reverse(variable_type);
            System.out.println(standard + variable_type + " " + variable_name + ";");
        }
    }

    private static String reverse(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '[') {
                tmp += ']';
                continue;
            }
            else if(s.charAt(i) == ']') {
                tmp += '[';
                continue;
            }
            tmp += s.charAt(i);
        }
        return tmp;
    }
}