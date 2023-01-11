class Solution {
    public int solution(int n) {
        String answer = "";
        
        int num = n;
        while(true) {
            if(num < 3) {
                answer += num;
                break;
            }

            answer += (num%3);
            num /= 3;
        }
        
        
        int sum = 0;
        int len = answer.length();
        int idx = 1;
        for (int i = len-1; i >=0; i--) {
            String c = answer.charAt(i) + ""; 

            sum += (Integer.parseInt(c) * idx);
            idx *= 3;
        }
        
        return sum;
    }
}