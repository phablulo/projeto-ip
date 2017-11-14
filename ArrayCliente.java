public class ArrayCliente implements ClienteRepositorio {
	private Cliente[] clientes;

	public ArrayCliente (){
		this.clientes = new Cliente[0];
	}
	public void adicionaCliente(Cliente cliente) throws IllegalArgumentException {
		if (this.procuraCliente(cliente) != null) {
			throw new IllegalArgumentException("Cliente já existe no repositório");
		}
		Cliente[] novo_arr = new Cliente[this.clientes.length+1];
		for (int i = 0; i < this.clientes.length; ++i) {
			novo_arr[i] = this.clientes[i];
		}
		novo_arr[this.clientes.length] = cliente;
		this.clientes = novo_arr;
	}
	public Cliente procuraCliente(String cpf) {
		Cliente encontrado = null;
		for (int i = 0; i < this.clientes.length && encontrado == null; ++i) {
			if (this.clientes[i].getCpf().equals(cpf)) {
				encontrado = this.clientes[i];
			}
		}
		return encontrado;
	}
	public Cliente procuraCliente(Cliente cliente) {
		return this.procuraCliente(cliente.getCpf());
	}
	public void removeCliente(String cpf) {
		int index = -1;
		for (int i = 0; i < this.clientes.length && index == -1; ++i) {
			if (this.clientes[i].getCpf().equals(cpf)) {
				index = i;
			}
		}
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
}
