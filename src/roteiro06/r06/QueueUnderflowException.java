package roteiro06.r06;

public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Fila vazia");
	}

}
