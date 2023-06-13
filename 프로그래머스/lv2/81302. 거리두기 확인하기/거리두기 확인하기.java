import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static ArrayList<Node> persons; 
    static char[][] map;

    static public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);

        for (int k = 0; k < places.length; k++) {
            map = new char[5][5];
            persons = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = places[k][i].charAt(j);

                    if (map[i][j] == 'P') {
                        persons.add(new Node(i, j));
                    }
                }
            }

            boolean flag = true;

            for (int i = 0; i < persons.size() - 1; i++) {
                Node now = persons.get(i);
                for (int j = i + 1; j < persons.size(); j++) {
                    Node next = persons.get(j);

                    if (manhattan(now, next) <= 2) {
                        if (now.x == next.x) {
                            if (now.y + 1 < 5) {
                                if (map[now.x][now.y + 1] != 'X') { // 파티션 없는 경우
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        else if (now.y == next.y) {
                            if (now.x + 1 < 5) {
                                if (map[now.x + 1][now.y] != 'X') {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        else {
                            if (now.y < next.y) {
                                if (now.x + 1 < 5 && now.y + 1 < 5) {
                                    if (map[now.x][now.y + 1] != 'X' || map[now.x + 1][now.y] != 'X') {
                                        flag = false;
                                        break;
                                    }
                                }
                            }
                            else {
                                if (now.x + 1 < 5 && now.y - 1 >= 0) {
                                    if (map[now.x][now.y - 1] != 'X' || map[now.x + 1][now.y] != 'X') {
                                        flag = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if (!flag) {
                    answer[k] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    static private int manhattan(Node now, Node next) {
        return Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
    }

    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}