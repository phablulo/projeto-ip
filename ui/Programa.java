package ui;

import dados.*;
import livraria.*;
import exceptions.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

/*Classe para testar o programa e tratar das exceptions*/

public class Programa {
	private static RepositorioClientes repositorioClientes;
	private static RepositorioFuncionarios repositorioFuncionarios;
	private static RepositorioLivros repositorioLivros;

	public static void main(String[] args) {
		String modo;
		try {
			FileReader file = new FileReader("opcao.txt");
			Scanner in = new Scanner(file);
			modo = in.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("Arquivo opcao.txt nao encontrado. Usaremos repositorio em array");
			System.out.println("---------------------------------------------------------------\n");
			modo = "array";
		}

		Boolean usa_lista = (modo.equals("lista"));

		System.out.println("Iniciando programa. Usaremos repositorio em "+(usa_lista ? "lista" : "array"));
		System.out.println("-------------------------------------------------\n\n");


		Funcionario fun1 = new Funcionario("Paulo", "000.000.000-01", "Vendedor");
		Funcionario fun2 = new Funcionario("Joao", "111.111.111-11", "Vendedor");
		Cliente c1 = new Cliente("Marcos","123.123.123-12");
		Cliente c2 = new Cliente("Lucas","234.234.234-23");
		Livro alquimista = new Livro("001", "O Alquimista", new String[]{"Paulo Coelho"}, 93, 25.0);
		Livro narnia     = new Livro("001", "As Crônicas de Nárnia", new String[]{"C.S. Lewis"}, 800, 80.0);

		if (usa_lista) {
			// repositorioLivros = new RepositorioLivrosLista();
			repositorioClientes = new RepositorioClientesLista();
			repositorioFuncionarios = new RepositorioFuncionariosLista();
		} else {
			// repositorioLivros = new RepositorioLivrosArray();
			repositorioClientes = new RepositorioClientesArray();
			repositorioFuncionarios = new RepositorioFuncionariosArray();
		}

		testaRepositorioCliente(new Cliente[]{c1, c2});
		System.out.print("\n");
		testaRepositorioFuncionario(new Funcionario[]{fun1, fun2});

		/* isso vai dar erro de nullpointer por causa dos repositorios de livros */
		// cadastraLivro(fun, alquimista);
		// cadastraLivro(fun, narnia);
	}
	public static void testaRepositorioFuncionario(Funcionario[] funcionarios) {
		int len = funcionarios.length;

		if (len == 0) {
			System.out.println("Não pode testar com um vetor vazio de funcionarios");
			return;
		}

		System.out.println("Iniciando teste em repositorio de funcionarios");

		System.out.print("\tInserindo "+len+" funcionarios... ");
		for (int i = 0; i < len; ++i) {
			repositorioFuncionarios.inserir(funcionarios[i]);
		}
		System.out.println("[OK]");

		Random R = new Random();
		Funcionario fun = funcionarios[R.nextInt(len)]; // funcionario aleatorio
		System.out.print("\tFazendo busca por funcionario com cpf = "+fun.getCpf()+"... ");
		try {
			fun = repositorioFuncionarios.procurar(fun.getCpf());
			System.out.println("Encontrado: "+fun.getNome());
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tfuncionario nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por funcionario com cpf = abcde... ");
		try {
			fun = repositorioFuncionarios.procurar("abcde");
			System.out.println("\n\t\tErro!\n\t\tfuncionario "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Nenhum funcionario encontrado, assim como esperado.");
		}

		System.out.print("\tAtualizando funcionario com cpf = "+fun.getCpf()+"... ");
		try {
			fun.setNome("Astrogildo");
			repositorioFuncionarios.atualizar(fun);
			System.out.println("funcionario atualizado: "+fun.getNome());
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tfuncionario nao foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando funcionario com cpf = abcde... ");
		try {
			Funcionario f = new Funcionario("Astrogildoqwe","abdce","blabla");
			repositorioFuncionarios.atualizar(f);
			System.out.println("\n\t\tErro!\n\t\tfuncionario "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Nenhum funcionario atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo funcionarios cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				repositorioFuncionarios.remover(funcionarios[i]);
			} catch(FuncionarioNaoEncontradoException e) {
				System.out.println("\n\t\tErro!\n\t\tNao pode remover funcionario com cpf="+funcionarios[i].getCpf());
			}
		}
		System.out.println("[OK]");

		System.out.println("Testes concluidos em RepositorioFuncionarios. Nenhum erro encontrado");
	}
	public static void testaRepositorioCliente(Cliente[] clientes) {
		int len = clientes.length;

		if (len == 0) {
			System.out.println("Não pode testar com um vetor vazio de clientes");
			return;
		}

		System.out.println("Iniciando teste em repositorio de clientes");

		System.out.print("\tInserindo "+len+" clientes... ");
		for (int i = 0; i < len; ++i) {
			try {
				repositorioClientes.adicionaCliente(clientes[i]);
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
			fun = repositorioClientes.procuraCliente(fun.getCpf());
			System.out.println("Encontrado: "+fun.getNome());
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tcliente nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por cliente com cpf = abcde... ");
		try {
			fun = repositorioClientes.procuraCliente("abcde");
			System.out.println("\n\t\tErro!\n\t\tcliente "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("Nenhum cliente encontrado, assim como esperado.");
		}

		System.out.print("\tAtualizando cliente com cpf = "+fun.getCpf()+"... ");
		try {
			fun.setNome("Astrogildo");
			repositorioClientes.atualizaCliente(fun.getCpf(), fun);
			System.out.println("cliente atualizado: "+fun.getNome());
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tcliente foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando cliente com cpf = abcde... ");
		try {
			Cliente f = new Cliente("Astrogildo","abdce");
			repositorioClientes.atualizaCliente(f.getCpf(), f);
			System.out.println("\n\t\tErro!\n\t\tcliente "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(ClienteNaoEncontradoException e) {
			System.out.println("Nenhum cliente atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo clientes cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				repositorioClientes.removeCliente(clientes[i].getCpf());
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
			repositorioLivros.adicionaLivro(livros[i]);
		}
		System.out.println("[OK]");

		Random R = new Random();
		Livro fun = livros[R.nextInt(len)]; // livro aleatorio
		System.out.print("\tFazendo busca por livro com nome ="+fun.getNome()+"... ");
		try {
			fun = repositorioLivros.procuraLivro(fun.getNome());
			System.out.println("Encontrado: "+fun.getNome());
		} catch(LivroNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tlivro nao foi encontrado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tFazendo busca por livro com nome = abcde... ");
		try {
			fun = repositorioLivros.procuraLivro("abcde");
			System.out.println("\n\t\tErro!\n\t\tlivro "+fun.getNome()+" foi encontrado, apesar do cpf fornecido ser invalido");
			return;
		} catch(LivroNaoEncontradoException e) {
			System.out.println("Nenhum livro encontrado, assim como esperado.");
		}


		System.out.print("\tAtualizando livro com nome = "+fun.getNome()+"... ");
		try {
			fun.setNome("Astrogildo");
			repositorioLivros.atualizaLivro("Astrogildo",fun);
			System.out.println("livro atualizado: "+fun.getNome());
		} catch(LivroNaoEncontradoException e) {
			System.out.println("\n\t\tErro!\n\t\tlivro nao foi atualizado, apesar de ter sido cadastrado.");
			return;
		}
		System.out.print("\tAtualizando livro com cpf = abcde... ");
		try {
			Livro f = new Livro("001", "O Astrogildo", new String[]{"Sei nao"}, 93, 25.0);
			repositorioLivros.atualizaLivro("O Astrogildo",f);
			System.out.println("\n\t\tErro!\n\t\tlivro "+fun.getNome()+" foi atualizado, apesar do cpf fornecido ser invalido");
			return;
		} catch(LivroNaoEncontradoException e) {
			System.out.println("Nenhum livro atualizado, assim como esperado.");
		}

		System.out.print("\tRemovendo livros cadastrados... ");
		for (int i = 0; i < len; ++i) {
			try {
				repositorioLivros.removeLivro(livros[i].getNome());
			} catch(LivroNaoEncontradoException e) {
				System.out.println("\n\t\tErro!\n\t\tNao pode remover livro com nome="+livros[i].getNome());
			}
		}
		System.out.println("[OK]");

		System.out.println("Testes concluidos em repositorioLivros. Nenhum erro encontrado");
	}*/
	public static void cadastraCliente(Funcionario funcionario, Cliente livro) {
		
	}
}
