package maxHeap;
import java.util.Arrays;

public class maxHeap {
	private int[] heap;
	private int lastIndex,newIndex, parentIndex;
	public static int reheapSwaps = 0;
	public static int addSwaps = 0;
	
	public maxHeap(int initialCapacity){
		heap = new int[initialCapacity+1];
		lastIndex = 0;
	}

	public void add(int element){ //method to add for regular insertions
		lastIndex++; //increment the last index of the array
		ensureCapacity();
		newIndex = lastIndex;  //set index of newly added element to its new index
		parentIndex = newIndex/2;
		while(parentIndex > 0 && element > heap[parentIndex]){ //while the element is larger than its parent
			addSwaps++; //increment number of swaps
			heap[newIndex] = heap[parentIndex]; //swap parent value with child value
			newIndex = parentIndex; //swap parent index with child index
			parentIndex = newIndex/2;
		}
		heap[newIndex] = element; 
	}
	
	public void addc(int num){ //adds integers to heap array
		ensureCapacity();
		heap[lastIndex] = num;
		lastIndex++;
	}
	
	public void reheap(int rootIndex){ //optimal method
		boolean done = false;
		int orphan = heap[rootIndex]; 
		int leftChildIndex = 2* rootIndex;
		while(!done && (leftChildIndex <= lastIndex)){ //while left child position is less than the last position
			reheapSwaps++; //add number of swaps
			int largerChildIndex = leftChildIndex; //assume left child is larger
			int rightChildIndex = leftChildIndex + 1;
			
			if((rightChildIndex <= lastIndex) && heap[rightChildIndex] > heap[largerChildIndex]) { //if right child is larger than left child
				largerChildIndex = rightChildIndex; //larger child is right
			}
			
			if(orphan < heap[largerChildIndex]){ //if root is less then the larger child 
				heap[rootIndex] = heap[largerChildIndex]; //swap
				rootIndex = largerChildIndex;
				leftChildIndex = 2*rootIndex;
			} else {
				done = true;
			}
			heap[rootIndex] = orphan;		
		}
	}
	
	public void ensureCapacity(){ //assure there is enough space to add values
		if(lastIndex >= heap.length){
			int newCapacity = 2*heap.length;
			heap = Arrays.copyOf(heap, newCapacity);
		}
	}
	
	public int removeMax(){ //removes max value of heap
		int root = 0;
		if(!(lastIndex < 1)){
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}
	
	public void print(){ //prints out first 10 values of heap
		for (int index = 1; index <= 10; index++){
			System.out.print(heap[index] + ",");
		}
	}

}
