package dados;
import livraria.Livro;

public interface RepositorioLivros {
	public void adicionaLivro(Livro livro);
	public Livro procuraLivro(String nome);
	public Livro procuraLivro(Livro livro);
	public void removeLivro(String nome);
	public void atualizaLivro(String nome, Livro livro);
}
