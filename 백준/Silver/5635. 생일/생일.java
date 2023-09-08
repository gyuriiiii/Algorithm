import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();

            int day = sc.nextInt();
            int month = sc.nextInt();
            String year = sc.next();

            String birthday = year + String.format("%02d", month) + String.format("%02d", day);
            map.put(name, Integer.parseInt(birthday));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Integer.compare(map.get(o1), map.get(o2)));

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }
}