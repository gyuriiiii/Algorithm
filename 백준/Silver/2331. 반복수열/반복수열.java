import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);

        int idx = 0;
        while (true) {
            String s = Integer.toString(list.get(list.size() - 1));

            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Math.pow(Integer.parseInt(s.charAt(i) + ""), P);
            }

            if (list.contains(sum)) {
                idx = list.indexOf(sum);
                break;
            }
            list.add(sum);
        }
        System.out.println(idx);
    }
}