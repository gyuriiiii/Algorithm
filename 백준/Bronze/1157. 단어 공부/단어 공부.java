import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); 
        s = s.toUpperCase(); 

        int[] arr = new int[26]; // 알파벳 개수 저장
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i); 

            arr[ch-'A']++;
        }
        
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) { // 가장 많이 사용된 알파벳 개수
                max = arr[i]; 
            }
        }

        int num = 0;
        char answer = '0';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == max) {
                num++;
                answer = (char) (i+'A');
            }
        }
        if(num > 1) { // 가장 많이 사용된 알파벳 여러 개 존재하는 경우
            answer = '?';
        }
        
        System.out.println(answer);
    }
    
}
