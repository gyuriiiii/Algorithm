import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer, String[]> map = new HashMap<>();
        HashMap<Integer, Integer> times = new HashMap<>();

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);

            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String history = st.nextToken();

            if (!map.containsKey(carNum)) {
                map.put(carNum, new String[]{time, ""});
            }
            else {
                String[] tmp = map.get(carNum);
                tmp[1] = time;

                // 누적 시간 계산
                int t = 0;
                if (times.containsKey(carNum)) {
                    t = times.get(carNum);
                }
                times.put(carNum, t + calculate(map, carNum));

                map.remove(carNum);
            }
        }

        for (Integer car : map.keySet()) {
            String in = map.get(car)[0];

            int inTime = (Integer.parseInt(in.split(":")[0]) * 60) + Integer.parseInt(in.split(":")[1]);
            int outTime = 23 * 60 + 59;
            int totalTime = outTime - inTime; // 누적 시간

            int t = 0;
            if (times.containsKey(car)) {
                t = times.get(car);
            }
            times.put(car, t + totalTime);
        }

        ArrayList<Integer> list = new ArrayList<>(times.keySet());
        list.sort((o1, o2) -> Integer.compare(o1, o2));
        
        for (Integer i : list) {
            int fee = fees[1];
            int totalTime = times.get(i);

            if (totalTime > fees[0]) {
                fee += ((totalTime - fees[0]) / fees[2]) * fees[3];

                if ((totalTime - fees[0]) % fees[2] != 0) {
                    fee += fees[3];
                }
            }

            answer.add(fee);
        }

        return answer;
    }

    private static int calculate(HashMap<Integer, String[]> map, int carNum) {
        String in = map.get(carNum)[0];
        String out = map.get(carNum)[1];

        int inTime = (Integer.parseInt(in.split(":")[0]) * 60) + Integer.parseInt(in.split(":")[1]);
        int outTime = (Integer.parseInt(out.split(":")[0]) * 60) + Integer.parseInt(out.split(":")[1]);
        int totalTime = outTime - inTime; // 누적 시간

        return totalTime;
    }
}