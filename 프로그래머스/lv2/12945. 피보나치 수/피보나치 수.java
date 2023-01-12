import java.math.BigInteger;

public class Solution {
   static public BigInteger solution(int n) {
        BigInteger[] arr = new BigInteger[100001];

        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2].add(arr[i - 1]);
        }
        return arr[n].remainder(BigInteger.valueOf(1234567));
    }
}