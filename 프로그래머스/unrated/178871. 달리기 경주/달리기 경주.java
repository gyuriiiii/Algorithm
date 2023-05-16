import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int winner = map.get(callings[i]);
            int loser = winner - 1;

            String tmp = players[loser];
            players[loser] = players[winner];
            players[winner] = tmp;

            map.put(callings[i], loser);
            map.put(players[loser + 1], loser + 1);
        }

        return players;
    }
}