package livraria;

/* 1.0 - Verificar se deve ser usado interface ou depender da classe abstrata Pessoa 
 * para implementar inserir, atualizar, remover e procurar. (Improv�vel, porque cada
 * subclasse de Pessoa deve implementar suas pr�prias exce��es).
 * 1.1 - Proceder a definir m�todos abstratos e m�todos identicos entre as subclasses.*/

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