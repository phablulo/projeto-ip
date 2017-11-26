Chat do projeto

[![Join the chat at https://gitter.im/projeto-ip/Lobby](https://badges.gitter.im/projeto-ip/Lobby.svg)](https://gitter.im/projeto-ip/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# TODO #

- Todas as exceções restantes/unir todas as exceções dos seus respectivos objetos em uma única classe;

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
| ClienteRepositorio | Phablulo | sim
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
| LivroNaoEncontradoException | Robson | sim
| LivroJaCadastradoException | Robson | sim


### Classe fachada ###


| feito | funciona ? | motivo
|-------|------------|---------
| leitura de arquivo | sim |
| teste do Repositório de Funcionários em lista | não | erro ao remover funcionários: NullPointerException
| teste do Repositório de Funcionários em array | não | erro ao remover funcionários: NullPointerException
| teste do Repositório de Clientes em lista | sim |
| teste do Repositório de Clientes em array | sim |

| **Não** feito | motivo |
|---------------|--------|
| teste de Repositório de Livros em lista | não compila
| teste de Repositório de Livros em array | não compila
| função para interagir duas classes | Eu teria que alterar um pouco a classe Cliente, o que não quero fazer agora.