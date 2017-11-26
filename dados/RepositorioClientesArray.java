package dados;
import exceptions.*;
import livraria.Cliente;

public class RepositorioClientesArray implements RepositorioClientes {
	private Cliente[] clientes;

	public RepositorioClientesArray (){
		this.clientes = new Cliente[0];
	}
	public void adicionaCliente(Cliente cliente) throws ClienteJaCadastradoException {
		if (this.procuraCliente(cliente) != null) {
			throw new ClienteJaCadastradoException();
		}
		Cliente[] novo_arr = new Cliente[this.clientes.length+1];
		for (int i = 0; i < this.clientes.length; ++i) {
			novo_arr[i] = this.clientes[i];
		}
		novo_arr[this.clientes.length] = cliente;
		this.clientes = novo_arr;
	}

	public int procuraClienteIndex(String cpf) throws ClienteNaoEncontradoException {
		int index = -1;
		for (int i = 0; i < this.clientes.length && index == -1; ++i) {
			if (this.clientes[i].getCpf().equals(cpf)) {
				index = i;
			}
		}
		return index;
	}
	public Cliente procuraCliente(String cpf) throws ClienteNaoEncontradoException {
		int index = this.procuraClienteIndex(cpf);
		if (index == -1) {
			return null;
		}
		return this.clientes[index];
	}
	public Cliente procuraCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		return this.procuraCliente(cliente.getCpf());
	}

	public void removeCliente(String cpf) throws ClienteNaoEncontradoException {
		int index = this.procuraClienteIndex(cpf);
		if (index != -1) {
			Cliente[] novo_array = new Cliente[this.clientes.length-1];
			for (int i = 0; i < index; ++i) {
				novo_array[i] = this.clientes[i];
			}
			for (int i = index+1; i < this.clientes.length; ++i) {
				novo_array[i] = this.clientes[i];
			}
		}
	}
	public void removeCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		this.removeCliente(cliente.getCpf());
	}

	public void atualizaCliente(String cpf, Cliente cliente) throws NoSuchElementException {
		int index = this.procuraClienteIndex(cpf);
		this.clientes[index] = cliente;
	}
}
