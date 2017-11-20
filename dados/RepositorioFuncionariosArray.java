package dados;

import livraria.Funcionario;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	private int index;
	
	public RepositorioFuncionariosArray(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
		this.index = 0;
	}
	//Permitir sobrescrever sem excecao?
	public void inserir(Funcionario funcionario) {
		this.funcionarios[index] = funcionario;
		this.index++;
	}
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario resultado = this.procurar(cpf);
		for(int i = 0; i < this.index; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				return this.funcionarios[index];
			}
		}
		if(resultado == null) {
			throw new FuncionarioNaoEncontradoException;
		}
	}
	/*� necess�rio acrescentar throws na assinatura uma vez que j� esteja presente no m�todo de busca quando ele for chamado?
	colocar funcionarios[index].remover(funcionarios.procurar(cpf)); no main*/
	//Manipular pela index, evitar confundir com c�pias;
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.index < this.funcionarios.length) {
			
		} else {
			this.funcionarios.remover();
		}
	}
}
