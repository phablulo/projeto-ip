package dados;
import livraria.Funcionario;
import exceptions.FuncionarioNaoEncontradoException;
import exceptions.FuncionarioJaCadastradoException;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;

	public RepositorioFuncionariosArray() {
		this.funcionarios = new Funcionario[0];
	}

	public int getIndex(String cpf) {
		int resultado = -1;
		boolean encontrado = false;
		for(int i = 0; i < this.funcionarios.length && !encontrado; i++) {
			if(this.funcionarios[i].equals(cpf)) {
				resultado = i;
				encontrado = true;
			}
		}
		return resultado;
	}
	
	public void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException {
		if(this.getIndex(funcionario.getCpf()) != -1){
			throw new FuncionarioJaCadastradoException();
		} else {
			int length = this.funcionarios.length;
			Funcionario[] arr = new Funcionario[length + 1];
			int i;
			for(i = 0; i < length; ++i){
				arr[i] = this.funcionarios[i];
			}
			arr[i] = funcionario;
			this.funcionarios = arr;
		}
	}
	
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(cpf);
		if (index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			return this.funcionarios[index];
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario.getCpf());
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.funcionarios[index] = funcionario;
		}
	}

	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int index = this.getIndex(funcionario.getCpf());
		if(index == -1) {
			throw new FuncionarioNaoEncontradoException();
		} else {
			int length = this.funcionarios.length;
			Funcionario[] aux = new Funcionario[length - 1];
			for(int i = 0; i < index; i++) {
				aux[i] = funcionarios[i];
			}
			for(int i = index; i < length - 1; i++) {
				aux[i] = funcionarios[i + 1];
			}
			this.funcionarios = new Funcionario[length - 1];
			this.funcionarios = aux;
		}
	}
}
