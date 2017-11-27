package dados;
import exceptions.FuncionarioNaoEncontradoException;
import exceptions.FuncionarioJaCadastradoException;
import livraria.Funcionario;

public interface RepositorioFuncionarios {
	void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException;
	Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
	void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
}
