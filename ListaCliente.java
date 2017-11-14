import java.util.NoSuchElementException;
class Celula {
	private Celula proximo;
	private Cliente cliente;

	public Celula (Cliente cliente) {
		this.setCliente(cliente);
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
	public Celula getProximo() {
		return this.proximo;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public Boolean equals(Cliente to) {
		return this.cliente.getCpf().equals(to.getCpf());
	}
	public Boolean equals(String cpf) {
		return this.cliente.getCpf().equals(cpf);
	}
	public Boolean equals(Celula to) {
		return this.cliente.getCpf().equals(to.getCliente().getCpf());
	}
}

public class ListaCliente implements ClienteRepositorio{
	private Celula primeiro;
	private Celula ultimo;

	public void adicionaCliente(Cliente cliente) throws IllegalArgumentException {
		if (this.procuraCliente(cliente) != null) {
			throw new IllegalArgumentException("Cliente já existe no repositório");
		}
		Celula celula = new Celula(cliente);
		if (this.ultimo != null) {
			this.ultimo.setProximo(celula);
			this.ultimo = celula;
		} else {
			this.primeiro = celula;
			this.ultimo = celula;
		}
	}

	private Celula procuraCelula(String cpf) {
		Celula atual = this.primeiro;
		while (atual != null && !atual.equals(cpf)) {
			atual = atual.getProximo();
		}
		return atual;
	}
	public Cliente procuraCliente(String cpf) {
		Celula celula = this.procuraCelula(cpf);
		if (celula == null) {
			return null;
		}
		return celula.getCliente();
	}
	public Cliente procuraCliente(Cliente cliente) {
		return this.procuraCliente(cliente.getCpf());
	}

	public void removeCliente(String cpf) {
		Celula atual = this.primeiro;
		if (atual != null) {
			if (atual.equals(cpf)) {
				this.primeiro = atual.getProximo();
				if (this.primeiro == null) {
					this.ultimo = null;
				}
			} else {
				boolean encontrou = false;
				Celula proximo = atual.getProximo();
				while (proximo != null && !encontrou) {
					if (proximo.equals(cpf)) {
						atual.setProximo(proximo.getProximo());
						encontrou = true;
					} else {
						atual = proximo;
						proximo = proximo.getProximo();
					}
				}
			}
		}
	}
	public void removeCliente(Cliente cliente) {
		this.removeCliente(cliente.getCpf());
	}

	public void atualizaCliente(String cpf, Cliente cliente) throws NoSuchElementException {
		Celula celula = this.procuraCelula(cpf);
		if (celula == null) {
			throw new NoSuchElementException("Nenhum cliente cadastrado com este cpf");
		}
		celula.setCliente(cliente);
	}
}
