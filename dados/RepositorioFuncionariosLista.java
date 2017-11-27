package dados;
import livraria.Funcionario;
import exceptions.FuncionarioNaoEncontradoException;
import exceptions.FuncionarioJaCadastradoException;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private RepositorioFuncionariosLista next;
	
	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.next = null;
	}
	
	public void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(this.funcionario == null) {
			this.funcionario = funcionario;
			this.next = new RepositorioFuncionariosLista();
		} else if(this.funcionario != null && this.funcionario.equals(funcinario.getCpf())){
			throw new FuncionarioJaCadastradoException();
		} else {
			this.next.inserir(funcionario);
		}
	}
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		if(this.funcionario != null && this.funcionario.getCpf().equals(cpf)) {
			return  this.funcionario;
		} else if(this.funcionario == null && !(this.funcionario.getCpf().equals(cpf))) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			return this.next.procurar(cpf);
		}
	}
	
	//Evitar redundancia de excecoes? 
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.funcionario != null && this.funcionario.getCpf().equals(funcionario.getCpf())) {
			this.funcionario = funcionario;
		} else if(this.funcionario == null && !(this.funcionario.getCpf().equals(funcionario.getCpf()))) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.next.atualizar(funcionario);
		}
	}
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.next != null && this.next.funcionario.getCpf().equals(funcionario.getCpf())) {
			//this.next.funcionario = this.next.next.funcionario;
			this.next = this.next.next;
		} else if(this.next == null && !(this.next.funcionario.getCpf().equals(funcionario.getCpf()))) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.next.atualizar(funcionario);
		}
	}
}
