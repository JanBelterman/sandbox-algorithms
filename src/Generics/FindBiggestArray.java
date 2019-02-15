package Generics;

public class FindBiggestArray {

    public static void run() {
        System.out.println("Generic method find biggest array\n");

        Integer[][] sumArrayArray = new Integer[5][5];
        sumArrayArray[0] = new Integer[]{1, 4, 5, 5, 5};
        sumArrayArray[1] = new Integer[]{1, 4, 5, 5, 5};
        sumArrayArray[2] = new Integer[]{0, 4, 5, 5, 5};
        sumArrayArray[3] = new Integer[]{4, 4, 5, 5, 5};
        sumArrayArray[4] = new Integer[]{1, 4, 5, 5, 5};
        int biggestSum = getRowWithBiggestSum(sumArrayArray);
        System.out.println(biggestSum);
    }

    // Initializing begin values of algorithms
    // If there are only negative values int the arrays, than result will always be 0.
    // To prevent this: set initial sum to the sum of the first array
    private static <T extends Number> int getRowWithBiggestSum(T[][] array) {
        int rowTotal = 0;
        int biggestRowTotal = 0;

        for(T[] numberArray : array) {
            // Calculate sum of this array
            for(T number : numberArray) {
                rowTotal += number.intValue();
            }
            // New biggest row total?
            if (rowTotal > biggestRowTotal) biggestRowTotal = rowTotal;
            rowTotal = 0; // Reset row total

        }

        return biggestRowTotal;
    }

}
