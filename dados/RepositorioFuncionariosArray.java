package dados;

import livraria.Funcionario;
import exceptions.FuncionarioNaoEncontradoException;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	// private int index; removido por ser denecessario: o tamanho o dinamico

	public RepositorioFuncionariosArray() {// removido argumento porque o tamanho o dinamico
		this.funcionarios = new Funcionario[0];
		// this.index = 0;
	}

	// troquei o argumento pra string (o cpf ao inv�s do objeto funcionario)
	public int getIndex(String cpf) {
		int resultado = -1;
		boolean encontrado = false;
		for(int i = 0; i < this.funcionarios.length && !encontrado; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				resultado = i;
				encontrado = true; // adicionada condicao de parada quando encontrar o funcionario
			}
		}
		return resultado;
	}
	// Permitir sobrescrever sem excecao?
	// 		Nao. Cria um novo array contendo todos os funcionarios
	// 		reescrevi todo o metodo. Olha as diferencas no historico do git.
	public void inserir(Funcionario funcionario) {
		int length = this.funcionarios.length;
		Funcionario[] arr = new Funcionario[length + 1];
		int i;
		for (i = 0; i < length; ++i) {
			arr[i] = this.funcionarios[i];
		}
		arr[i] = funcionario;
		this.funcionarios = arr;
	}
	// aqui ia dar erro. Estava escrito assim:
	// public Funcionario procurar(String cpf) {
	//	Funcionario resultado = this.procurar(cpf);
	//	...
	// }
	// o que ia levar a um loop infinito.
	// Tambem reescrevi o metodo completamente
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(cpf);
		if (index == -1) {
			throw new FuncionarioNaoEncontradoException();
		}
		return this.funcionarios[index];
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario.getCpf());
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.funcionarios[index] = funcionario;
		}
	}

	/*E necessario acrescentar throws na assinatura uma vez que ja esteja presente no metodo de busca quando ele for chamado?
		- É se voce nao tratar ela dentro desse metodo.
	colocar funcionarios[index].remover(funcionarios.procurar(cpf));*/
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario.getCpf());
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			// continuar corrigindo os indices
			int length = this.funcionarios.length;
			Funcionario[] aux1 = new Funcionario[length - 1]; // nao eh `- index`, eh `- 1`
			for(int i = 0; i < length-1; i++) {
				if(i == index) {
					continue;
					// okay, colocar i++ aqui daria uns bug estranho, alem de um ArrayIndexOutOfBoudsException na linha seguinte.
					// `continue` eh o que voce queria fazer.
				}
				aux1[i] = funcionarios[i];
			}
			this.funcionarios = aux1;
		}
	}
}