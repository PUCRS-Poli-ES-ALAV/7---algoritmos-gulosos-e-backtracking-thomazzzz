import java.util.Scanner;

public class MainNRainhas {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("\nHello! Enter a number of queens: ");
        int queens = in.nextInt();

        NRainhas solver = new NRainhas();

        long startTime = System.nanoTime(); // Início do cronômetro
        char[][] solution = solver.combination(queens);
        long endTime = System.nanoTime(); // Fim do cronômetro

        long durationNano = endTime - startTime;
        double durationMillis = durationNano / 1_000_000.0;

        System.out.println("\nA possible solution is: \n");
        if (solution != null) {
            for (char[] line : solution)
                System.out.println(new String(line));
        } else {
            System.out.println("No solution was found!");
        }

        // Estatísticas
        System.out.println("\n--- Estatísticas ---");
        System.out.println("N: " + queens);
        System.out.println("Iterações (backtracking): " + solver.iteracoes);
        System.out.println("Instruções (aproximadas): " + solver.instrucoes);
        System.out.println("Tempo de execução: " + durationMillis + " ms");

        in.close();
    }
}
