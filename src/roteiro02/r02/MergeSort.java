package roteiro02.r02;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm.  
 * The algorithm consists of recursively dividing the unsorted list in the middle,
 * sorting each sublist, and then merging them into one single sorted list.
 * Notice that if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
	
		
		if(leftIndex < rightIndex){
			
			int meio = (rightIndex + leftIndex) / 2;
			
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			
			merge(array, leftIndex, meio, rightIndex);
		}
		
	}

	public void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		
		T[] aux = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		
		int indexAux = 0;
		int firstRigh = meio - leftIndex + 1;
		int firstLeft = leftIndex;
		
		while(indexAux <= meio - leftIndex && firstRigh <= rightIndex - leftIndex){
		
			if(aux[indexAux].compareTo(aux[firstRigh]) < 0){
				
				array[firstLeft] = aux[indexAux];
				indexAux++;
				
			}else{
				
				array[firstLeft] = aux[firstRigh];
				firstRigh++;
			}
			
			firstLeft++;
			
		}
		
		while(indexAux <= meio - leftIndex){
			
			array[firstLeft] = aux[indexAux];
			firstLeft++;
			indexAux++;
		}
		
		while(firstRigh <= rightIndex - leftIndex){
			
			array[firstLeft] = aux[firstRigh];
			firstRigh++;
			firstLeft++;
		}
				
	}

}
