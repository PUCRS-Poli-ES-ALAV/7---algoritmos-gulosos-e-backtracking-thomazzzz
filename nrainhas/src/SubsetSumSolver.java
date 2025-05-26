import java.util.*;

public class SubsetSumSolver {
    public long iteracoes = 0;
    public long instrucoes = 0;

    // Encontra o primeiro subconjunto cuja soma seja zero
    public List<Integer> findFirstSubsetWithZeroSum(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subconjuntos possíveis

        for (int mask = 1; mask < totalSubsets; mask++) { // ignora conjunto vazio
            iteracoes++;
            instrucoes++; // para a criação do subconjunto
            List<Integer> subset = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                instrucoes++; // loop interno
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                    sum += nums[i];
                    instrucoes += 2;
                }
            }

            if (sum == 0) {
                instrucoes++;
                return subset;
            }
        }

        return null; // nenhum encontrado
    }

    // Encontra todos os subconjuntos cuja soma seja zero
    public List<List<Integer>> findAllSubsetsWithZeroSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n;

        for (int mask = 1; mask < totalSubsets; mask++) { // ignora vazio
            iteracoes++;
            instrucoes++;
            List<Integer> subset = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                instrucoes++;
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                    sum += nums[i];
                    instrucoes += 2;
                }
            }

            if (sum == 0) {
                instrucoes++;
                result.add(subset);
            }
        }

        return result;
    }
}
