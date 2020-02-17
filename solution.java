import java.util.*;
import java.io.*;

class solution {

    // input values
    private static int maxSlices;
    private static int numberOfPizzaTypes;
    private static int[] slicesOnEachPizza;

    // output values
    private static String[] output;

    // temporary values
    private static HashMap<Long,String[]> foundResults = new HashMap<Long,String[]>();

    public static void main(String args[]){
        readInput();
        output = solveProblem(maxSlices, numberOfPizzaTypes-1);
        writeOutput(output[1]);
    }

    private static String[] solveProblem(int c, int i){
        
        Long key = cantorPairing(c,i);

        if(foundResults.get(key)!=null) return foundResults.get(key);
        else {
            String[] result = new String[2];
            if(c==0 || i<0){
                result[0] = String.valueOf(maxSlices - c);
                result[1] = "";
                return result;
            }
            else if(c < slicesOnEachPizza[i]){
                result = solveProblem(c, i-1);
                result[1] += "0";
                foundResults.put(key,result);
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
                foundResults.put(key,result);
                return result;
            }
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
        int numberOfPizzaOrdered = 0;
        ArrayList<Integer> indexOfChosenPizza = new ArrayList<Integer>();
        for(int i=0;i<output.length();i++){
            if(output.charAt(i)=='1'){
                numberOfPizzaOrdered++;
                indexOfChosenPizza.add(i);
            }
        }

        System.out.println(numberOfPizzaOrdered);

        for(int i=0;i<indexOfChosenPizza.size();i++){
            System.out.print(indexOfChosenPizza.get(i)+" ");
        }
    }

    private static long cantorPairing(float a, float b){
        float r = ((a+b)/2)*(a+b+1)+b;
        return (long) r;
    }
}