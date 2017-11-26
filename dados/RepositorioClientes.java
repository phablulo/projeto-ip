package dados;
import exceptions.*;
import livraria.Cliente;

public interface RepositorioClientes {
	public void adicionaCliente(Cliente cliente) throws ClienteJaCadastradoException;
	public Cliente procuraCliente(String cpf) throws ClienteNaoEncontradoException;
	public Cliente procuraCliente(Cliente cliente) throws ClienteNaoEncontradoException;
	public void removeCliente(String cpf) throws ClienteNaoEncontradoException;
	public void removeCliente(Cliente cliente) throws ClienteNaoEncontradoException;
	public void atualizaCliente(String cpf, Cliente cliente) throws ClienteNaoEncontradoException;
}
