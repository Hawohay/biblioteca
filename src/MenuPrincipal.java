import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private Integer opcao;
    Scanner scanner = new Scanner(System.in);

    public void exibeMenu() {
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1.      Cadastrar livro        ");
            System.out.println("-------------------------------");
            System.out.println("2.      Pesquisar livro        ");
            System.out.println("-------------------------------");
            System.out.println("3.       Excluir livro         ");
            System.out.println("-------------------------------");
            System.out.println("4.   Listar todos os livros    ");
            System.out.println("-------------------------------");
            System.out.println("5.     Empréstimo de livro     ");
            System.out.println("-------------------------------");
            System.out.println("6.      Devolução de livro     ");
            System.out.println("-------------------------------");
            System.out.println("0.         Encerrar            ");
            System.out.println("-------------------------------");

            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        Livro.cadastrarLivro();
                        break;
                    case 2:
                        Livro.pesquisarLivro();
                        break;
                    case 3:
                        Livro.excluirLivro();
                        break;
                    case 4:
                        Livro.listarTodosOsLivros();
                        break;
                    case 5:
                        Emprestimo emprestimo = new Emprestimo(); // Instancie a classe Emprestimo
                        emprestimo.emprestarLivro();
                        break;
                    case 6:
                        Devolucao devolucao = new Devolucao(); // Instancie a classe Emprestimo
                        devolucao.devolverLivro();
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
        }
    }
}
