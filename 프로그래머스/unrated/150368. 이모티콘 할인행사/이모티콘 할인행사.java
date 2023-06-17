public class Solution {
    static int[][] user;
    static int[] emoticon;
        
    static int maxEmotionPlus, maxCost = Integer.MIN_VALUE;

    static public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emoticon = emoticons;

        int emoticonNum = emoticon.length;
        int[] arr = new int[emoticonNum];

        dfs(0, emoticonNum, arr);

        int[] answer = new int[]{maxEmotionPlus, maxCost};
        return answer;
    }

    private static void dfs(int num, int emoticonNum, int[] arr) {
        if (num == emoticonNum) {
            buyEmoticons(arr);
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            arr[num] = i;
            dfs(num + 1, emoticonNum, arr);
        }
    }

    private static void buyEmoticons(int[] arr) {
        int emoticonPlus = 0; // 이모티콘 플러스 가입자 수
        int totalCost = 0; // 이모티콘 구매비용

        int[] emoticonCost = new int[emoticon.length];
        for (int i = 0; i < emoticon.length; i++) {
            emoticonCost[i] = emoticon[i] * (100 - arr[i]) / 100;
        }

        for (int i = 0; i < user.length; i++) {
            int cost = 0;

            for (int j = 0; j < emoticonCost.length; j++) {
                // 일정 비율 이상 할인하는 경우 => 구매
                if (user[i][0] <= arr[j]) {
                    cost += emoticonCost[j];
                }
            }

            // 일정 가격 이상인 경우 => 구매 취소 후, 이모티콘 플러스 가입
            if (cost >= user[i][1]) {
                cost = 0;
                emoticonPlus++;
            }
            else {
                totalCost += cost;
            }
        }

        if (maxEmotionPlus <= emoticonPlus) {
            if (maxEmotionPlus == emoticonPlus) {
                maxCost = Math.max(maxCost, totalCost);
                return;
            }
            maxEmotionPlus = emoticonPlus;
            maxCost = totalCost;
        }
    }
}