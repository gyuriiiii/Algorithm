import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>> member = new HashMap<>();
            ArrayList<Integer> order = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int team = sc.nextInt();
                order.add(team);

                if (!member.containsKey(team)) {
                    member.put(team, new ArrayList<>());
                }
                member.get(team).add(j + 1);
            }

            HashMap<Integer, Node> teamScore = new HashMap<>();

            int score = 1;

            for (int j = 0; j < order.size(); j++) {
                int team = order.get(j);

                if (member.get(team).size() == 6) {
                    if (!teamScore.containsKey(team)) {
                        teamScore.put(team, new Node(0, 0, 0));
                    }

                    if (teamScore.get(team).num < 4) {
                        teamScore.get(team).num++;
                        teamScore.get(team).score += (score++);
                    }
                    else if (teamScore.get(team).num == 4) {
                        if (teamScore.get(team).five == 0) {
                            teamScore.get(team).five = score++;
                        }
                        else {
                            score++;
                        }
                    }
                }
            }

            ArrayList<Integer> key = new ArrayList<>(teamScore.keySet());
            Collections.sort(key, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    if(teamScore.get(o1).score == teamScore.get(o2).score) {
                        return Integer.compare(teamScore.get(o1).five, teamScore.get(o2).five);
                    }
                    return Integer.compare(teamScore.get(o1).score, teamScore.get(o2).score);
                }
            });

            System.out.println(key.get(0));
        }
    }

    private static class Node {
        int num; 
        int five;
        int score;

        public Node(int num, int five, int score) {
            this.num = num;
            this.five = five;
            this.score = score;
        }
    }
}