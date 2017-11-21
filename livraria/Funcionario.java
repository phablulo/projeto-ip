package livraria;

public class Funcionario extends Pessoa {
	///*Omitir atributos herdados?
	/*private String nome;
	private String cpf;
	private String datanasc;
	private String endereco;*/
	private String cargo;
	
	
	public Funcionario(String nome, String cpf, String cargo) {
		super(nome, cpf);
		this.cargo = cargo;
	}
	public Funcionario(String nome, String cpf, String cargo, String datanasc, String endereco) {
		super(nome, cpf, datanasc, endereco);
		this.cargo = cargo;
	}

	public String getNome() {
		return super.getNome();
	}
	public String getCpf() {
		return super.getCpf();
	}
	public String getCargo() {
		return this.cargo;
	}
	public String getDataNasc() {
		return super.getDataNasc();
	}
	public String getEndereco() {
		return super.getEndereco();
	}
	public Funcionario getFuncionario() {
		return new Funcionario(this.nome, this.cpf, this.cargo, this.datanasc, this.endereco);
	}
	public void atualizar(Funcionario funcionario) {	
		super.setNome(funcionario.getNome());
		super.setCpf(funcionario.getCpf());
		super.setDataNasc(funcionario.getDataNasc());
		super.setEndereco(funcionario.getEndereco());
		this.cargo = funcionario.getCargo();
	}
	/*Obsoleto. Impróprio para herança
	public void atualizar(Funcionario funcionario) {	
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.datanasc = funcionario.getDataNasc();
		this.endereco = funcionario.getEndereco();
		this.cargo = funcionario.getCargo();
	}*/
	
	//TODO: fazer um método genérico para getters e setters em Pessoa
	/*public void getFuncionario() {
		super.getPessoa();	
	}*/
	public Livro procurarLivro(String nome) {
		super.procurarLivro(nome);
	}
	super.procurarLivro(String autor);
}
