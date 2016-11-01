package roteiro08.r08;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		previous = null;
	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {

			RecursiveDoubleLinkedListImpl<T> novoNo = new RecursiveDoubleLinkedListImpl<>(this.getData(),
					this.getNext(), this);
			this.setNext(novoNo);
			this.setData(element);

		}

	}

	@Override
	public void insert(T element) {

		if (isEmpty()) {

			RecursiveDoubleLinkedListImpl<T> nextAux = new RecursiveDoubleLinkedListImpl<T>(null, null, this);

			this.setData(element);
			this.setNext(nextAux);			

		} else {

			next.insert(element);
		}

	}
		
	@Override
	public void remove(T element) {
		
		if (isEmpty() || element == null) {
			return;

		} else {

			if (data.equals(element) && this.getNext().isEmpty()) {
				
				this.setData(null);
				
			}else if(data.equals(element)){
				setData(this.getNext().getData());
				setNext(this.getNext().getNext());
				
				((RecursiveDoubleLinkedListImpl<T>)this.getNext()).setPrevious(this);
				
			} else {
				this.getNext().remove(element);
			}
		}
	}	
	
	@Override
	public void removeFirst() {

		if (isEmpty()) {
			return;
		} else {

			if (this.getPrevious() == null && this.getNext().isEmpty()) {
				this.setData(null);
				
			} else {
				
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}

	}

	@Override
	public void removeLast() {

		if (isEmpty()) {
			return;
		} else {
			 if ((this.getNext()).isEmpty()) {
				
				 this.setData(null);
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(null);
				
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
