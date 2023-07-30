import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>(); 

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int recommend = sc.nextInt();

            if (answer.contains(recommend)) {
                map.put(recommend, map.get(recommend) + 1);
            }

            else {
                if (answer.size() < N) {
                    answer.add(recommend);
                    map.put(recommend, 1);
                }

                else {
                    int minIdx = answer.get(0);
                    int minCnt = map.get(minIdx);

                    for (int j = 1; j < answer.size(); j++) {
                        if (map.get(answer.get(j)) < minCnt) {
                            minIdx = answer.get(j);
                            minCnt = map.get(minIdx);
                        }
                    }

                    map.put(minIdx, 0);
                    answer.remove(Integer.valueOf(minIdx));

                    answer.add(recommend);
                    map.put(recommend, 1);
                }
            }
        }

        Collections.sort(answer);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}