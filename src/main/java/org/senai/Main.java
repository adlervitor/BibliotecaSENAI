package org.senai;

import org.senai.entidades.Cliente;
import org.senai.entidades.Livro;
import org.senai.negocio.Biblioteca;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n### Menu ###");
            System.out.println("1. Listar livros disponíveis");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Cadastrar novo livro");
            System.out.println("5. Listar livros emprestados");
            System.out.println("6. Cadastrar novo cliente");
            System.out.println("7. Listar clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro);
                    }
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.print("Digite o ID do livro a ser emprestado: ");
                    int idLivroEmprestimo = scanner.nextInt();
                    biblioteca.emprestarLivro(idLivroEmprestimo);
                    System.out.println("Livro emprestado com sucesso!");
                    Thread.sleep(2000);
                    break;
                case 3:
                    System.out.print("Digite o ID do livro a ser devolvido: ");
                    int idLivroDevolucao = scanner.nextInt();
                    biblioteca.devolverLivro(idLivroDevolucao);
                    System.out.println("Livro devolvido com sucesso!");
                    Thread.sleep(2000);
                    break;
                case 4:
                    System.out.print("Digite o nome do livro: ");
                    scanner.nextLine(); // Limpar o buffer
                    String nomeLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.print("Digite o tipo do livro: ");
                    String tipoLivro = scanner.nextLine();
                    Livro novoLivro = new Livro(0, nomeLivro, autorLivro, tipoLivro, "disponível");
                    biblioteca.inserirLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                    Thread.sleep(2000);
                    break;
                case 5:
                    List<Livro> livrosEmprestados = biblioteca.listarLivrosEmprestados();
                    for (Livro livro : livrosEmprestados) {
                        System.out.println(livro.toString());
                    }
                    Thread.sleep(2000);
                    break;
                case 6:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Limpar o buffer
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o e-mail do cliente: ");
                    String emailCliente = scanner.nextLine();
                    System.out.print("Digite o sexo do cliente: ");
                    String sexoCliente = scanner.nextLine();
                    Cliente novoCliente = new Cliente(0, nomeCliente, emailCliente, sexoCliente);
                    biblioteca.cadastrarCliente(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    Thread.sleep(2000);
                    break;
                case 7:
                    List<Cliente> clientes = biblioteca.listarClientes();
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.toString());
                    }
                    Thread.sleep(2000);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    Thread.sleep(2000);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    Thread.sleep(2000);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
