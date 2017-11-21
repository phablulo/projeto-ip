package dados;

import livraria.Funcionario;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	private int index;
	
	public RepositorioFuncionariosArray(int size) {
		this.funcionarios = new Funcionario[size];
		this.index = 0;
	}
	
	public int getIndex(Funcionario funcionario) {
		int resultado = -1;
		for(int i = 0; i < this.index; i++) {
			if(this.funcionarios[i].getCpf().equals(funcionario.getCpf())) {
				resultado = i;
				i = this.index;
			}
		}
		return resultado;
	}
	//Permitir sobrescrever sem excecao?
	public void inserir(Funcionario funcionario) {
		this.funcionarios[index] = funcionario;
		this.index++;
	}
	public Funcionario procurar(String cpf) {
		Funcionario resultado = this.procurar(cpf);
		for(int i = 0; i < this.index; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				resultado = this.funcionarios[index];
			}
		}
		if(resultado == null) {
			throw new FuncionarioNaoEncontradoException;
		}
		return resultado;	
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario);
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException;
		} else {
			this.funcionarios[index] = funcionario;			
		}
	}
	
	/*E necessario acrescentar throws na assinatura uma vez que ja esteja presente no metodo de busca quando ele for chamado?
	colocar funcionarios[index].remover(funcionarios.procurar(cpf));*/
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario);
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException;
		} else {
			//continuar corrigindo os indices
			Funcionario[] aux1 = new Funcionario[this.index - index];
			for(int i = index; i < this.index; i++) {
				aux1[i] = funcionarios[i];
			}
			this.funcionarios[index];
			/*if(this.index < this.funcionarios.length) {
				
			} else {
				
			}*/
		}
	}
}
