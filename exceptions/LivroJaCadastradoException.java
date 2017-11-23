package exceptions;

public class LivroJaCadastradoException extends Exception {
	public LivroJaCadastradoException(String message) {
		super(message);
	}
	public LivroJaCadastradoException() {
		super("Livro ja foi cadastrado no repositorio");
	}
}
