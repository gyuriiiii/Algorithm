import java.util.*;

class Solution {
    public ArrayList<String> solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Plan> planList = new ArrayList<>();
        ArrayDeque<Stop> stop = new ArrayDeque<>(); 

        for (String[] plan : plans) {
            plan[1] = Integer.parseInt(plan[1].split(":")[0]) * 60 + Integer.parseInt(plan[1].split(":")[1]) + "";
            planList.add(new Plan(plan[0], Integer.parseInt(plan[1]), Integer.parseInt(plan[2])));
        }

        // 시작 시간 순 정렬
        planList.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        int currentTime = 0;
        for (int i = 0; i < planList.size() - 1; i++) {
            Plan now = planList.get(i);
            Plan next = planList.get(i + 1);

            // 과제 마칠 수 있는 경우
            if (now.start + now.playtime <= next.start) {
                answer.add(now.name);
                currentTime = now.start + now.playtime;

                // 다음 과제 시작 시간 아직 안된 경우 => 멈춘 과제 수행
                if (currentTime < next.start && !stop.isEmpty()) {
                    int freeTime = next.start - currentTime;

                    while (!stop.isEmpty()) {
                        if (freeTime <= 0) {
                            break;
                        }
                        
                        Stop stopped = stop.peekLast();

                        // 멈췄던 과제 모두 끝낼 수 있는 경우
                        if (freeTime >= stopped.remainTime) {
                            freeTime -= stopped.remainTime;
                            answer.add(stopped.name);
                            stop.pollLast();
                        }

                        // 멈췄던 과제 다 못 끝내는 경우
                        else {
                            stopped.remainTime -= freeTime;
                            break;
                        }
                    }
                }
            }

            // 과제 중간에 멈추는 경우
            else {
                stop.addLast(new Stop(now.name, now.start + now.playtime - next.start));
                currentTime = next.start;
            }
        }

        answer.add(planList.get(planList.size() - 1).name);

        while (!stop.isEmpty()) {
            answer.add(stop.pollLast().name);
        }

        return answer;
    }

    static public class Plan {
        String name;
        int start;
        int playtime;

        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    static public class Stop {
        String name;
        int remainTime;

        public Stop(String name, Integer remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
}