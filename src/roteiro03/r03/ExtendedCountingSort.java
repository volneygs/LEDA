package roteiro03.r03;

/**
 * Classe que implementa do Counting Sort vista em sala. 
 * Desta vez este algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex){
			
			int maximo = encontraMaximoArray(array, leftIndex, rightIndex);
			int minimo = encontrarMinimoArray(array, leftIndex, rightIndex);
			
			Integer[] arrayOrdenado = new Integer[array.length];
			int tamanhoContador = maximo - minimo + 1;
			Integer[] c = new Integer[tamanhoContador];
			
			inicializaArray(c, 0);
			
			for(Integer integer : array){
				
				c[integer - minimo] += 1;
			}
			
			for(int i = 1; i < c.length; i++){
				
				c[i] += c[i-1];
			}
			
			for(Integer integer : array){
				
				int indiceOrdenado = c[integer - minimo] - 1;
				
				arrayOrdenado[indiceOrdenado] = integer;
				c[integer - minimo] -= 1;
				
			}
			
			for(int i = 0; i< arrayOrdenado.length; i++){
				array[i] = arrayOrdenado[i];
			}
		}

		
		
	}

	private int encontrarMinimoArray(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];
		
		for(int i = leftIndex; i <= rightIndex; i++){
			if(array[i] < min){
				min = array[i];
			}
		}
		
		return min;
	}

	private int encontraMaximoArray(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
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
