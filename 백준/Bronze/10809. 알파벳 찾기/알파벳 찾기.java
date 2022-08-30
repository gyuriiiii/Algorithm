import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z" };
        
        String[] s = sc.next().split("");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s)); 

        int[] result = new int[arr.length];
        for (int k = 0; k < result.length; k++) {
            result[k] = -1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if(list.get(i).equals(arr[j])) {
                    if(result[j] != -1) {
                        continue;   
                    }
                    result[j] = i;
                    break;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
