class Livro {
	private String id;
	private String nome;
	private String[] autor;
	private int numeroPaginas;
	private double preco;

	public Livro(String id, String nome, String[] autor, int numeroPaginas, double preco) throws IllegalArgumentException {
		if (autor.length == 0) {
			throw new IllegalArgumentException("Livro precisa ter pelo menos um autor");
		}
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
		this.preco   = preco;
	}

	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumeroPaginas() {
		return this.numeroPaginas;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}