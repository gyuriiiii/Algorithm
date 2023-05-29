import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public ArrayList<String> solution(String[] files) {
        HashMap<String, Node> map = new HashMap<>();

        int order = 0;
        for (String file : files) {
            String HEAD = "";
            String NUMBER = "";

            int num = 0;
            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);

                if (num == 5) {
                    break;
                }

                if (num == 0 && !Character.isDigit(c)) { 
                    HEAD += c;
                }

                if (Character.isDigit(c)) { 
                    NUMBER += c;
                    num++;
                }

                if (num != 0 && !Character.isDigit(c)) { // TAIL
                    break;
                }
            }

            map.put(file, new Node(order++, HEAD.toLowerCase(), Integer.parseInt(NUMBER)));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).HEAD.equals(map.get(o2).HEAD)) { 
                    if (map.get(o1).NUMBER == map.get(o2).NUMBER) { 
                        return Integer.compare(map.get(o1).order, map.get(o2).order); 
                    }
                    return Integer.compare(map.get(o1).NUMBER, map.get(o2).NUMBER); 
                }
                return map.get(o1).HEAD.compareTo(map.get(o2).HEAD); 
            }
        });

        return list;
    }

    static public class Node {
        int order;
        String HEAD;
        int NUMBER;

        public Node(int order, String HEAD, int NUMBER) {
            this.order = order;
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
        }
    }
}