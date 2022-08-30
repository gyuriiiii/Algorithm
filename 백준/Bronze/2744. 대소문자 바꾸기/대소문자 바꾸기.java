import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        
        String s = sc.next();
        String[] arr = s.split("");

        for(int i=0; i<arr.length; i++) {
            char word = arr[i].charAt(0);
            if(word >= 'a' && word <= 'z') {
                arr[i] = arr[i].toUpperCase();
            }
            
            else if(word >= 'A' && word <= 'Z') {
                arr[i] = arr[i].toLowerCase();
            }
        }
        
        for (String string : arr) {
            System.out.print(string);
        }
    }
}