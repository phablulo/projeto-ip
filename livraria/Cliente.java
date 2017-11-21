public class Cliente extends Pessoa {
	String nome;
	String cpf;
	String ClienteId;
	
	/*Adequar os metodos e construtores a classe abstrata usando a keyword super.
	 * Reforcando, o uso de Ids pode nao ser tao interessante, cpf seria uma alternativa melhor e mais rápida para implementar.*/ 
	
	public Cliente(String nome, String cpf, String ClienteId) {
		this.nome = nome;
		this.cpf = cpf;
		this.ClienteId = ClienteId;
	}
	//Segundo construtor a ser implementado de acordo com a classe abstrata. Se necessario, observe como ficou a classe Funcionario.
	public Cliente(String nome, String cpf, String datanasc, String endereco) {
		
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getClienteId() {
		return this.ClienteId;
	}
 	public void setNome(String nome) {
 		this.nome = nome;
 	}
 	public void setCpf(String cpf) {
 		this.cpf = cpf;
	}
	public void setClienteId(String ClienteId) {
		this.ClienteId = ClienteId;
	}
}

