public class BubbleSortArray {
    public static <T extends Comparable<? super T>>
    void bubbleSort(T[] array, int arraySize)
    {
        bubbleSort(array, 0, arraySize-1);
    }

    private static <T extends Comparable<? super T>>
    void bubbleSort(T[] array, int indexOfFirst, int indexOfLast) {
        for (int i = indexOfFirst; i < indexOfLast; i++) {
            for (int currentIndex = indexOfFirst; currentIndex < (indexOfLast - i); currentIndex++) {
                if (array[currentIndex].compareTo(array[currentIndex + 1]) > 0) {
                    swap(array, currentIndex, (currentIndex + 1));
                }
                ArrayUtil.displayArrayContent(array);
            }
        }
    }

    private static <T>
    void swap(T[] array, int currentIndex, int indexOfSmaller) {
        T temp = array[currentIndex];

        array[currentIndex] = array[indexOfSmaller];
        array[indexOfSmaller] = temp;
    }

}
