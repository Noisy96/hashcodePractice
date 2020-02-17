import java.util.*;
import java.io.*;

class solution {

    // input values
    private static int maxSlices;
    private static int pizzaTypes;
    private static int[] slicesOnEachPizza;

    // output values
    private static int numberOfTypesChosen = 0;
    private static ArrayList<Integer> indexOfChosenPizza = new ArrayList<Integer>();
    private static int score;

    public static void main(String args[]){
        readInput();
        score = solveProblem(maxSlices, pizzaTypes-1);
        writeOutput(score);
    }

    private static int solveProblem(int c, int i){
        if(c==0 || i<0) return maxSlices - c;
        else if(c < slicesOnEachPizza[i]) return solveProblem(c, i-1);
        else {
            int ordering = solveProblem(c-slicesOnEachPizza[i],i-1);
            int notOrdering = solveProblem(c,i-1);
            int result = ordering > notOrdering ? ordering : notOrdering;
            return result;
        }
    }

    private static void readInput(){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        maxSlices = scanner.nextInt();
        pizzaTypes = scanner.nextInt();
        slicesOnEachPizza = new int[pizzaTypes];
        for(int i=0;i<pizzaTypes;i++){
            slicesOnEachPizza[i] = scanner.nextInt();
        }
    }

    private static void writeOutput(int score){
        System.out.println("Score = "+score);
    }

}