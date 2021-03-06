package roteiro01.r01;

import roteiro01.util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSortRecursivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	
		
		int menor;
		
		for(int i = leftIndex; i < rightIndex; i++){
			
			menor = i;
			
			for(int j = i; j <= rightIndex; j++){
				
				if(array[j].compareTo(array[menor]) < 0){
					
					menor = j;
				}							
			}
			
			Util.swap(array, i, menor);
		}
	}
	
}