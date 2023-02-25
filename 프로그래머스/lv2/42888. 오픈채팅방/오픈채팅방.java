import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            String cmd = st.nextToken();

            if (cmd.equals("Enter")) {
                String uid = st.nextToken();
                String name = st.nextToken();

                map.put(uid, name);
                list.add(uid + "님이 들어왔습니다.");
            } 
            else if (cmd.equals("Leave")) {
                String uid = st.nextToken();
                String name = map.get(uid);

                list.add(uid + "님이 나갔습니다.");
            } 
            else if (cmd.equals("Change")) {
                String uid = st.nextToken();
                String name = st.nextToken();

                map.put(uid, name);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            int idx = s.indexOf("님");

            String uid = s.substring(0, idx);
            answer[i] = map.get(uid) + s.substring(idx, s.length());
        }
        return answer;
    }
}