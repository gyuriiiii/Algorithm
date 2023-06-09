import java.util.HashSet;

public class Solution {
    static String[] userIds;
    static String[] bannedIds;
    static HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        dfs(new HashSet<>(), 0);
        return result.size();
    }

    private static void dfs(HashSet<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) {
                continue;
            }

            if (check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }

    private static boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;

            if (bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}