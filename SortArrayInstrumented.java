public class SortArrayInstrumented {

    private long comparisons;
    private long totalComparisons;
    private long maxComparisons;
    private long minComparisons;

    public SortArrayInstrumented()
    {
        comparisons = 0;
        totalComparisons = 0;
        minComparisons =Long.MAX_VALUE;
        maxComparisons = 0;
    }

    public long getTotalComparisons() {
        return totalComparisons;
    }

    public long getMinComparisons() {
        return minComparisons;
    }

    public long getMaxComparisons() {
        return maxComparisons;
    }

    private void startStatistics() {
        comparisons = 0;
    }

    private void endStatistics() {
        totalComparisons += comparisons;
        if (comparisons < minComparisons) {
            minComparisons = comparisons;
        }
        if (comparisons > maxComparisons) {
            maxComparisons = comparisons;
        }
    }

    /**************************************************************
     * SORTING ALGORITHMS
     **************************************************************/

    public <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int n)
    {
        startStatistics();
        selectionSort(arr, 0, n-1);
        endStatistics();
    }

    private <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int first, int last) {
        for (int index = first; index < last; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(arr, index, last);
            swap(arr, index, indexOfNextSmallest);
        }
    }

    private <T extends Comparable<? super T>>
    int getIndexOfSmallest(T[] arr, int first, int last) {
        T minVal = arr[first];
        int indexMin = first;

        for (int index = first + 1; index <= last; index++) {
            comparisons++;
            if (arr[index].compareTo(minVal) < 0) {
                minVal = arr[index];
                indexMin = index;
            }
        }
        return indexMin;
    }

    public <T extends Comparable<? super T>>
    void bubbleSort(T[] array, int arraySize)
    {
        startStatistics();
        bubbleSort(array, 0, arraySize-1);
        endStatistics();
    }

    private <T extends Comparable<? super T>>
    void bubbleSort(T[] array, int indexOfFirst, int indexOfLast) {
        for (int i = indexOfFirst; i < indexOfLast; i++) {
            for (int currentIndex = indexOfFirst; currentIndex < (indexOfLast - i); currentIndex++) {
                comparisons++;
                if (array[currentIndex].compareTo(array[currentIndex + 1]) > 0) {
                    swap(array, currentIndex, (currentIndex + 1));
                }
            }
        }
    }

    private <T>
    void swap(T[] arr, int from, int to) {
        T temp = arr[from];

        arr[from] = arr[to];
        arr[to] = temp;
    }

    public <T extends Comparable<? super T>>
    void shellSort(T[] array, int arraySize)
    {
        startStatistics();
        shellSort(array, 0, arraySize-1);
        endStatistics();
    }

    private <T extends Comparable<? super T>>
    void shellSort(T[] array, int indexOfFirst, int indexOfLast) {
        int arraySize = indexOfLast - indexOfFirst + 1;
        int interval = arraySize/2;

        while (interval > 0) {

            for (int currentIndex = indexOfFirst; currentIndex < (indexOfFirst + interval); currentIndex++) {
                insertionSort(array, currentIndex, indexOfLast, interval);
            }
            interval /= 2;
        }
    }

    private <T extends Comparable<? super T>>
    void insertionSort(T[] array, int currentIndex, int indexOfLast, int interval) {
        int indexOfUnsorted, index;

        for (indexOfUnsorted = currentIndex + interval; indexOfUnsorted <= indexOfLast; indexOfUnsorted += interval) {
            T nextToSort = array[indexOfUnsorted];
            index = indexOfUnsorted - interval;
            while ((index >= currentIndex) && (nextToSort.compareTo(array[index]) < 0)){
                comparisons++;
                array[index + interval] = array[index];
                index -= interval;
            }
            array[index + interval] = nextToSort;

            if(index >= currentIndex) {
                comparisons++;
            }
        }
    }

}