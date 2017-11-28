Chat do projeto

[![Join the chat at https://gitter.im/projeto-ip/Lobby](https://badges.gitter.im/projeto-ip/Lobby.svg)](https://gitter.im/projeto-ip/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# TODO #

 ༼ つ ◕_◕ ༽つVazio༼ つ ◕_◕ ༽つ

# Output do programa
Com array:
```
$ java ui.Programa
Iniciando programa. Usaremos repositorio em array
-------------------------------------------------


Iniciando teste em repositorio de clientes
	Inserindo 2 clientes... [OK]
	Fazendo busca por cliente com cpf = 234.234.234-23... Encontrado: Lucas
	Fazendo busca por cliente com cpf = abcde... Nenhum cliente encontrado, assim como esperado.
	Atualizando cliente com cpf = 234.234.234-23... cliente atualizado: Astrogildo
	Atualizando cliente com cpf = abcde... Nenhum cliente atualizado, assim como esperado.
	Removendo clientes cadastrados... [OK]
Testes concluidos em repositorioClientes. Nenhum erro encontrado

Iniciando teste em repositorio de funcionarios
	Inserindo 2 funcionarios... [OK]
	Fazendo busca por funcionario com cpf = 111.111.111-11... Encontrado: Joao
	Fazendo busca por funcionario com cpf = abcde... Nenhum funcionario encontrado, assim como esperado.
	Atualizando funcionario com cpf = 111.111.111-11... funcionario atualizado: Astrogildo
	Atualizando funcionario com cpf = abcde... Nenhum funcionario atualizado, assim como esperado.
	Removendo funcionarios cadastrados... [OK]
Testes concluidos em RepositorioFuncionarios. Nenhum erro encontrado
```
Com lista:
```
$ java ui.Programa
Iniciando programa. Usaremos repositorio em lista
-------------------------------------------------


Iniciando teste em repositorio de clientes
	Inserindo 2 clientes... [OK]
	Fazendo busca por cliente com cpf = 234.234.234-23... Encontrado: Lucas
	Fazendo busca por cliente com cpf = abcde... Nenhum cliente encontrado, assim como esperado.
	Atualizando cliente com cpf = 234.234.234-23... cliente atualizado: Astrogildo
	Atualizando cliente com cpf = abcde... Nenhum cliente atualizado, assim como esperado.
	Removendo clientes cadastrados... [OK]
Testes concluidos em repositorioClientes. Nenhum erro encontrado

Iniciando teste em repositorio de funcionarios
	Inserindo 2 funcionarios... [OK]
	Fazendo busca por funcionario com cpf = 111.111.111-11... Encontrado: Joao
	Fazendo busca por funcionario com cpf = abcde... Nenhum funcionario encontrado, assim como esperado.
	Atualizando funcionario com cpf = 111.111.111-11... funcionario atualizado: Astrogildo
	Atualizando funcionario com cpf = abcde... Nenhum funcionario atualizado, assim como esperado.
	Removendo funcionarios cadastrados... [OK]
Testes concluidos em RepositorioFuncionarios. Nenhum erro encontrado
```

# Coisas feitas #

#### Classe abstrata ####

| nome | feito por | terminado
|------|-----------|----------|
| Pessoa | Phablulo | sim

#### Classes básicas: ####

| nome | feito por | terminado
|------|-----------|----------|
| Livro | Phablulo  | sim
| Funcionario | Robson | sim
| Cliente | Thomas | sim


### Intefaces ###

| nome | feito por | terminado
|------|-----------|-----------|
| RepositorioClientes | Phablulo | sim
| RepositorioFuncionarios | Robson | sim
| RepositorioLivros | Robson | sim


#### Repositórios ####

| nome | feito por | terminado |
|------|-----------|-----------|
| RepositorioFuncionarios | Robson | sim
| RepositorioFuncionariosArray | Robson | sim
| RepositorioFuncionariosLista | Robson | sim
| RepositorioClientes | Phablulo | sim
| RepositorioClientesArray | Phablulo | sim
| RepositorioClientesLista | Phablulo | sim
| RepositorioLivros | Thomas | não
| RepositoriosLivrosArray | Thomas | não
| RepositoriosLivrosLista | Thomas | não

#### Exceções ####
| nome | feito por | terminado |
|------|-----------|-----------|
| FuncionarioNaoEncontradoException | Robson | sim
| FuncionarioJaCadastradoException | Robson | sim
| LivroNaoEncontradoException | Robson | sim
| LivroJaCadastradoException | Robson | sim


### Classe fachada ###


| feito | funciona ? | motivo
|-------|------------|---------
| leitura de arquivo | sim |
| teste do Repositório de Funcionários em lista | sim
| teste do Repositório de Funcionários em array | sim
| teste do Repositório de Clientes em lista | sim |
| teste do Repositório de Clientes em array | sim |

| **Não** feito | motivo |
|---------------|--------|
| teste de Repositório de Livros em lista | não compila
| teste de Repositório de Livros em array | não compila
| função para interagir duas classes | Eu teria que alterar um pouco a classe Cliente, o que não quero fazer agora.
