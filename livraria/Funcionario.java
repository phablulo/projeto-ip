package livraria;

public class Funcionario extends Pessoa {
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
		return new Funcionario(super.getNome(), super.getCpf(), this.cargo, super.getDataNasc(), super.getEndereco());
	}
	public boolean equals(Funcionario funcionario) {
		return super.getCpf().equals(funcionario.getCpf());
	}
	public void atualizar(Funcionario funcionario) {	
		super.atualizar(funcionario);
		this.cargo = funcionario.getCargo();
	}
}
