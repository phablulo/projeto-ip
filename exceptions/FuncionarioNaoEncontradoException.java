package exceptions;

public class FuncionarioNaoEncontradoException extends Exception {
	public FuncionarioNaoEncontradoException(String message) {
		super(message);
	}
	public FuncionarioNaoEncontradoException() {
		super("Funcionário não encontrado");
	}
}