package Recursion.Permutations;

public class Permutations {

    public static void run() {
        int[] arr = new int[]{1, 2, 3};
        permuteHelper(arr, 0);
    }

    private static void permuteHelper(int[] arr, int index){
        // Finished
        if (index >= arr.length - 1) {
            System.out.print("[");
            // Print all except last
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + ", ");
            }
            // Print last
            if (arr.length > 0) System.out.print(arr[arr.length - 1]);
            System.out.println("]");
            return;
        }

        // Permute
        for (int i = index; i < arr.length; i++) {
            // Swap
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
            // Continue with swapped array, with cloning there would be no need to swap back
            permuteHelper(arr, index+1);
            // Swap back for next iteration
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

}
