import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    static HashSet<Integer> list;
    static boolean[] visited, isPrime;
    static int[] num;
    static int max = Integer.MIN_VALUE;

    public int solution(String numbers) {
        int answer = 0;

        list = new HashSet<>();

        num = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) - '0';
        }

        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            dfs(0, i + 1, "");
        }

        isPrime = new boolean[max + 1];
        checkPrime(max);

        for (int i : list) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }

    private static void checkPrime(int max) {
        int sqrt = (int) Math.sqrt(max);

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= sqrt; i++) {
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private static void dfs(int cnt, int depth, String s) {
        if (cnt == depth) {
            if (!list.contains(Integer.parseInt(s))) {
                list.add(Integer.parseInt(s));
                max = Math.max(max, Integer.parseInt(s));
            }
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s = s + num[i];
                dfs(cnt + 1, depth, s);
                s = s.substring(0, s.length() - 1);
                visited[i] = false;
            }
        }
    }
}