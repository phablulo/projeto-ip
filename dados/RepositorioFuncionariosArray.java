package dados;

import livraria.Funcionario;
import exceptions.FuncionarioNaoEncontradoException;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	// private int index; removido por ser denecessário: o tamanho é dinâmico

	public RepositorioFuncionariosArray() {// removido argumento porque o tamanho é dinâmico
		this.funcionarios = new Funcionario[0];
		// this.index = 0;
	}

	// troquei o argumento pra string (o cpf ao invés do objeto funcionario)
	public int getIndex(String cpf) {
		int resultado = -1;
		boolean encontrado = false;
		int length = this.funcionarios.length;
		for(int i = 0; i < length && !encontrado; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				resultado = i;
				encontrado = true; // adicionada condicao de parada quando encontrar o funcionário
			}
		}
		return resultado;
	}
	// Permitir sobrescrever sem excecao?
	// 		Não. Cria um novo array contendo todos os funcionarios
	// 		reescrevi todo o método. Olha as diferenças no histórico do git.
	public void inserir(Funcionario funcionario) {
		int length = this.funcionarios.length;
		Functionario[] arr = new Functionario(length + 1);
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
	// Também reescrevi o método completamente
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
		- é se você não tratar ela dentro desse método.
	colocar funcionarios[index].remover(funcionarios.procurar(cpf));*/
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario.getCpf());
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			// continuar corrigindo os indices
			int length = this.funcionarios.length;
			Funcionario[] aux1 = new Funcionario[length - 1]; // não é `- index`, é `- 1`
			for(int i = 0; i < length; i++) {
				if(i == index) {
					continue;
					// okay, colocar i++ aqui daria uns bug estranho, além de um ArrayIndexOutOfBoudsException na linha seguinte.
					// `continue` é o que você queria fazer.
				}
				aux1[i] = funcionarios[i];
			}
			this.funcionarios = aux1;
		}
	}
}