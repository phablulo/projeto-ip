package exceptions;

public class ClienteJaCadastradoException extends Exception {
	public ClienteJaCadastradoException(String message) {
		super(message);
	}
	public ClienteJaCadastradoException() {
		super("Cliente ja cadastrado");
	}
}
