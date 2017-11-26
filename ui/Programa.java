package ui;

import dados.*;
import livraria.*;
import exceptions.*;
import java.util.Random;

/*Classe para testar o programa e tratar das exceptions*/

public class Programa {
	private RepositorioLivros repositoriolivros;
	private RepositorioClientes repositorioClientes;
	private RepositorioFuncionarios repositorioFuncionarios;
	private RepositorioLivros repositorioLivros;

	public void main(String[] args) {
		Funcionario fun = new Funcionario("Paulo", "000.000.000-00", "Vendedor");
		Livro alquimista = new Livro("001", "O Alquimista", new String[]{"Paulo Coelho"}, 93, 25.0);
		Livro narnia     = new Livro("001", "As Crônicas de Nárnia", new String[]{"C.S. Lewis"}, 800, 80.0);


		cadastraLivro(fun, alquimista);
		cadastraLivro(fun, narnia);
	}
	public void testaRepositorioFuncionario(Funcionario[] funcionarios) {
		int len = funcionarios.length;

		if (len == 0) {
			System.out.println("Não pode testar com um vetor vazio de funcionarios");
			return;
		}

		System.out.println("Iniciando teste em repositorio de funcionarios");

		System.out.print("\tInserindo "+len+" funcioanrios... ");
		for (int i = 0; i < len; ++i) {
			this.repositorioFuncionarios.inserir(funcionarios[i]);
		}
		System.out.println("[OK]");

		Random R = new Random();
		Funcionario fun = funcionarios[R.nextInt(len)]; // funcionario aleatorio
		System.out.print("\tFazendo busca por funcionario com cpf = "+fun.getCpf()+"... ");
		try {
			fun = this.repositorioFuncionarios.procurar(fun.getCpf());
			System.out.println("Encontrado: "+fun.getNome());
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tfuncionario nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por funcionario com cpf = abcde... ");
		try {
			fun = this.repositorioFuncionarios.procurar("abcde");
			System.out.println("\n\t\tErro!\n\t\tfuncionario "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Nenhum funcionario encontrado, assim como esperado.");
		}

		System.out.print("\tAtualizando funcionario com cpf ="+fun.getCpf()+"... ");
		try {
			fun.setNome("Astrogildo");
			this.repositorioFuncionarios.atualizar(fun);
			System.out.println("funcionario atualizado: "+fun.getNome());
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tfuncionario foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando funcionario com cpf = abcde... ");
		try {
			Funcionario f = new Funcionario("Astrogildoqwe","abdce","blabla");
			this.repositorioFuncionarios.atualizar(f);
			System.out.println("\n\t\tErro!\n\t\tfuncionario "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Nenhum funcionario atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo funcionarios cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				this.repositorioFuncionarios.remover(funcionarios[i]);
			} catch(FuncionarioNaoEncontradoException e) {
				System.out.println("\n\t\tErro!\n\t\tNao pode remover funcionario com cpf="+funcionarios[i].getCpf());
			}
		}
		System.out.println("[OK]");

		System.out.println("Testes concluidos em RepositorioFuncionarios. Nenhum erro encontrado");
	}
	public void testaRepositorioCliente(Cliente[] clientes) {
		int len = clientes.length;

		if (len == 0) {
			System.out.println("Não pode testar com um vetor vazio de clientes");
			return;
		}

		System.out.println("Iniciando teste em repositorio de clientes");

		System.out.print("\tInserindo "+len+" clientes... ");
		for (int i = 0; i < len; ++i) {
			try {
				this.repositorioClientes.adicionaCliente(clientes[i]);
			} catch (ClienteJaCadastradoException e) {
				System.out.println("\n\t\tErro!\n\t\tcliente ja foi cadastrado.");
				return;
			}
		}
		System.out.println("[OK]");

		Random R = new Random();
		Cliente fun = clientes[R.nextInt(len)]; // cliente aleatorio
		System.out.print("\tFazendo busca por cliente com cpf = "+fun.getCpf()+"... ");
		try {
			fun = this.repositorioClientes.procuraCliente(fun.getCpf());
			System.out.println("Encontrado:"+fun.getNome());
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tcliente nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por cliente com cpf = abcde... ");
		try {
			fun = this.repositorioClientes.procuraCliente("abcde");
			System.out.println("\n\t\tErro!\n\t\tcliente "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("Nenhum cliente encontrado, assim como esperado.");
		}

		System.out.print("\tAtualizando cliente com cpf ="+fun.getCpf()+"... ");
		try {
			fun.setNome("Astrogildo");
			this.repositorioClientes.atualizaCliente(fun.getCpf(), fun);
			System.out.println("cliente atualizado:"+fun.getNome());
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tcliente foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando cliente com cpf = abcde... ");
		try {
			Cliente f = new Cliente("Astrogildo","abdce");
			this.repositorioClientes.atualizaCliente(f.getCpf(), f);
			System.out.println("\n\t\tErro!\n\t\tcliente "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("Nenhum cliente atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo clientes cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				this.repositorioClientes.removeCliente(clientes[i].getCpf());
			} catch(ClienteNaoEncontradoException e) {
				System.out.println("\n\t\tErro!\n\t\tNao pode remover cliente com cpf="+clientes[i].getCpf());
			}
		}
		System.out.println("[OK]");

		System.out.println("Testes concluidos em repositorioClientes. Nenhum erro encontrado");
	}
	/*public void testaRepositorioLivro(Livro[] livros) {
		int len = livros.length;

		if (len == 0) {
			System.out.println("Não pode testar com um vetor vazio de livros");
			return;
		}

		System.out.println("Iniciando teste em repositorio de livros");

		System.out.print("\tInserindo"+len+"clientes... ");
		for (int i = 0; i < len; ++i) {
			this.repositorioLivros.adicionaLivro(livros[i]);
		}
		System.out.println("[OK]");

		Random R = new Random();
		Livro fun = livros[R.nextInt(len)]; // livro aleatorio
		System.out.print("\tFazendo busca por livro com nome ="+fun.getNome()+"... ");
		try {
			fun = this.repositorioLivros.procuraLivro(fun.getNome());
			System.out.println("Encontrado:"+fun.getNome());
		} catch(LivroNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tlivro nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por livro com nome = abcde... ");
		try {
			fun = this.repositorioLivros.procuraLivro("abcde");
			System.out.println("\n\t\tErro!\n\t\tlivro "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(LivroNaoEncontradoException e) {
			System.out.println("Nenhum livro encontrado, assim como esperado.");
		}


		System.out.print("\tAtualizando livro com nome = "+fun.getNome()+"... ");
		try {
			fun.setNome("Astrogildo");
			this.repositorioLivros.atualizaLivro("Astrogildo",fun);
			System.out.println("livro atualizado:"+fun.getNome());
		} catch(LivroNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tlivro nao foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando livro com cpf = abcde... ");
		try {
			Livro f = new Livro("001", "O Astrogildo", new String[]{"Sei nao"}, 93, 25.0);
			this.repositorioLivros.atualizaLivro("O Astrogildo",f);
			System.out.println("\n\t\tErro!\n\t\tlivro "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(LivroNaoEncontradoException e) {
			System.out.println("Nenhum livro atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo livros cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				this.repositorioLivros.removeLivro(livros[i].getNome());
			} catch(LivroNaoEncontradoException e) {
				System.out.println("\n\t\tErro!\n\t\tNao pode remover livro com nome="+livros[i].getNome());
			}
		}
		System.out.println("[OK]");

		System.out.println("Testes concluidos em repositorioLivros. Nenhum erro encontrado");
	}*/
	public void cadastraLivro(Funcionario funcionario, Livro livro) {
		livro.setCadastrante(funcionario);
		this.repositorioLivros.adicionaLivro(livro);
	}
}
