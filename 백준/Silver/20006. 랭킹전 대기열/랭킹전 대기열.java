import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt(); // 플레이어 수
        int m = sc.nextInt(); // 방의 정원

        HashMap<Integer, ArrayList<Player>> map = new HashMap<>();
        ArrayList<Integer> roomLevel = new ArrayList<>();
        roomLevel.add(0); // 0번방 초기화
        
        int order = 1;

        for (int i = 0; i < p; i++) {
            int l = sc.nextInt();
            String n = sc.next();

            boolean flag = false; // 입장 가능한 방의 여부

            for (int j = 1; j < roomLevel.size(); j++) {
                // 레벨 조건 충족
                if (roomLevel.get(j) - 10 <= l && l <= roomLevel.get(j) + 10) {
                    ArrayList<Player> list = map.get(j);

                    if (list.size() >= m) {
                        continue;
                    }

                    list.add(new Player(l, n));
                    flag = true;
                    break;
                }
            }

            // 방이 아예 없는 경우 & 입장 가능한 방이 없는 경우 (레벨 충족 X) => 새로 방 하나 생성
            if (!flag) {
                ArrayList<Player> list = new ArrayList<>();
                list.add(new Player(l, n));

                roomLevel.add(l); // 방 레벨 설정
                map.put(order, list);

                order++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < roomLevel.size(); i++) {
            ArrayList<Player> list = map.get(i);

            // 플레이어 닉네임 사전순 정렬
            Collections.sort(list, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.name.compareTo(o2.name);
                }
            });

            if (list.size() == m) {
                sb.append("Started!").append("\n");
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j).level + " " + list.get(j).name).append("\n");
                }
            }
            else {
                sb.append("Waiting!").append("\n");
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j).level + " " + list.get(j).name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static public class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}