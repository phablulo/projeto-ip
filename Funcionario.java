
public class Funcionario extends Pessoa {
	String nome;
	String cpf;
	String cargo;
	String datanasc;
	String endereco;
	
	public Funcionario(String nome, String cpf, String cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
	}
	
	public void getPessoa() {
		super.getPessoa();	
	}
	public Livro procurarLivro(String nome) {
		super.procurarLivro(nome);
	}
	super.procurarLivro(String autor);
}
