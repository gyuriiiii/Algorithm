import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int result = 0;
            String s = sc.nextLine(); 
            if(s.equals("#")) break;

            s = s.toLowerCase(); // 소문자로 변경

            String[] arr = s.split(" "); 
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[i].length(); j++) {
                    if(arr[i].charAt(j) == 'a' || arr[i].charAt(j) == 'e' || arr[i].charAt(j) == 'i' || arr[i].charAt(j) == 'o' || arr[i].charAt(j) == 'u') {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
