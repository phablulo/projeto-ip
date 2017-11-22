package dados;

import exceptions.FuncionarioNaoEncontradoException;
import livraria.Funcionario;

/*Verificar se assinaturas com argumentos do tipo Pessoa seriam melhores ou mais adequadas para esta interface*/

public interface RepositorioFuncionarios {
	void inserir(Funcionario funcionario);
	Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
	void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
}
