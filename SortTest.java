import java.util.Scanner;

public class SortTest
{
    public static void main(String args[])
    {
        int arraySize;
        Integer dataSelectionSort[];
//        Integer dataInsertionSort[];
        Integer dataShellSort[];
        Integer dataBubbleSort[];

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Sort Test Started:");
        System.out.println("Please enter an integer for the size of the array?");

        arraySize = getInt("  The integer value should be greater than or equal to 1: ");

        dataSelectionSort = ArrayUtil.generateRandomArray(arraySize);
        dataShellSort = ArrayUtil.duplicateArray(dataSelectionSort);
//        dataInsertionSort = ArrayUtil.duplicateArray(dataSelectionSort);
        dataBubbleSort = ArrayUtil.duplicateArray(dataSelectionSort);

        System.out.println();
        System.out.println("------- SELECTION SORT -------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataSelectionSort);

        System.out.println();
        System.out.println("Sorting using Selection Sort (Iterative): ");
        SelectionSortArray.selectionSort(dataSelectionSort, arraySize);

        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataSelectionSort);

        System.out.println();
        System.out.println("------- SHELL SORT -------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataShellSort);

        System.out.println();
        System.out.println("Sorting using Shell Sort (Iterative): ");
        ShellSortArray.shellSort(dataShellSort, arraySize);

        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataShellSort);

//        System.out.println();
//        System.out.println("------- INSERTION SORT -------");
//        System.out.println();
//        System.out.println("The initial array is: ");
//        ArrayUtil.displayArrayContent(dataInsertionSort);
//
//        System.out.println();
//        System.out.println("Sorting using Insertion Sort (Iterative): ");
//        InsertionSortArray.insertionSort(dataInsertionSort, arraySize);
//
//        System.out.println();
//        System.out.println("The sorted array is: ");
//        ArrayUtil.displayArrayContent(dataInsertionSort);

        System.out.println();
        System.out.println("------- BUBBLE SORT -------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataBubbleSort);

        System.out.println();
        System.out.println("Sorting using Bubble Sort (Iterative): ");
        BubbleSortArray.bubbleSort(dataBubbleSort, arraySize);

        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataBubbleSort);

        System.out.println();
        System.out.println("Sort Test Ended");
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
