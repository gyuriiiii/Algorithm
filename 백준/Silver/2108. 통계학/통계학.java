import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);

        double avg = 0;
        for (int i = 0; i < n; i++) {
            avg += arr[i];
        }
        avg /= n;

        int count = 0;
        int max = -1;
        int mod = arr[0]; // 최빈값
        boolean flag = false;
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
            }
            else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mod = arr[i];
                flag = true;
            }
            else if(max==count && flag==true) {
                mod = arr[i];
                flag = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(avg)).append("\n");
        sb.append(Math.round(arr[n / 2])).append("\n");
        sb.append(Math.round(mod)).append("\n");
        sb.append(Math.round(arr[n - 1] - arr[0]));
        
        System.out.println(sb);
    }
}