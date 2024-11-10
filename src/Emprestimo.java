import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emprestimo {
    LocalDate dataDoEmprestimo;
    LocalDate dataDaDevolucao;
    private Usuario usuario = new Usuario();
    private static Scanner scanner = new Scanner(System.in);
    private List<Livro> livros = new ArrayList<>();
    private static final List<Emprestimo> listaDeEmprestimo = new ArrayList<>();

    public Emprestimo(LocalDate dataDoEmprestimo, LocalDate dataDaDevolucao, Usuario usuario, List<Livro> livros) {
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.dataDaDevolucao = dataDaDevolucao;
        this.usuario = usuario;
        this.livros = livros;
    }

    public Emprestimo() {

    }

    public Emprestimo emprestarLivro() {
        System.out.println("Informe o nome do usuário");
        String usuarioEmprestimo = scanner.nextLine();
        usuario.setNome(usuarioEmprestimo);
        System.out.println("O nome do usuário é: " + usuario);

        LocalDate dataDoEmprestimo = LocalDate.now();

        System.out.println("Informe o título do livro");
        String titulo = scanner.nextLine();
        Livro livro = Livro.encontrarLivroPorTitulo(titulo);
        System.out.println(livro);

        List<Livro> livroParaEmprestimo = new ArrayList<>(); // Cria a lista de livros
        if (livro != null) {
            Integer exemplaresDisponiveis = livro.getExemplaresDisponiveis();
            if (exemplaresDisponiveis >= 1) {
                livro.decrementaExemplaresDisponiveis();
                livroParaEmprestimo.add(livro); // Adiciona o livro à lista
            } else {
                System.out.println("Não existe exemplares sufiientes para empréstimo");
            }
        } else {
            System.out.println("Livro não encontrado.");
            return null; // Ou outra lógica de tratamento de erro
        }

        Emprestimo novoEmprestimo = new Emprestimo(dataDoEmprestimo, null, usuario, livroParaEmprestimo);
        listaDeEmprestimo.add(novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso.");
        System.out.println(novoEmprestimo);
        return novoEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataDoEmprestimo=" + dataDoEmprestimo +
                ", dataDaDevolucao=" + dataDaDevolucao +
                ", livrosEmprestados=" + livros +
                ", usuario=" + usuario +
                '}';
    }
}
