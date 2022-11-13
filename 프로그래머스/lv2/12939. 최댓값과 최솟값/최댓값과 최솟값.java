class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(min > Integer.parseInt(arr[i])) {
                min = Integer.parseInt(arr[i]);
            }
            
            if(max < Integer.parseInt(arr[i])) {
                max = Integer.parseInt(arr[i]);
            }
        }
        answer = min + " " + max;

        return answer;
    }
}