package Searching;

import utils.Generator;

public class BinarySearch {

    public static void run() {
        System.out.println("Binary search\n");

        int[] array = Generator.generateRandomArray(100);

        long startTime = System.nanoTime();
        int amountOfExecutions = 100;
        for(int i = 0; i < amountOfExecutions; i++) {
            int index = binarySearch(array, 54);
            System.out.println("Found element at index: " + index);
        }

        long runtime = ((System.nanoTime() - startTime) / 1000000) / amountOfExecutions;
        System.out.println("Execution time of binary search in ms: " + runtime);
    }

    private static int binarySearch(int[] array, int element) {
        int left = 0, right = array.length - 1;

        while(left <= right) {
            int middle = left + (right - 1) / 2;

            if (array[middle] == element) {
                return middle;
            }

            if (array[middle] < element) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return -1;
    }

}
