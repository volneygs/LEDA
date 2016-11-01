package roteiro04.r04;

/**
 * The combsort algoritm. 
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
		
		if (array != null && array.length > 1 && leftIndex < rightIndex){
			
			int intervaloTroca = rightIndex - leftIndex + 1;
			int swaps = 0;
			
			while (intervaloTroca > 1 || swaps == 0) {
			
				if (intervaloTroca > 1) {
					intervaloTroca = (int) (intervaloTroca / 1.3);
				}
				
				swaps = 1;
				
				for (int i = leftIndex; i + intervaloTroca <= rightIndex; i++) {
					if (array[i].compareTo(array[i + intervaloTroca]) > 0) {
						roteiro04.util.Util.swap(array, i, i+ intervaloTroca);
						swaps = 0;
					}
				}
			}	
		}
	}
}
