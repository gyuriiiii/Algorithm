public class Main {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int sum = 0;
            for (int j = 0; j < Integer.toString(i).length(); j++) {
                sum += Integer.parseInt(Integer.toString(i).charAt(j) + "");
            }
            sum += i;

            if (sum < 10001) {
                arr[sum] = true; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}