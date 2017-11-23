package dados;
import java.util.NoSuchElementException;
public class RepositorioClienteArray implements ClienteRepositorio {
	private Cliente[] clientes;

	public RepositorioClienteArray (){
		this.clientes = new Cliente[0];
	}
	public void adicionaCliente(Cliente cliente) throws IllegalArgumentException {
		if (this.procuraCliente(cliente) != null) {
			throw new IllegalArgumentException("Cliente ja existe no repositorio");
		}
		Cliente[] novo_arr = new Cliente[this.clientes.length+1];
		for (int i = 0; i < this.clientes.length; ++i) {
			novo_arr[i] = this.clientes[i];
		}
		novo_arr[this.clientes.length] = cliente;
		this.clientes = novo_arr;
	}

	public int procuraClienteIndex(String cpf) {
		int index = -1;
		for (int i = 0; i < this.clientes.length && index == -1; ++i) {
			if (this.clientes[i].getCpf().equals(cpf)) {
				index = i;
			}
		}
		return index;
	}
	public Cliente procuraCliente(String cpf) {
		int index = this.procuraClienteIndex(cpf);
		if (index == -1) {
			return null;
		}
		return this.clientes[index];
	}
	public Cliente procuraCliente(Cliente cliente) {
		return this.procuraCliente(cliente.getCpf());
	}

	public void removeCliente(String cpf) {
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
	public void removeCliente(Cliente cliente) {
		this.removeCliente(cliente.getCpf());
	}

	public void atualizaCliente(String cpf, Cliente cliente) throws NoSuchElementException {
		int index = this.procuraClienteIndex(cpf);
		if (index == -1) {
			throw new NoSuchElementException("Nenhum cliente cadastrado com este cpf");
		}
		this.clientes[index] = cliente;
	}
}
