package Searching;

public class RecursiveBinarySearch {

    public static void run() {
        System.out.println("Recursive binary search\n");

        int[] array = new int[] {0, 2, 5, 7, 9, 12, 36, 54};
        int index = indexOf(array, 54, 0, array.length - 1);
        System.out.println("Element found at index: " + index);
    }

    private static int indexOf(int[] array, int element, int left, int right) {
        int middle = (left + right) / 2;

        if(element == array[middle]) return middle; // Found
        else if(element < array[middle]) return indexOf(array, element, left, middle - 1); // To the left
        else if(element > array[middle]) return indexOf(array, element, middle + 1, right); // To the right
        else return -1; // Not found
    }

}
