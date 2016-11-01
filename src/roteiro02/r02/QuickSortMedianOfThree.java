package roteiro02.r02;

import roteiro02.util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que funciona 
 * de forma ligeiramente diferente. Relembre que quando o pivô escolhido divide o 
 * array aproximadamente na metade, o QuickSort tem um desempenho perto do ótimo. 
 * Para aproximar a entrada do caso ótimo, diversas abordagens podem ser utilizadas. 
 * Uma delas é usar a mediana de 3 para achar o pivô. Essa técnica consiste no seguinte:
 * 1.	Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2.	Ordenar os elemento, tal que: A[left] < A[center] < A[right].
 * 3.	Adotar o A[center] como pivô.
 * 4.	Colocar o pivô na penúltima posição A[right-1].
 * 5.	Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6.	Aplicar o algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T>{
    
	public void sort(T[] array, int leftIndex, int rightIndex){
		
		if (leftIndex < rightIndex && leftIndex >= 0){
			
			medianaDeTres(array, leftIndex, rightIndex);
			Util.swap(array, (leftIndex + rightIndex) / 2, rightIndex - 1);
			
			int PosicaoPivot = partition(array, leftIndex + 1, rightIndex - 1);
			
			sort(array, leftIndex, PosicaoPivot - 1);
			sort(array, PosicaoPivot + 1, rightIndex);

		}
	}
	
	private void medianaDeTres(T[] array, int left, int right){
		
		int meio = (right + left) / 2;
		int menorIndice = left;
		
		if (array[right].compareTo(array[menorIndice]) < 0)
			menorIndice = right;
		
		if (array[meio].compareTo(array[menorIndice]) < 0)
			menorIndice = meio;
		
		Util.swap(array, left, menorIndice);
		
		if(array[meio].compareTo(array[right]) > 0)
			Util.swap(array, meio, right);
	}
		
	
	
	private int partition(T[] array, int left, int right){
		
		int PosicaoPivot = right;
		T pivo = array[right];
		
		for (int j = right - 1; j >= left; j--) {
			
			if (array[j].compareTo(pivo) > 0){
				PosicaoPivot--;
				Util.swap(array, PosicaoPivot, j);
			}
		}
		Util.swap(array, right, PosicaoPivot);
		
		return PosicaoPivot;
	}
}
