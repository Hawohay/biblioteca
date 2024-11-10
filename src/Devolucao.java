import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Devolucao {
    LocalDate dataDoEmprestimo;
    LocalDate dataDaDevolucao;
    private Usuario usuario = new Usuario();
    private static Scanner scanner = new Scanner(System.in);
    private List<Livro> livros = new ArrayList<>();
    private static final List<Devolucao> listaDeDevolucao = new ArrayList<>();

    public Devolucao(LocalDate dataDoEmprestimo, LocalDate dataDaDevolucao, Usuario usuario, List<Livro> livros) {
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.dataDaDevolucao = dataDaDevolucao;
        this.usuario = usuario;
        this.livros = livros;
    }

    public Devolucao() {

    }

    public Devolucao devolverLivro() {
        System.out.println("Informe o nome do usuário");
        String usuarioEmprestimo = scanner.nextLine();
        usuario.setNome(usuarioEmprestimo);
        System.out.println("O nome do usuário é: " + usuario);

        //LocalDate dataDoEmprestimo = LocalDate.now();
        LocalDate dataDaDevolucao = LocalDate.now();

        System.out.println("Informe o título do livro");
        String titulo = scanner.nextLine();
        Livro livro = Livro.encontrarLivroPorTitulo(titulo);
        System.out.println(livro);

        List<Livro> livroParaDevolucao = new ArrayList<>(); // Cria a lista de livros
        if (livro != null) {
            Integer exemplaresDisponiveis = livro.getExemplaresDisponiveis();
            if (exemplaresDisponiveis >= 0) {
                livro.incrementaExemplaresDisponiveis();
                livroParaDevolucao.add(livro); // Adiciona o livro à lista
            }
        } else {
            System.out.println("Livro não encontrado.");
            return null; // Ou outra lógica de tratamento de erro
        }

        Devolucao novaDevolucao = new Devolucao(null, dataDaDevolucao, usuario, livroParaDevolucao);
        listaDeDevolucao.add(novaDevolucao);
        System.out.println("Devolução realizada com sucesso.");
        System.out.println(novaDevolucao);
        return novaDevolucao;
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
