import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("\nHello! Enter a number of queens: ");
        int queens = in.nextInt();
        System.out.println("\nA possible solution is: \n");
        NRainhas solver = new NRainhas();
        char[][] solution = solver.combination(queens);
        if(solution != null) {
            for(char[] line : solution)
                System.out.println(new String(line));
        }
        else {
            System.out.println("No solution was found!");
        }
        in.close();
    }
}