package BenchMarkApp;

import java.util.Arrays;
import java.util.InputMismatchException;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class AlgoBenchmarkApp {

	private static Scanner in;
	
	public static void bubbleSort(int[] array) {
		
		int temp;
		for (int i=0; i<array.length; i++) {
			for (int j=1; j<(array.length-i); j++) {
				if (array[j-1]>array[j]) {
					temp = array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array) {
		
		for (int i=0; i<array.length; i++) {
			int index = i;
			for (int j=i+1; j<array.length; j++) {
				if (array[j] < array[index])
					index = j;
			}
			int smallerNumber = array[index];
			array[index] = array[i];
			array[i] = smallerNumber;
		}
	}
	
	public static void insertionSort(int[] array) {
		
        for (int j = 1; j < (array.length-1); j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            }else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    @SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] list) {
         
    	if (list.length <= 1) 
    		return list;
 
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
         
        mergeSort(first);
        mergeSort(second);
         
        merge(first, second, list);
        
        return list;
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        
        if (arr == null || arr.length == 0) {
            return;
        }
         
        if (low >= high) {
            return;
        }
 
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
 
        int i = low, j = high;
        while (i <= j) {
            
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high); 
    }
    
    private static void heapify(int i, int[] data, int size) {
        
        int largestElementIndex = i;

        int leftChildIndex = (2*i+1);
        if (leftChildIndex < size && data[leftChildIndex] > data[largestElementIndex]) 
            largestElementIndex = leftChildIndex;

        int rightChildIndex = (2*i+2);
        if (rightChildIndex < size && data[rightChildIndex] > data[largestElementIndex])
            largestElementIndex = rightChildIndex;
        
        if (largestElementIndex != i) {
            int swap = data[i];
            data[i] = data[largestElementIndex];
            data[largestElementIndex] = swap;

            heapify(largestElementIndex, data, size);
        }
    }

    public static void heapSort(int data[]) {
        
        int size = data.length;
  
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(i, data, size);

        for(int i=data.length-1;i>=0;i--){
            int temp = data[0];
            data[0]=data[i];
            data[i]=temp;

            size  = size-1;

            heapify(0, data, size);
        }
    }
        
    public static void complexityBubbleSort(int[] array) {
    	
    	long start = System.currentTimeMillis();
		bubbleSort(array);
		long end = System.currentTimeMillis();
		System.out.println("\nBubble Sort is completed in "+(end-start)+" ms.");
    }
    
    public static void complexitySelectionSort(int[] array) {
    	
    	long start = System.currentTimeMillis();
		selectionSort(array);
		long end = System.currentTimeMillis();
		System.out.println("\nSelection Sort is completed in "+(end-start)+" ms.");
    }
    
    public static void complexityInsertionSort(int[] array) {
    	
    	long start = System.currentTimeMillis();
		insertionSort(array);
		long end = System.currentTimeMillis();
		System.out.println("\nInsertion Sort is completed in "+(end-start)+" ms.");
    }
    
    public static void complexityMergeSort(int[] array) {
    	
    	long start = System.currentTimeMillis();
		Integer[] array1 = Arrays.stream( array ).boxed().toArray( Integer[]::new );
		mergeSort(array1);
		long end = System.currentTimeMillis();
		System.out.println("\nMerge Sort is completed in "+(end-start)+" ms.");
    }
	
    public static void complexityQuickSort(int[] array) {
    	
    	long start = System.currentTimeMillis();
		quickSort(array,0,array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("\nQuick Sort is completed in "+(end-start)+" ms.");
    }
    
    public static void complexityHeapSort(int[] array) {
        long start = System.currentTimeMillis();
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println("\nHeap Sort is completed in "+(end-start)+" ms.");
    }    	
    	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		System.out.println("\nWelcome to MyAlgoBenchmarkApp.");
		System.out.println("******************************");
		
		System.out.println("\nEnter the size of Array :");
		int sizeOfArray;
		while (true) {
			try {
				sizeOfArray = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not the Character :");
				in.nextLine();
				continue;
			} 
		}
		
		int[] array = new int[sizeOfArray];
		
		System.out.println("\nChoose Complexity");
		System.out.println("-----------------");
		System.out.println(" 1. Best Case  ");
		System.out.println(" 2. Average Case");
		System.out.println(" 3. Worst Case");
		System.out.println("-----------------");
		
		int choice;
		System.out.println("\nEnter the Case No. :");
		while (true) {
			try {
				choice = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not the Character :");
				in.nextLine();
				continue;
			} 
		}
		
		switch(choice){
		
			case 1 :for(int i = 0;i<array.length;i++)
						array[i] = i+1;
					System.out.println("\nArray of Size "+sizeOfArray+" is generated for Best Case Scenario.");
					break;
					
			case 2 :for(int i=0;i<array.length;i++)
						array[i] = (int)(Math.random()*1000);
					System.out.println("\nArray of Size "+sizeOfArray+" is generated for Average Case Scenario.");
					break;
					
			case 3 :for(int i = 0;i<array.length;i++)
						array[i] = array.length-i;
					System.out.println("\nArray of Size "+sizeOfArray+" is generated for Worst Case Scenario.");
					break;
					
			default :System.out.println("\nWrong Case...Please Choose The Number between 1 to 3 :");
		}
		
		System.out.println("\n  Choose Algorithm");
		System.out.println("--------------------");
		System.out.println(" 1. Bubble Sort");
		System.out.println(" 2. Selection Sort");
		System.out.println(" 3. Insertion Sort");
		System.out.println(" 4. Merge Sort");
		System.out.println(" 5. Quick Sort");
		System.out.println(" 6. Heap Sort");
		System.out.println(" 7. Benchmark All");
		System.out.println(" 8. Start Over");
		System.out.println(" 9. Exit");
		System.out.println("--------------------");
		
		System.out.println("\nEnter The No. Of Algorithm :");
		int ch;
		while (true) {
			try {
				ch = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not the Character :");
				in.nextLine();
				continue;
			} 
		}
		
		switch(ch) {
		
				case 1 :complexityBubbleSort(array.clone());
						break;
						
				case 2 :complexitySelectionSort(array.clone());
						break;
						
				case 3 :complexityInsertionSort(array.clone());
						break;
						
				case 4 :complexityMergeSort(array.clone());
						break;
						
				case 5 :complexityQuickSort(array.clone());
						break;
						
				case 6 :complexityHeapSort(array.clone());
						break;
						
				case 7 :complexityBubbleSort(array.clone());
						complexitySelectionSort(array.clone());
						complexityInsertionSort(array.clone());
						complexityMergeSort(array.clone());
						complexityQuickSort(array.clone());
						complexityHeapSort(array.clone());
						break;
						
				case 8 :main(args);
				
				case 9 :System.out.println("\n\nThanks for using MyAlgoBenchmarkApp.");
						System.out.println("************************************");
						System.exit(0);
						
				default:System.out.println("\nWrong Choice...Please Enter a Number between 1 to 9 :");
		}    
	}

}
