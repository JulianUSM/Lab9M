package Lab9;

/**
 * @author Jere Perisic
 * @version November 27, 2023
 */
public class HeapSort {
    /**
     * constructor
     */
    public HeapSort(){

    }
    /**
     * This method takes in an array on integers and sort them using heap-sort
     * @param input array of integer items
     * @return sorted array
     */

    public static int[] sort(int[]input)
    {
        int n = input.length;
        MaxHeap maxHeap = new MaxHeap(input);

        for (int i = n - 1; i >= 0 ; i--) {
            int temp = maxHeap.delete();
            input[i] = temp;
        }
        return input;
    }
}
