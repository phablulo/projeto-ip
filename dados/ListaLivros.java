import java.util.NoSuchElementException;
class Celula {
	private Celula proximo;
	private Livro livro;

	public Celula (Livro livro) {
		this.setLivro(livro);
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
	public Celula getProximo() {
		return this.proximo;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Livro getLivro() {
		return this.livro;
	}
	public Boolean equals(Livro to) {
		return this.livro.getId().equals(to.getId());
	}
	public Boolean equals(String id) {
		return this.livro.getId().equals(id);
	}
	public Boolean equals(Celula to) {
		return this.livro.getId().equals(to.getLivro().getId());
	}
}

public class ListaLivros implements livrosRepositorio{
	private Celula primeiro;
	private Celula ultimo;

	public void adicionaLivro(Livro livro) throws IllegalArgumentException { //throws LivroJaCadastradoException {
		if (this.procuraLivro(livro) != null) {
			throw new IllegalArgumentException("Livro ja foi cadastrado no repositorio"); //throw new LivroJaCadastradoException();
		}
		Celula celula = new Celula(livro);
		if (this.ultimo != null) {
			this.ultimo.setProximo(celula);
			this.ultimo = celula;
		} else {
			this.primeiro = celula;
			this.ultimo = celula;
		}
	}

	private Celula procuraCelula(String nome) {
		Celula atual = this.primeiro;
		while (atual != null && !atual.equals(nome)) {
			atual = atual.getProximo();
		}
		return atual;
	}
	public Livro procuraLivro(String nome) {
		Celula celula = this.procuraCelula(nome);
		if (celula == null) {
			return null;
		}
		return celula.getLivro();
	}
	public Livro procuraLivro(Livro livro) {
		return this.procuraLivro(livro.getId());
	}

	public void removeLivro(String id) {
		Celula atual = this.primeiro;
		if (atual != null) {
			if (atual.equals(id)) {
				this.primeiro = atual.getProximo();
				if (this.primeiro == null) {
					this.ultimo = null;
				}
			} else {
				boolean encontrou = false;
				Celula proximo = atual.getProximo();
				while (proximo != null && !encontrou) {
					if (proximo.equals(id)) {
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
	public void removeLivro(Livro livro) {
		this.removeLivro(livro.getId());
	}

	public void atualizaListaLivros(String id, Livro livro) throws NoSuchElementException {
		Celula celula = this.procuraCelula(id);
		if (celula == null) {
			throw new NoSuchElementException("Nenhum livro cadastrado com este id.");
		}
		celula.setLivro(livro);
	}
}