public class Cliente extends Pessoa {
	String nome;
	String cpf;
	String ClienteId;

	public Cliente(String nome, String cpf, String ClienteId) {
		this.nome = nome;
		this.cpf = cpf;
		this.ClienteId = ClienteId;

	public String getNome() {
		return this.nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public int getClienteId() {
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

