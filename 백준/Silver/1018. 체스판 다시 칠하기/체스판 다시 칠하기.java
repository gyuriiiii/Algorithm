import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        String[] board = new String[row]; // 체스판
        for (int i = 0; i < row; i++) {
            board[i] = sc.nextLine();
        }

        // 체스판 자르기
        int sol = Integer.MAX_VALUE;
        for(int i=0; i<=row-8; i++) { // 8x8 짜리 체스판 만들기
            for(int j=0; j<=col-8; j++) {
                // 체스판 최소비용 구하기
                int curSol = getSolution(i, j, board);

                // 전체 최적의 값과 비교해 갱신
                if(curSol < sol) {
                    sol = curSol;
                }
            }
        }
        System.out.println(sol);
        sc.close();
    }
    
    // i번째와 j번째로 시작하는 하나의 체스판 칠하는 비용 구해줌
    public static int getSolution(int startRow, int startCol, String[] board) {
        // 화이트 체스판과 비교할 것
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSol = 0;

        for(int i=0; i<8; i++) {
            int row = startRow + i;
            for(int j=0; j<8; j++) {
                int col = startCol + j;
                if(board[row].charAt(col) != orgBoard[row % 2].charAt(j)) {
                    whiteSol++; // 둘이 다르면 화이트 체스판 만들려면 +1 해야됨
                }
            }
        }
        return Math.min(whiteSol, 64 - whiteSol); // 화이트체스판과 블랙체스판 중 더 작은 값 리턴
    }
}