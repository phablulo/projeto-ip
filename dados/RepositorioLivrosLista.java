package dados;
import exceptions.LivroNaoEncontradoException;
import exceptions.LivroJaCadastradoException;

class LCelula {
	private LCelula proximo;
	private Livro livro;

	public LCelula (Livro livro) {
		this.setLivro(livro);
	}
	public void setProximo(LCelula proximo) {
		this.proximo = proximo;
	}
	public LCelula getProximo() {
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
	public Boolean equals(LCelula to) {
		return this.livro.getId().equals(to.getLivro().getId());
	}
}

public class RepositorioLivrosLista implements RepositorioLivros {
	private LCelula primeiro;
	private LCelula ultimo;

	public void adicionaLivro(Livro livro) throws LivroJaCadastradoException {
		if (this.procuraLivro(livro) != null) {
			throw new LivroJaCadastradoException();
		}
		LCelula celula = new LCelula(livro);
		if (this.ultimo != null) {
			this.ultimo.setProximo(celula);
			this.ultimo = celula;
		} else {
			this.primeiro = celula;
			this.ultimo = celula;
		}
	}

	private LCelula procuraLCelula(String nome) {
		LCelula atual = this.primeiro;
		while (atual != null && !atual.equals(nome)) {
			atual = atual.getProximo();
		}
		return atual;
	}
	public Livro procuraLivro(String nome) {
		LCelula celula = this.procuraLCelula(nome);
		if (celula == null) {
			return null;
		}
		return celula.getLivro();
	}
	public Livro procuraLivro(Livro livro) {
		return this.procuraLivro(livro.getId());
	}

	public void removeLivro(String id) {
		LCelula atual = this.primeiro;
		if (atual != null) {
			if (atual.equals(id)) {
				this.primeiro = atual.getProximo();
				if (this.primeiro == null) {
					this.ultimo = null;
				}
			} else {
				boolean encontrou = false;
				LCelula proximo = atual.getProximo();
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

	public void atualizaListaLivros(String id, Livro livro) throws LivroNaoEncontradoException {
		LCelula celula = this.procuraLCelula(id);
		if (celula == null) {
			throw new LivroNaoEncontradoException();
		}
		celula.setLivro(livro);
	}
}