package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = {5,2,9,0,5,2};
        showArray(arr);

        System.out.println("\nSorted array:");
        int[] out = countingSort(arr, 9);

        showArray(out);

    }

    /**
     * Sorts an array of integers using counting sort.
     * @param arr array to sort
     * @return sorted array
     */
    public static int[] countingSort(int[] arr) {
        // Initialize an array to store the count of each element in the input array.
        int[] count = new int[100];

        // Initialize an array to store the sorted output.
        int[] sorted = new int[arr.length];

        // Count the occurrences of each element in the input array and store in 'count'.
        for (int j : arr) {
            count[j]++;
        }

        // Update 'count' to store the cumulative count of elements up to each index.
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array by placing elements in their correct positions based on 'count'.
        for (int i = arr.length - 1; i >= 0; i--) {
            // Decrement the count of the current element in 'count' and use it as the index.
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return sorted;
    }

    public static int[] countingSort(int[]in, int k){
        int[] count = new int[k+1];
        int[] out = new int[in.length];
        int currItem;

        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        //Set counts of input
        for (int i = 0; i <= in.length-1; i++) {
            currItem = in[i];
            count[currItem]++;
        }

        //Adjust counts
        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i-1];
        }

        //Build output
        for (int i = in.length-1; i >= 0; i--) {
            currItem = in[i];
            count[currItem]--;
            out[count[currItem]] = currItem;

//            int outIndex = count[currItem];   same as line above
//            out[outIndex] = currItem;
        }
        return out;
    }
    public static void showArray(int[]a){
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}