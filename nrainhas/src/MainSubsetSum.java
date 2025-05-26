import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSubsetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite os inteiros separados por espaço:");
        String[] input = in.nextLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        // PRIMEIRA VERSÃO: encontrar o primeiro subconjunto
        SubsetSumSolver solver1 = new SubsetSumSolver();
        long start1 = System.nanoTime();
        List<Integer> firstSubset = solver1.findFirstSubsetWithZeroSum(nums);
        long end1 = System.nanoTime();

        System.out.println("\n--- Primeira Subsolução (um subconjunto com soma zero) ---");
        if (firstSubset != null)
            System.out.println("Subconjunto encontrado: " + firstSubset);
        else
            System.out.println("Nenhum subconjunto com soma zero encontrado.");
        System.out.println("Iterações: " + solver1.iteracoes);
        System.out.println("Instruções: " + solver1.instrucoes);
        System.out.println("Tempo: " + (end1 - start1) / 1_000_000.0 + " ms");

        // SEGUNDA VERSÃO: encontrar todos os subconjuntos
        SubsetSumSolver solver2 = new SubsetSumSolver();
        long start2 = System.nanoTime();
        List<List<Integer>> allSubsets = solver2.findAllSubsetsWithZeroSum(nums);
        long end2 = System.nanoTime();

        System.out.println("\n--- Todas as Subsoluções ---");
        if (!allSubsets.isEmpty()) {
            for (List<Integer> subset : allSubsets)
                System.out.println(subset);
        } else {
            System.out.println("Nenhum subconjunto com soma zero encontrado.");
        }
        System.out.println("Iterações: " + solver2.iteracoes);
        System.out.println("Instruções: " + solver2.instrucoes);
        System.out.println("Tempo: " + (end2 - start2) / 1_000_000.0 + " ms");

        in.close();
    }
}
