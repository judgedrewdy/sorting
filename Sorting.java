import java.util.Random;

public class Sorting {

	public static void main(String[] args) {
		Random rand = new Random();
		
		final int ARRAY_SIZE = 100;
		
		int[] randomArray = new int[ARRAY_SIZE];
		
		for (int i = 0; i < ARRAY_SIZE; i++) {
			randomArray[i] = rand.nextInt(1000) + 1;
			System.out.print(randomArray[i] + " ");
		}
		
		System.out.println();
		
		int[] finalArray = new int[ARRAY_SIZE];
		
		finalArray = mergeSort(randomArray, 0, ARRAY_SIZE - 1);
		
		for (int i = 0; i < ARRAY_SIZE; i++) {
			System.out.print(finalArray[i] + " ");
		}
	}
	
	public static int[] selectionSort(int[] unsortedArray) {
		
		int[] sortedArray = new int[unsortedArray.length];
		for (int i = 0; i < unsortedArray.length; ++i) {
	
			   // Find index of smallest remaining element
			   int indexSmallest = i;
			   for (int j = i + 1; j < unsortedArray.length; ++j) {
	
			      if (unsortedArray[j] < unsortedArray[indexSmallest]) {
			         indexSmallest = j;
			      }
			   }
	
			   // Swap numbers[i] and numbers[indexSmallest]
			   int temp = unsortedArray[i];
			   unsortedArray[i] = unsortedArray[indexSmallest];
			   sortedArray[i] = unsortedArray[i];
			   unsortedArray[indexSmallest] = temp;
			}
		return sortedArray;
	}
	
	public static int[] insertionSort(int[] unsortedArray) {
		int[] sortedArray = new int[unsortedArray.length];
		
		for (int i = 1; i < unsortedArray.length; ++i) {
			  int j = i;
			  // Insert numbers[i] into sorted part
			  // stopping once numbers[i] in correct position
			  while (j > 0 && unsortedArray[j] < unsortedArray[j - 1]) {
			   
			     // Swap numbers[j] and numbers[j - 1]
			     int temp = unsortedArray[j];
			     unsortedArray[j] = unsortedArray[j - 1];
			     sortedArray[j] = unsortedArray[j - 1];
			     
			     unsortedArray[j - 1] = temp;
			     sortedArray[j - 1] = temp;
			    		 
			     --j;
			  }
			  
			  
		}
		
		return sortedArray;
	}
	public static int partition(int [] numbers, int i, int k) {
		int l;
		int h;
		int midpoint;
		int pivot;
		int temp;
		boolean done;

		      /* Pick middle element as pivot */
		      midpoint = i + (k - i) / 2;
		      pivot = numbers[midpoint];

		      done = false;
		      l = i;
		      h = k;

		      while (!done) {
		         /* Increment l while numbers[l] < pivot */
		         while (numbers[l] < pivot) {
		            ++l;
		         }

		         /* Decrement h while pivot < numbers[h] */
		         while (pivot < numbers[h]) {
		            --h;
		         }

		         /* If there are zero or one items remaining,
		            all numbers are partitioned. Return h */
		         if (l >= h) {
		            done = true;
		         } 
		         else {
		            /* Swap numbers[l] and numbers[h],
		               update l and h */
		            temp = numbers[l];
		            numbers[l] = numbers[h];
		            numbers[h] = temp;

		            ++l;
		            --h;
		         }
		      }

		      return h;
		   }

	public static int[] quicksort(int [] numbers, int i, int k) {
		      int j;
		      int[] sortedArray = new int[k + 1];

		      /* Base case: If there are 1 or zero entries to sort,
		       partition is already sorted */
		      if (i >= k) {
		    	  sortedArray = numbers;
			      return sortedArray;
		      }

		      /* Partition the data within the array. Value j returned
		         from partitioning is location of last item in low partition. */
		      j = partition(numbers, i, k);

		      /* Recursively sort low partition (i to j) and
		         high partition (j + 1 to k) */
		      quicksort(numbers, i, j);
		      quicksort(numbers, j + 1, k);
		      sortedArray = numbers;
		      return sortedArray;
		      
		      
	}
		   
		   public static void merge(int [] numbers, int i, int j, int k) {
		      int mergedSize = k - i + 1;       // Size of merged partition
		      int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
		      int mergePos;                     // Position to insert merged number
		      int leftPos;                      // Position of elements in left partition
		      int rightPos;                     // Position of elements in right partition

		      mergePos = 0;
		      leftPos = i;                      // Initialize left partition position
		      rightPos = j + 1;                 // Initialize right partition position

		      // Add smallest element from left or right partition to merged numbers
		      while (leftPos <= j && rightPos <= k) {
		         if (numbers[leftPos] < numbers[rightPos]) {
		            mergedNumbers[mergePos] = numbers[leftPos];
		            ++leftPos;
		         } 
		         else {
		            mergedNumbers[mergePos] = numbers[rightPos];
		            ++rightPos;
		         }
		         ++mergePos;
		      }

		      // If left partition is not empty, add remaining elements to merged numbers
		      while (leftPos <= j) {
		         mergedNumbers[mergePos] = numbers[leftPos];
		         ++leftPos;
		         ++mergePos;
		      }

		      // If right partition is not empty, add remaining elements to merged numbers
		      while (rightPos <= k) {
		         mergedNumbers[mergePos] = numbers[rightPos];
		         ++rightPos;
		         ++mergePos;
		      }

		      // Copy merge number back to numbers
		      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
		         numbers[i + mergePos] = mergedNumbers[mergePos];
		      }
		   }

		   public static int[] mergeSort(int [] numbers, int i, int k) {
		      int j;
		      int[] sortedArray = new int[k];
		      if (i < k) {
		         j = (i + k) / 2;  // Find the midpoint in the partition

		         // Recursively sort left and right partitions
		         mergeSort(numbers, i, j);
		         mergeSort(numbers, j + 1, k);

		         // Merge left and right partition in sorted order
		         merge(numbers, i, j, k);
		         sortedArray = numbers;
		         return sortedArray;
		      }
		      return numbers;
		   }   
}