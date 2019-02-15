package Sorting;

import utils.Generator;

import java.util.Arrays;
import java.util.Random;

public class BucketSortDriver {

    public static void run() {
        System.out.println("Bucket sort/n");

        int[] array = Generator.generateRandomArray(100);
        int[] unsorted = array.clone();
        int[] sorted = bucketSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(sorted[i] + " : " + unsorted[i]);
        }
    }

    private static int[] bucketSort(int[] array) {
        // Check size to see if sorting is possible
        if (array.length == 0 || array.length == 1) {
            System.out.println("Array does not have a minimum of 2 values so there is nothing to sort");
            return new int[0];
        }

        // Find lowest & highest values
        int high = array[0];
        int low = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            // Check if current index value is lowest or highest
            int value = array[i];
            if (value < low) low = value; // New low found
            else if (value > high) high = value; // New high found
        }

        // Create array with range from low to max
        int[] turfArray = new int[(high - low) + 1]; // 20 - 10 = 10, so size needs to be 11. Because 10 to 20 contains 11 chars (0,1,2,3,4,5,6,7,8,9,10)
        Arrays.fill(turfArray, 0);

        // Turf values
        for (int i : array) {
            int turfIndex = i - low; // Index to add turf
            turfArray[turfIndex]++;
        }

        // Sort original array
        int indexOfOriginal = 0;
        for (int i = 0; i < turfArray.length; i++) { // Iterate turf array
            int turfAmount = turfArray[i]; // Amount of turfs on this index
            if (turfAmount > 0) Arrays.fill(array, indexOfOriginal, indexOfOriginal + turfAmount, i + low);
            indexOfOriginal += turfAmount;
        }

        return array;
    }

}
