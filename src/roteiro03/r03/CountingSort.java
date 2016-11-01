package roteiro03.r03;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure evitar desperdicio de 
 * memoria alocando o array de contadores com o tamanho sendo o máximo inteiro presente no array 
 * a ser ordenado.  
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {
		
		if (array.length <= leftIndex)
			return;

		int maximo = encontraMaximoArray(array, leftIndex, rightIndex);

		Integer[] c = new Integer[maximo + 1];

		inicializaArray(c, 0);
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			c[array[i]]++;	
		}

		for (int i = 1; i < c.length; i++) {
			c[i] = c[i - 1] + c[i];
		}

		Integer[] b = new Integer[rightIndex - leftIndex + 1];

		inicializaArray(b, 0);

		for (int i = rightIndex; i >= leftIndex; i--) {
			b[c[array[i]] - 1] = array[i];
			c[array[i]]--;
		}

		for (int i = 0; i < b.length; i++) {
			array[leftIndex + i] = b[i];
		}
	}

	private int encontraMaximoArray(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}
	
	private void inicializaArray(Integer[] array, int elemento) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
		
}

