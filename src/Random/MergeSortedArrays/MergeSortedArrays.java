package Random.MergeSortedArrays;

public class MergeSortedArrays {

    public static void run() {
        System.out.println("Merge sorted arrays/n");

        int[] array1 = new int[]{0, 2, 4, 7, 8, 10, 12, 45, 99, 111};
        int[] array2 = new int[]{5, 45, 67, 70, 71, 71, 89, 99, 1001, 10001, 10002};

        int[] merged = merge(array1, array2);

        for(int n : merged) {
            System.out.println(n);
        }
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];

        int index2 = 0;
        int indexMerge = 0;

        for(int number1 : array1) {
            int number2 = array2[index2];
            while(number2 <= number1) {
                mergedArray[indexMerge] = number2;
                index2++;
                indexMerge++;
                number2 = array2[index2];
            }
            mergedArray[indexMerge] = number1;
            indexMerge++;
        }
        for(int i = index2; i < array2.length; i++, indexMerge++) {
            mergedArray[indexMerge] = array2[i];
        }

        return mergedArray;
    }

}
