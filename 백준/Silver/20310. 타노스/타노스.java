import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        
        int zero = 0;
        int one = 1;
        
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
            if (arr[i] == '0') {
                zero++;
            }
            else {
                one++;
            }
        }

        zero /= 2;
        one /= 2;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (zero > 0 && arr[i] == '0') {
                zero--;
                arr[i] = '2';
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (one > 0 && arr[i] == '1') {
                one--;
                arr[i] = '2';
            }
        }

        String result = "";
        for (char c : arr) {
            if (c != '2') {
                result += c;
            }
        }
        System.out.println(result);
    }
}