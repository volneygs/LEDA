package roteiro08.r08;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		list = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (element != null) {

			if (isFull()) {
				throw new StackOverflowException();
			} else {
				list.insertFirst(element);
			}

		}

	}

	@Override
	public T pop() throws StackUnderflowException {

		if (isEmpty()) {
			throw new StackUnderflowException();
		}

		T[] array = list.toArray();
		T element = array[0];
		list.remove(element);
		
		return element;
	}

	@Override
	public T top() {

		if (isEmpty()) {
			return null;
		}

		T[] array = list.toArray();
		return array[0];
	}

	@Override
	public boolean isEmpty() {

		return (this.list.size() == 0);
	}

	@Override
	public boolean isFull() {
		return (this.size == list.size());
	}

}
