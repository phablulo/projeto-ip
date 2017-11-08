import Livro;

abstract class Pessoa {
	private String nome;
	private String cpf;
	private String idade;

	private boolean calotero;

	public Livro[] procura(String nome);
}