package exceptions;

public class LivroNaoEncontradoException extends Exception {
	public LivroNaoEncontradoException(String message) {
		super(message);
	}
	public LivroNaoEncontradoException() {
		super("Nenhum livro cadastrado com este id.");
	}
}
