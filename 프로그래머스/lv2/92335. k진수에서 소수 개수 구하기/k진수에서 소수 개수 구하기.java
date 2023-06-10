class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String change = Integer.toString(n, k);
        String[] split = change.split("0");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {
                continue;
            }

            long num = Long.parseLong(split[i]);
            if (checkPrime(num)) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    static private boolean checkPrime(long num) {
        if (num == 1) return false;

        long a = (long) Math.sqrt(num);

        for (int i = 2; i <= a; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}