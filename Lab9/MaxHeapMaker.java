package Lab9;

/**
 *
 * @since 27 November 2023
 * @author Julian Edwards
 *
 */
public class MaxHeapMaker
{
    /**
     * This method takes in an array of integers and returns a max-heap 
     * @param input array of integer values
     * @return input as a max-heap
     */
    public static int[] heapify(final int[] input)
    {
        // Your code goes here
        boolean performedSwap;
        do {
            performedSwap = false;
            for(int i = input.length - 1; i >= 0; i--) {
                // execute from parent
                final int parentIndex = (i - 1) >> 1;
                if(outOfBounds(input, parentIndex)) continue;

                // children indexes
                final int leftIndex = (parentIndex << 1) + 1;
                final int rightIndex = (parentIndex << 1) + 2;

                // swap right element only if applicable, and if no left element is present
                if(outOfBounds(input, leftIndex)) {
                    if(!outOfBounds(input, rightIndex) && input[parentIndex] < input[rightIndex]) {
                        swap(input, parentIndex, rightIndex);
                        performedSwap = true;
                    }
                }

                // swap left element only if applicable, and if no right element is present
                else if(outOfBounds(input, rightIndex)) {
                    if(input[parentIndex] < input[leftIndex]) {
                        swap(input, parentIndex, leftIndex);
                        performedSwap = true;
                    }
                }

                // compare both children, and swap the greatest one if applicable
                else if(input[parentIndex] < input[leftIndex] || input[parentIndex] < input[rightIndex]) {
                    if(input[leftIndex] < input[rightIndex]) swap(input, parentIndex, rightIndex);
                    else swap(input, parentIndex, leftIndex);
                    performedSwap = true;
                }
            }
        }

        while(performedSwap);
        return input;
    }

    /**
     * @param a the array to check
     * @param index the index to check
     * @return checks if the provided index if out of the provided array's bounds.
     */
    private static boolean outOfBounds(final int[] a, final int index) {
        return a.length <= index || index < 0;
    }

    /**
     * Swaps the elements at the provided indexes.
     * @param a the array containing the elements to be swapped.
     * @param index1 the first index.
     * @param index2 the second index.
     */
    private static void swap(final int[] a, final int index1, final int index2) {
        final int i = a[index1];
        a[index1] = a[index2];
        a[index2] = i;
    }
}
