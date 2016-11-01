package roteiro10.r10;


import roteiro10.util.Util;

public abstract class AbstractHashtableOpenAddress<T extends Storable> extends
		AbstractHashtable<T> {

	protected final DELETED deletedElement = new DELETED();
	private int tableSize;

	public AbstractHashtableOpenAddress(int size) {
		this.tableSize = size;
	}

	@Override
	protected void initiateInternalTable(int size) {
		this.table = Util.<Storable> makeArray(size);
	}
}
