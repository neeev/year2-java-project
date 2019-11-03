public class ShellSortArray {
    public static <T extends Comparable<? super T>>
    void shellSort(T[] array, int arraySize)
    {
        shellSort(array, 0, arraySize-1);
    }

    private static <T extends Comparable<? super T>>
    void shellSort(T[] array, int indexOfFirst, int indexOfLast) {
        int arraySize = indexOfLast - indexOfFirst + 1;
        int interval = arraySize/2;

        while (interval > 0) {

            for (int currentIndex = indexOfFirst; currentIndex < (indexOfFirst + interval); currentIndex++) {
                insertionSort(array, currentIndex, indexOfLast, interval);
                ArrayUtil.displayArrayContent(array);
            }
            interval /= 2;
        }
    }

    private static <T extends Comparable<? super T>>
    void insertionSort(T[] array, int currentIndex, int indexOfLast, int interval) {
        int indexOfUnsorted, index;

        for (indexOfUnsorted = currentIndex + interval; indexOfUnsorted <= indexOfLast; indexOfUnsorted += interval) {
            T nextToSort = array[indexOfUnsorted];
            index = indexOfUnsorted - interval;
            while ((index >= currentIndex) && (nextToSort.compareTo(array[index]) < 0)){
                array[index + interval] = array[index];
                index -= interval;
            }
            array[index + interval] = nextToSort;
        }
    }
}
