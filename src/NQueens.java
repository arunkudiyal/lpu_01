import java.util.ArrayList;
import java.util.List;
class NQueens {
    public void nQueens(List<List<String>> answer, char[][] board, int row, int n) {
        if(row == n) {
            List<String> solution = generateAnswer(board, n);
            answer.add(solution);
            return;
        }
        for(int col=0; col < n; col++) {
            if( isSafe(row, col, board, n) ) {
                board[row][col] = 'Q';
                nQueens(answer, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(int row, int col, char[][] board, int n ) {
        // Horizontal & Vertical
        for(int i=0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
            if(board[row][i] == 'Q') return false;
        }
        // Upper-left diagonal
        for(int i=row, j=col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        // Upper-right diagonal
        for(int i=row, j=col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    public List<String> generateAnswer(char[][] board, int n) {
        List<String> solution = new ArrayList<>();
        for(int row=0; row < n; row++) {
            String str = "";
            for(int col=0; col < n; col++) {
                str += board[row][col];
            }
            solution.add(str);
        }
        return solution;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int row=0; row <n; row++) {
            for(int col=0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        // updates the answer from the board
        nQueens(answer, board, 0, n);
        return answer;
    }

    public static void main(String[] args) {

    }
}