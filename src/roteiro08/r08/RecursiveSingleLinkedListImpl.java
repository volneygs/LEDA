package roteiro08.r08;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		
		if (data == null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int size() {
		
		if (data == null) {
			return 0;
		} else {

			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		
		if (isEmpty()) {
			return null;
		} else {
			if (data.equals(element)) {
				return data;
			} else {
				return next.search(element);
			}

		}

	}

	@Override
	public void insert(T element) {
		
		if (isEmpty()) {
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<T>(null, null));

		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		
		if (isEmpty()) {
			return;

		} else {

			if (data.equals(element)) {
				setData(next.getData());
				setNext(next.getNext());
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		makeArray(array, this, 0);

		return array;

	}

	private void makeArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int indice) {

		if (!node.isEmpty()) {
			array[indice] = node.getData();
			makeArray(array, node.getNext(), indice + 1);
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
