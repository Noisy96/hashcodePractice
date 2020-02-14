import java.util.*;
import java.io.*;

class solution {

    private static int maxSlices;
    private static int pizzaTypes;
    private static int[] slicesOnEachPizza;

    public static void main(String args[]){
        readInput();
        writeOutput();

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

    private static void writeOutput(){
        System.out.println(maxSlices+" "+pizzaTypes);
        for(int i=0;i<pizzaTypes;i++){
            System.out.print(slicesOnEachPizza[i]+" ");
        }
    }

}