public interface ClienteRepositorio {
	public void adicionaCliente(Cliente cliente) throws IllegalArgumentException;
	public Cliente procuraCliente(String cpf);
	public Cliente procuraCliente(Cliente cliente);
	public void removeCliente(String cpf);
	public void removeCliente(Cliente cliente);
}
