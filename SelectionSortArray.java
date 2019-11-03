public class SelectionSortArray {

    public static <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int n)
    {
        selectionSort(arr, 0, n-1);
    }

    private static <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int first, int last) {
        for (int index = first; index < last; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(arr, index, last);
            swap(arr, index, indexOfNextSmallest);
            ArrayUtil.displayArrayContent(arr);
        }
    }

    private static <T extends Comparable<? super T>>
    int getIndexOfSmallest(T[] arr, int first, int last) {
        T minVal = arr[first];
        int indexMin = first;

        for (int index = first + 1; index <= last; index++) {
            if (arr[index].compareTo(minVal) < 0) {
                minVal = arr[index];
                indexMin = index;
            }
        }
        return indexMin;
    }

    private static <T>
    void swap(T[] arr, int from, int to) {
        T temp = arr[from];

        arr[from] = arr[to];
        arr[to] = temp;
    }

}
