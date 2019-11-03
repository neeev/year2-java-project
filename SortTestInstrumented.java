import java.util.Scanner;

public class SortTestInstrumented {

    public static void main(String args[])
    {
        int arraySize;
        int numTrials;
        Integer data[], dataSelection[], dataBubble[], dataShell[];


        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Sort Test Instrumented Started:");
        System.out.println("Please enter an integer for the size of the array?");

        // Read in an integer value for the array size:
        arraySize = getInt("  The integer value should be greater than or equal to 1: ");

        // Read in an integer value for the number of trials to run:
        System.out.println("How many trials would you like?");
        numTrials = getInt("  It should be an integer value greater than or equal to 1: ");

        SortArrayInstrumented sai = new SortArrayInstrumented();


        // Loop for the number of trials:
        for (int i = 0; i < numTrials; i++) {

            // Generate an array of data containing randomly generated integers:
            data = ArrayUtil.generateRandomArray(arraySize);
            dataSelection = ArrayUtil.duplicateArray(data);
            dataBubble = ArrayUtil.duplicateArray(data);
            dataShell = ArrayUtil.duplicateArray(data);

            sai.selectionSort(dataSelection, arraySize);
            sai.bubbleSort(dataBubble, arraySize);
            sai.shellSort(dataShell, arraySize);

        }

        System.out.println("Total comparisons made: " + sai.getTotalComparisons());
        System.out.println("Average comparisons made: " + (sai.getTotalComparisons()/numTrials));
        System.out.println("Minimum comparisons made: " + sai.getMinComparisons());
        System.out.println("Maximum comparisons made: " + sai.getMaxComparisons());


        System.out.println("Sort Test Instrumented Ended");
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int nResult = 10;

        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            nResult = input.nextInt();
        }
        catch(NumberFormatException e) {
            System.out.println("Warning: could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        catch(Exception e) {
            System.out.println("Warning: there was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        return nResult;
    }
}