package roteiro10.r10;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {
	
	private int size;

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
		
		this.size = size;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			
			int i = 0;
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);

			while (i < size) {

				if (table[key] == null || deletedElement.equals(table[key])) {
					
					table[key] = element;
					elements += 1;
					return;

				} else {
					
					i += 1;
					key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);
					COLLISIONS += 1;
				}
			}

			throw new HashtableOverflowException();

		}
	}

	@Override
	public void remove(T element) {

		if (element != null) {

			int i = 0;
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);

			while (i < size) {
				
				if (table[key]!= null && element.equals(table[key])) {
					
					elements -= 1;
					
					if (i > 0) {
						
						COLLISIONS -= 1;
					}
				
					table[key] = new DELETED();
				
					return;
					
				}else{

					i += 1;
					key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);
				}
			}
		}
	}

	@Override
	public T search(T element) {

		if (element != null) {
			
			int i = 0;
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);

			while (i < size) {

				if (table[key] != null && element.equals(table[key])) {
					
					return (T)table[key];
					
				} else {
					
					i += 1;
					key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);
				}
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		
		if (element != null) {
		
			int i = 0;
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);

			while (i < size) {

				if (element.equals(table[key])) {
					
					return key;
					
				} else {
					
					i += 1;
					key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, i);
				}
			}
		}
		
		return -1;
	}

}
