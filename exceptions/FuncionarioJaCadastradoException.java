package exceptions;

public class FuncionarioJaCadastradoException extends Exception{
	public FuncionarioJaCadastradoException(){
		super("Funcionario ja cadastrado.");
	}
	public FuncionarioJaCadastradoException(String message){
		super(message);
	}
}
