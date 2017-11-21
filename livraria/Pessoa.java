package livraria;

import dados.Livro;
/* 1.0 - Verificar se deve ser usado interface ou depender da classe abstrata Pessoa
 * para implementar inserir, atualizar, remover e procurar. (Improvavel, porque cada
 * subclasse de Pessoa deve implementar suas proprias excecoes, a menos que nao existe tal limitacao).
 * 1.1 - Proceder a definir tais metodos entre todas subclasses.*/

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String datanasc; //renomear para nascimento.
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
	
	abstract Livro procurarLivro(String nome); 
	
	public void atualizar(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.datanasc = pessoa.getDataNasc();
		this.endereco = pessoa.getEndereco();
	}
	//Vide 1.0
	/*public void inserir(Pessoa pessoa) {

	}
	public Pessoa procurar(String cpf) throws Pessoa {

	}
	public void atualizar(Pessoa pessoa) {

	}
	public void remover(Pessoa pessoa) {

	}*/

	//Save for later � if needed at all.
	/*public Pessoa getPessoa() {
		return new Pessoa(this.nome, this.cpf, this.datanasc, this.endereco);
	}*/
}