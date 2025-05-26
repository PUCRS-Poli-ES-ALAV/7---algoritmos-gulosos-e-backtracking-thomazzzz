import java.util.Arrays;

public class NRainhas {
    public long iteracoes = 0;
    public int solucoes = 0;
    public long instrucoes = 0;

    public char[][] combination(int n) {
        char[][] board = new char[n][n];
        if (n < 2) {
            throw new IllegalArgumentException("n must be greater than or equal to 2!");
        }
        for (char[] line : board) {
            Arrays.fill(line, '-');
            instrucoes++; // instrução para preencher a linha
        }
        if (backtracking(board, 0))
            return board;
        else
            return null;
    }

    public boolean backtracking(char[][] board, int line) {
        iteracoes++;
        instrucoes++; // chamada do método

        if (line == board.length) {
            solucoes++; // encontrou uma solução
            return true;
        }

        for (int column = 0; column < board.length; column++) {
            instrucoes++; // comparação de coluna
            if (canPut(board, line, column)) {
                board[line][column] = 'Q';
                instrucoes++; // atribuição

                if (backtracking(board, line + 1))
                    return true;

                board[line][column] = '-';
                instrucoes++; // backtrack
            }
        }

        return false;
    }

    public boolean canPut(char[][] board, int line, int column) {
        for (int i = 0; i < line; i++) {
            instrucoes++; // comparação
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        for (int i = line - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            instrucoes++; // comparação
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = line - 1, j = column + 1; i >= 0 && j < board.length; i--, j++) {
            instrucoes++; // comparação
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
