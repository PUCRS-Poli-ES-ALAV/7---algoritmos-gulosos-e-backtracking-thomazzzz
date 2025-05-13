import java.util.Arrays;

public class NRainhas {

    public static char[][] combination(int n) {
        int numberOfQueens = n;
        char[][] board = new int[n][n];
        if (n < 2) {
            throw new IllegalArgumenException("n deve ser maior ou igual a 2!");
        }
        for (char[] line : board) {
            Arrays.fill(line, '-');
        }
        if (backtracking(board, 0))
            return board;
        else
            return null;
    }

    public static boolean backtracking(char[][] board, int line) {

    }

    public static void main(String[] args) throws Exception {

    }
}
