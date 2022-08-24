import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=0; i<t; i++) {
            int s1 = 0;
            int s2 = 0;
            int n = sc.nextInt();
            for(int j=0; j<n; j++) {

                String p1 = sc.next();
                String p2 = sc.next();
                
                if(p1.equals("R")) { // 바위
                    if(p2.equals("S")) {
                        s1++;
                    }
                    else if(p2.equals("P")) {
                        s2++;
                    }
                    else {
                        s1++;
                        s2++;
                    }
                }
                else if(p1.equals("P")) { // 보
                    if(p2.equals("R")) {
                        s1++;
                    }
                    else if(p2.equals("S")) {
                        s2++;
                    }
                    else {
                        s1++;
                        s2++;
                    }
                }
                else { // 가위
                    if(p2.equals("P")) {
                        s1++;
                    }
                    else if(p2.equals("R")) {
                        s2++;
                    }
                    else {
                        s1++;
                        s2++;
                    }
                }
            }
            if(s1>s2) {
                System.out.println("Player 1");
            }
            if(s1<s2) {
                System.out.println("Player 2");
            }
            if(s1==s2) {
                System.out.println("TIE");
            }
        }
    }
}