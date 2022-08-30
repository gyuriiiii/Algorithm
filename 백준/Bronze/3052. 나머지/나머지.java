import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10]; 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if(!list.contains(arr[j]%42)) { // 서로 다른 나머지인 경우
                result++;
            }
            list.add(arr[j]%42); 
        }
        System.out.println(result);
    }
}
