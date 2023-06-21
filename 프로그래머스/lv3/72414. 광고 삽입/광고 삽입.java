public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;

        int play_time_sec = timeToSec(play_time);
        int adv_time_sec = timeToSec(adv_time);

        int[] total_time = new int[play_time_sec + 1];
        for (int i = 0; i < logs.length; i++) {
            String[] tmp = logs[i].split("-");

            int start = timeToSec(tmp[0]);
            int end = timeToSec(tmp[1]);

            for (int j = start; j < end; j++) {
                total_time[j]++;
            }
        }
        
        long max = 0;
        for (int i = 0; i < adv_time_sec; i++) {
            max += total_time[i];
        }

        long now = max;
        for (int start = 1, j = adv_time_sec; j < play_time_sec; start++, j++) {
            now = now - total_time[start - 1] + total_time[j];

            if (now > max) {
                max = now;
                answer = start;
            }
        }
        return secToTime(answer);
    }

    private static String secToTime(int time) {
        int hour = time / 3600;
        time %= 3600;
        int min = time / 60;
        time %= 60;
        int sec = time;

        String answer = String.format("%02d:%02d:%02d", hour, min, sec);
        return answer;
    }

    private static int timeToSec(String s) {
        String[] tmp = s.split(":");
        return Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);
    }
}