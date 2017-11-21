package dados;

import livraria.Funcionario;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private RepositorioFuncionariosLista next;
	//private Funcionario resultado;
	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.next = null;
	}
	
	public void inserir(Funcionario funcionario) {
		if(this.funcionario == null) {
			this.funcionario = funcionario;
			next = new RepositorioFuncionariosLista();
		} else {
			this.next.inserir(funcionario);
		}
	}
	public Funcionario procurar(String cpf) {
		if(this.funcionario != null && funcionario.getCpf().equals(cpf)) {
			return  
		}
	}
}
