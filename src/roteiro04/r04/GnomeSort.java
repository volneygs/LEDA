package roteiro04.r04;

/**
 * The implementation of the algorithm must be in-place! 
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T>{
	
	public void sort(T[] array,int leftIndex, int rightIndex){
		
		if (array != null && array.length > 1 && leftIndex < rightIndex) {
			
			int pivot = leftIndex + 1;
			
			while (pivot <= rightIndex) {
				
				if (array[pivot-1].compareTo(array[pivot]) > 0) {
					roteiro04.util.Util.swap(array, pivot-1, pivot);
					if (pivot > 1) {
						pivot -= 1;
					}else{
						pivot += 1;
					}
				}else{
					pivot += 1;
				}
			}
			
		}
	}
}
