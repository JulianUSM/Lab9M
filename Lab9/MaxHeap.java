package Lab9;

public class MaxHeap {
    private int[] data;
    
    /**
     * @param data
     */
    public MaxHeap(int[]data)
    {
        this.setData(MaxHeapMaker.heapify(data));
    }
    
    /**
     * Remove the max value from the root of the tree while 
     * keeping the remaining the items as a max-heap
     * @return max value
     */
    public int delete()
    {
    	int maxValue = 0;
        
        // Store and remove the max value by replacing it with the last element
        maxValue = data[0];
        data[0] = data[data.length];
        data[data.length] = 0;

        int i = 0; // Iteration variable 
        while(data[i] < data[(2*i)+2] || data[i] < data[(2*i)+1]){
        	// Switch Right Child
        	if(data[(2*i)+2] > data[(2*i)+1]){
        		int temp = data[i];
        		data[i] = data[(2*i)+2];
        		data[(2*i)+2] = temp;
        		i = (2*i)+2;
        	}
        	// Switch Left Child
        	else if (data[(2*i)+1] > data[(2*i)+2]){
        		int temp = data[i];
        		data[i] = data[(2*i)+1];
        		data[(2*i)+1] = temp;
        		i = (2*i)+1;
        	}
        }
        
        return maxValue;
    }
    
    /**
     * Adds new item to the max-heap
     * @param newData the input value to be added to the max-heap
     */
    public void add(int newData)
    {
        // Your code goes here
    }

    /**
     * @return Returns the max-heap
     */
    public int[] getData() {
        return data;
    }

    /**
     * Note that you might to need to 
     * @param data set the array
     */
    public void setData(int[] data) {
        this.data = MaxHeapMaker.heapify(data);
    }
}
