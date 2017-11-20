public class RepositorioLivrosArray implements livrosRepositorio {
	private Livro[] livro;
	
	public RepositorioLivrosArray(int tamanho) {
		livro = new Livro[0];
	}
	public void adicionaLivro(Livro livro) {
		if ((this.procuraLivro(nome) != null)) {
			throw new LivroJaCadastradoException();
		}
		Livro[] novo_array = new Livro[this.livro.lenght+1];
		for (int i = 0; i < this.livro.lenght+1; i++) {
			novo_array = this.livro[i];
		}
		novo_array[this.livro.lenght] = livro;
		this.livro = novo_array;
		
	}

	public Livro procuraLivro(String nome) {
		int ind = this.getPos(nome);
		if (ind == -1) {
			return null;
		} 	
		return this.livro[ind];
	}

	public Livro procuraLivro(Livro livro) {
		return this;procuraLivro(livro.getId());
	}

	private int getPos(String nome) {
		int ind = -1;
		for (int i = 0; i < this.livro.lenght && ind == -1; i++) {
			if (this.livro[i].getNome().equals(nome)) {
				ind = i;
			}
		}
		return ind;
	}
	private void removeLivro(String id) {
		int ind = this.getPos(nome);
		if (ind == -1) {
			Livro[]novo_array = new Livro[this.livro.lenght-1];
			for(int i = 0; i < ind; i++) {
				novo_array[i] = this.livro[i];
			}	
			for(int i = ind + 1; i < this.livro.lenght; i++) {
				novo_array = this.livro[i];
			}
		}
	}

	public void removeLivro(Livro livro) {
		this.removeLivro(livro.getId());
	}

	public void atualizaListalivro(String id, Livro livro) throws LivroNaoCadastradoException {
		int i = this.getPos(nome);
		if (i == -1) {
			throw new LivroNaoCadastradoException();
		}
		this.livro[i] = livro;
	}	
}

