import java.util.*;
import java.io.*;

class solution {

    // input values
    private static int maxSlices;
    private static int numberOfPizzaTypes;
    private static int[] slicesOnEachPizza;

    // output values
    private static String[] output;

    public static void main(String args[]){
        readInput();
        output = solveProblem(maxSlices, numberOfPizzaTypes-1);
        writeOutput(output[1]);
    }

    private static String[] solveProblem(int c, int i){

        String[] result = new String[2];

        if(c==0 || i<0){
            result[0] = String.valueOf(maxSlices - c);
            result[1] = "";
            return result;
        }
        else if(c < slicesOnEachPizza[i]){
            result = solveProblem(c, i-1);
            result[1] += "0";
            return result;
        }
        else {
            String[] ordering = solveProblem(c-slicesOnEachPizza[i],i-1);
            String[] notOrdering = solveProblem(c,i-1);
            
            if(Integer.valueOf(ordering[0])>Integer.valueOf(notOrdering[0])){
                result[0] = ordering[0];
                result[1] = ordering[1];
                result[1] += "1";
            }
            else {
                result[0] = notOrdering[0];
                result[1] = notOrdering[1];
                result[1] += "0"; 
            }
            return result;
        }
    }

    private static void readInput(){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        maxSlices = scanner.nextInt();
        numberOfPizzaTypes = scanner.nextInt();
        slicesOnEachPizza = new int[numberOfPizzaTypes];
        for(int i=0;i<numberOfPizzaTypes;i++){
            slicesOnEachPizza[i] = scanner.nextInt();
        }
    }

    private static void writeOutput(String output){
        for(int i=0;i<output.length();i++){
            if(output.charAt(i)=='1'){
                System.out.print(i+" ");
            }
        }
    }

}