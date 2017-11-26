package dados;
import exceptions.*;
import livraria.Cliente;

class CCelula {
	private CCelula proximo;
	private Cliente cliente;

	public CCelula (Cliente cliente) {
		this.setCliente(cliente);
	}
	public void setProximo(CCelula proximo) {
		this.proximo = proximo;
	}
	public CCelula getProximo() {
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
	public Boolean equals(CCelula to) {
		return this.cliente.getCpf().equals(to.getCliente().getCpf());
	}
}

public class RepositorioClientesLista implements RepositorioClientes{
	private CCelula primeiro;
	private CCelula ultimo;

	public void adicionaCliente(Cliente cliente) throws ClienteJaCadastradoException {
		try {
			this.procuraCliente(cliente);
			throw new ClienteJaCadastradoException();
		} catch(ClienteNaoEncontradoException e) {
			CCelula celula = new CCelula(cliente);
			if (this.ultimo != null) {
				this.ultimo.setProximo(celula);
				this.ultimo = celula;
			} else {
				this.primeiro = celula;
				this.ultimo = celula;
			}
		}
	}

	private CCelula procuraCCelula(String cpf) throws ClienteNaoEncontradoException {
		CCelula atual = this.primeiro;
		while (atual != null && !atual.equals(cpf)) {
			atual = atual.getProximo();
		}
		if (atual == null) {
			throw new ClienteNaoEncontradoException();
		}
		return atual;
	}
	public Cliente procuraCliente(String cpf) throws ClienteNaoEncontradoException {
		CCelula celula = this.procuraCCelula(cpf);
		if (celula == null) {
			return null;
		}
		return celula.getCliente();
	}
	public Cliente procuraCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		return this.procuraCliente(cliente.getCpf());
	}

	public void removeCliente(String cpf) throws ClienteNaoEncontradoException {
		CCelula atual = this.primeiro;
		if (atual != null) {
			if (atual.equals(cpf)) {
				this.primeiro = atual.getProximo();
				if (this.primeiro == null) {
					this.ultimo = null;
				}
			} else {
				boolean encontrou = false;
				CCelula proximo = atual.getProximo();
				while (proximo != null && !encontrou) {
					if (proximo.equals(cpf)) {
						atual.setProximo(proximo.getProximo());
						encontrou = true;
					} else {
						atual = proximo;
						proximo = proximo.getProximo();
					}
				}
				if (!encontrou) {
					throw new ClienteNaoEncontradoException();
				}
			}
		}
	}
	public void removeCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		this.removeCliente(cliente.getCpf());
	}

	public void atualizaCliente(String cpf, Cliente cliente) throws ClienteNaoEncontradoException {
		CCelula celula = this.procuraCCelula(cpf);
		celula.setCliente(cliente);
	}
}
