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
	abstract void atualizarPessoa();
	/*public Pessoa getPessoa() {
		return new Pessoa(this.nome, this.cpf, this.datanasc, this.endereco);
	}*/
}