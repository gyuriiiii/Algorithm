import java.util.ArrayList;

public class Solution {
    static int[] parent;
    static String[] arr;

    static public ArrayList<String> solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();

        arr = new String[2501];
        parent = new int[2501];

        for (int i = 1; i < 2501; i++) {
            parent[i] = i;
            arr[i] = "";
        }

        for (String command : commands) {
            String[] op = command.split(" ");

            if (op[0].equals("UPDATE")) {
                if (op.length == 4) {
                    int r = Integer.parseInt(op[1]);
                    int c = Integer.parseInt(op[2]);
                    String value = op[3];

                    int idx = convertNum(r, c);
                    arr[find(idx)] = value;
                }
                else if (op.length == 3) {
                    String value1 = op[1];
                    String value2 = op[2];

                    for (int i = 1; i < 2501; i++) {
                        if (arr[i].equals(value1)) {
                            arr[i] = value2;
                        }
                    }
                }
            }
            else if (op[0].equals("MERGE")) {
                int r1 = Integer.parseInt(op[1]);
                int c1 = Integer.parseInt(op[2]);
                int r2 = Integer.parseInt(op[3]);
                int c2 = Integer.parseInt(op[4]);

                int idx1 = convertNum(r1, c1);
                int idx2 = convertNum(r2, c2);

                int root1 = find(idx1);
                int root2 = find(idx2);

                if(root1 == root2) {
                    continue;
                }

                if (!arr[root1].equals("")) {
                    union(root2, root1);
                    arr[root2] = "";
                }
                else {
                    union(root1, root2);
                    arr[root1] = "";
                }
            }
            else if (op[0].equals("UNMERGE")) {
                int r = Integer.parseInt(op[1]);
                int c = Integer.parseInt(op[2]);

                int idx = convertNum(r, c);
                int root = find(idx);
                String rootString = arr[root];

                arr[root] = "";
                arr[idx] = rootString;

                ArrayList<Integer> removeList = new ArrayList<>();
                for (int i = 1; i < 2501; i++) {
                    if(find(i) == root) {
                        removeList.add(i);
                    }
                }

                for(int remove : removeList) {
                    parent[remove] = remove;
                }
            }
            else if (op[0].equals("PRINT")) {
                int r = Integer.parseInt(op[1]);
                int c = Integer.parseInt(op[2]);
                int idx = convertNum(r, c);

                int root = find(idx);
                if(arr[root].equals("")) {
                    answer.add("EMPTY");
                }
                else {
                    answer.add(arr[root]);
                }
            }
        }
        return answer;
    }

    static private int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[x] = y;
    }

    static public int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }
}