import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        ArrayList<Node> books = new ArrayList<>();
        for (String[] book : book_time) {
            int start = Integer.parseInt(book[0].split(":")[0]) * 60 + Integer.parseInt(book[0].split(":")[1]);
            int end = Integer.parseInt(book[1].split(":")[0]) * 60 + Integer.parseInt(book[1].split(":")[1]) + 10;

            books.add(new Node(start, end));
        }

        books.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        ArrayList<Integer> wait = new ArrayList<>();
        wait.add(books.get(0).end);
        answer++;

        for (int i = 1; i < books.size(); i++) {
            Node book = books.get(i);

            if (!checkClean(book, wait)) {
                answer++;
                wait.add(book.end);
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean checkClean(Node book, ArrayList<Integer> wait) {
        Collections.sort(wait);

        for (int i = 0; i < wait.size(); i++) {
            if (wait.get(i) <= book.start) {
                wait.remove(i); 
                wait.add(book.end); 
                return true;
            }
        }
        return false;
    }

    static public class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}