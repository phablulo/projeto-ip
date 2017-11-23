package exceptions;

public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException(String message) {
		super(message);
	}
	public ClienteNaoEncontradoException() {
		super("Cliente nao encontrado");
	}
}
