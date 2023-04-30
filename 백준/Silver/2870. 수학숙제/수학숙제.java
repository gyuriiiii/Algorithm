import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<BigInteger> list = new ArrayList<>();
        String line[];
        for (int i = 0; i < N; i++) {
            line = sc.next().split("\\D");

            for (int j = 0; j < line.length; j++) {
                if (!line[j].equals("")) {
                    list.add(new BigInteger(line[j]));
                }
            }
        }

        Collections.sort(list);
        for (BigInteger s : list) {
            System.out.println(s);
        }
    }
}