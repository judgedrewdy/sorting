import java.util.Random;

public class Sort {

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
		
		finalArray = insertionSort(randomArray);
		
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
			     unsortedArray[j - 1] = temp;
			     --j;
			  }
			  
			}
		
		return sortedArray;
	}
}
