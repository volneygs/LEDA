package roteiro10.r10;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (size() == table.length) {
			throw new HashtableOverflowException();
		}
		
		int probi = 0;
		int hashKey = ((HashFunctionOpenAddress<T>) hashFunction).hash(element,
				probi);

		if (element != null) {
			while (probi != table.length - 1) {
				if (search(element) != null)
					break;
				if (table[hashKey] == null || table[hashKey] instanceof DELETED) {
					table[hashKey] = element;
					elements++;
				} else {
					probi++;
					hashKey = ((HashFunctionOpenAddress<T>) hashFunction).hash(
							element, probi);
					COLLISIONS++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (search(element) != null) {
				table[indexOf(element)] = new DELETED();
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (indexOf(element) != -1) {
				return element;
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if (element != null) {
			int probi = 0;
			int hashKey = ((HashFunctionOpenAddress<T>) hashFunction).hash(
					element, probi);
			while (probi != table.length - 1) {
				if (table[hashKey] == null) {
					return -1;
				}
				if (table[hashKey].equals(element)) {
					return hashKey;
				} else {
					probi++;
					hashKey = ((HashFunctionOpenAddress<T>)  hashFunction)
							.hash(element, probi);
				}
			}
		}
		return -1;
	}
}
