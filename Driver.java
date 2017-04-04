//Jose Mora
// CS 241
//Project 2

package maxHeap;
import java.util.*;

public class Driver {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		maxHeap heap1 = new maxHeap(100);
		maxHeap heap2 = new maxHeap(100);
	
		System.out.println("Please select how to test the program: ");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
		System.out.print("Enter choice: ");
			
		int choice = s.nextInt();
		
		if(choice == 1){ //Choose 20 random integers
			for(int i = 0; i < 20; i++){ //i = number of sets of integers
				heap1 = new maxHeap(100); //create new heaps each iteration 
				heap2 = new maxHeap(100);
				Integer[] arr = new Integer[100]; // make new array to fill heap with
			    for (int x = 0; x < arr.length; x++) {
			        arr[x] = 1 + x; // fill array with numbers 1-100
			    }
			    Collections.shuffle(Arrays.asList(arr)); //shuffle array
			    
				for (int j = 0; j < arr.length; j++) { //add shuffled array values to both heaps
				        heap1.add(arr[j]);
				        heap2.addc(arr[j]);
				    }
				 for (int rootIndex = 100 / 2; rootIndex > 0; rootIndex--){ //reheap heap 2 using optimal method
						heap2.reheap(rootIndex);
					}
			}
		     System.out.println("\nAverage swaps for series of insertions: " + maxHeap.addSwaps / 20); //print add swap average
		     System.out.println("Average swaps for optimal method: " + maxHeap.reheapSwaps / 20 ); //print reheap swap average
		}
		
		if(choice == 2){ //Choose fixed integers
			 for( int i = 1; i <= 100; i++){ //add numbers 1-100 to both heaps
				 heap1.add(i); 
				 heap2.addc(i);
			 }
			for (int rootIndex = 100 / 2; rootIndex > 0; rootIndex--){
				heap2.reheap(rootIndex); //reheap using optimal method
			}
			System.out.print("\nHeap built using optimal method: "); 
			heap2.print(); //prints first 10 
			System.out.println("\nNumber of swaps: " + maxHeap.reheapSwaps);
			for(int i = 0; i < 10; i++){
				heap2.removeMax(); //removes first 10
			}
			System.out.print("Heap after 10 removals: ");
			heap2.print();
			
			System.out.print("\nHeap built using insertions: ");
			heap1.print(); //print heap using insertions
			System.out.println("\nNumber of swaps: " + maxHeap.addSwaps);
			for(int j = 0; j < 10; j++){
				heap1.removeMax(); //remove the 10 highest integers
			}
			System.out.print("Heap after 10 removals: ");
			heap1.print();  //print heap after the removals
			System.out.println();
			
			}
	} 
}
