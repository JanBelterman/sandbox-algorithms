package utils;

import java.util.Arrays;
import java.util.Random;

public class Generator {

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(size) + 1;
        }
        Arrays.sort(array);
        return array;
    }

}
