package livraria;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String datanasc;
	private String endereco;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Pessoa(String nome, String cpf, String datanasc, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getDataNasc() {
		return this.datanasc;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public void setEndereco(String endereco) { 
		this.endereco = endereco;
	}
	
	public void atualizar(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.datanasc = pessoa.getDataNasc();
		this.endereco = pessoa.getEndereco();
	}
	/*public void inserir(Pessoa pessoa) {

	}
	public Pessoa procurar(String cpf) {

	}
	public void atualizar(Pessoa pessoa) {

	}
	public void remover(Pessoa pessoa) {

	}*/
}