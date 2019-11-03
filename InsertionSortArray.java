public class InsertionSortArray {

    public static <T extends Comparable<? super T>>
    void insertionSort(T[] array, int arraySize)
    {
        insertionSort(array, 0, (arraySize - 1));
    }

    private static <T extends Comparable<? super T>>
    void insertionSort(T[] array, int indexOfFirst, int indexOfLast) {

        T currentItem;

        for (int currentIndex = (indexOfFirst + 1); currentIndex <= indexOfLast; currentIndex++) {
            currentItem = array[currentIndex];
            insertInOrder(currentItem, array, indexOfFirst, (currentIndex - 1));
            ArrayUtil.displayArrayContent(array);
        }
    }

    private static <T extends Comparable<? super T>>
    void insertInOrder(T currentItem, T[] array, int indexOfFirst, int indexOfPrevious) {
        int currentIndex = indexOfPrevious;

        // while the current index (beginning from the index of the item before the current item) is greater than or
        // equal to the index of the array's first item (0) AND the current item is less than the item at the current
        // index (i.e. if the item at index 5 is smaller than the item at index 4), then move the item at the current
        // index up into the next index (i.e. write over the current item), and reduce the current index by 1. The item
        // that was written over is saved in the currentItem variable, so it is not lost.
        while ((currentIndex >= indexOfFirst) && (currentItem.compareTo(array[currentIndex]) <= 0)) {
            array[currentIndex + 1] = array[currentIndex];
            currentIndex--;
        }
        // write over the array index 'indexOfPrevious' with the currentItem (i.e. the item at index 5 is now at index
        // 4, and the item at index 4 is now at 5.)
        array[currentIndex + 1] = currentItem;
    }
}
