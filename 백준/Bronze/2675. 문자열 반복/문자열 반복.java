import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트 케이스 개수
        
        int[] numArr = new int[n]; // 반복 횟수 배열
        String[] wordArr = new String[n]; // 반복 단어 배열
        
        // 횟수&단어 입력 받기
        for(int i=0; i<n; i++) {
            numArr[i] = sc.nextInt(); 
            wordArr[i] = sc.next(); 
        }
        
        String[] answer = new String[n];
        for (int k = 0; k < answer.length; k++) {
            answer[k] = "";
        }

        for(int i=0; i<answer.length; i++) { 
            for(int k=0; k<wordArr[i].length(); k++) {
                for(int j=0; j<numArr[i]; j++) {
                    answer[i] += wordArr[i].charAt(k);
                }
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }
}
