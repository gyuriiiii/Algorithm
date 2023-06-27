import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            sum1 += Integer.parseInt(o1.charAt(i) + "");
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            sum2 += Integer.parseInt(o2.charAt(i) + "");
                        }
                    }

                    if (sum1 == sum2) {
                        return o1.compareTo(o2);
                    }
                    return Integer.compare(sum1, sum2);
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}