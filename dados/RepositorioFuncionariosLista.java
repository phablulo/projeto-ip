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
	
	public void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException {
		if(this.funcionario == null) {
			this.funcionario = funcionario;
			this.next = new RepositorioFuncionariosLista();
		} else if(this.funcionario != null && this.funcionario.equals(funcinario.getCpf())) {
			throw new FuncionarioJaCadastradoException();
		} else {
			this.next.inserir(funcionario);
		}
	}
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		if(this.funcionario != null && this.funcionario.equals(cpf)) {
			return  this.funcionario;
		} else if(this.funcionario == null) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			return this.next.procurar(cpf);
		}
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.funcionario != null && this.funcionario.equals(funcionario.getCpf())) {
			this.funcionario = funcionario;
		} else if(this.funcionario == null && !(this.funcionario.equals(funcionario.getCpf()))) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.next.atualizar(funcionario);
		}
	}
	//Se não funcionar (info hiding), atribuir o Funcionario retornado por uma busca a this.funcionario
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.funcionario != null && this.funcionario.equals(funcionario.getCpf())) {
			this.funcionario = this.next.funcionario.getFuncionanrio();
			this.next = this.next.next;
		} else if(this.funcionario == null) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.next.remover(funcionario);
		}
	}
}
