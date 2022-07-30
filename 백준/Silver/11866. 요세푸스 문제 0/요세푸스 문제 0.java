import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = i;
        }

        int idx = 0;
        int i=1;
        System.out.print("<");
        while(true) {
            if(idx==k*n) {
                break;
            }
            if(arr[i] == 0) {
                if(i==n) {
                    i=1;
                }
                else {
                    i++;    
                }
                continue;
            }
            else {
                idx++;
                if(idx%k==0) {
                    arr[i] = 0;
                    if(idx==k*n) {
                        System.out.print(i + ">");
                        break;
                    }
                    System.out.print(i + ", ");
                }
            }
            if(i==n) {
                i=1;
                continue;
            }
            i++;
         }
    }
}