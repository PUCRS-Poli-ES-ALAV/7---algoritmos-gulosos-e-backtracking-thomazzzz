import java.util.Arrays;

public class NRainhas {

    public char[][] combination(int n) {
        char[][] board = new char[n][n];
        if (n < 2) {
            throw new IllegalArgumentException("n must be greater thant or equal to 2!");
        }
        for (char[] line : board) {
            Arrays.fill(line, '-');
        }
        if (backtracking(board, 0))
            return board;
        else
            return null;
    }

    public boolean backtracking(char[][] board, int line) {
        if (line == board.length)
            return true;
        for (int column = 0; column < board.length; column++) {
            if (canPut(board, line, column)) {
                board[line][column] = 'Q';
                if (backtracking(board, line + 1))
                    return true;
                board[line][column] = '-';
            }
        }
        return false;
    }

    public boolean canPut(char[][] board, int line, int column) {
        for (int i = 0; i < line; i++)
            if (board[i][column] == 'Q')
                return false;
        for (int i = line - 1, j = column - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        for (int i = line - 1, j = column + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;
        return true;
    }

}
