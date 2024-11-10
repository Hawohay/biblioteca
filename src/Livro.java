import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    public Integer numeroDeExemplares;
    public Integer exemplaresDisponiveis;

    private static final List<Livro> listaDeLivros = new ArrayList<>();

    public Livro(String titulo, String autor, Integer anoPublicacao, Integer numeroDeExemplares, Integer exemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroDeExemplares = numeroDeExemplares;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public static Livro cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o nome do autor do livro:");
        String autor = scanner.nextLine();

        System.out.println("Digite o ano de publicação do livro:");
        Integer anoPublicacao = Integer.valueOf(scanner.nextLine());

        System.out.println("Digite o número de exemplares do livro:");
        Integer numeroDeExemplares = Integer.valueOf(scanner.nextLine());

        System.out.println("Digite a quantidade de exemplares disponíveis:");
        Integer exemplaresDisponiveis = Integer.valueOf(scanner.nextLine());

        Livro livroExistente = encontrarLivroPorTitulo(titulo);

        if (livroExistente != null) {
            System.out.println("Livro com título " + titulo + " já existe.");
            System.out.println("Deseja atualizar as informações desse livro? (s/n):");

            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                livroExistente.setTitulo(titulo);
                livroExistente.setAutor(autor);
                livroExistente.setAnoPublicacao(anoPublicacao);
                livroExistente.setNumeroDeExemplares(numeroDeExemplares);
                livroExistente.setExemplaresDisponiveis(exemplaresDisponiveis);
                System.out.println("Dados atualizados com sucesso.");
            }
            return livroExistente;
        } else {
            Livro novoLivro = new Livro(titulo, autor, anoPublicacao, numeroDeExemplares, exemplaresDisponiveis);
            listaDeLivros.add(novoLivro);
            System.out.println("Livro cadastrado com sucesso.");
            System.out.println(novoLivro);
            return novoLivro;
        }
    }

    public static Livro encontrarLivroPorTitulo(String titulo) {
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public static void listarTodosOsLivros() {
        for (Livro livro : listaDeLivros) {
            System.out.println(livro);
        }
    }

    public static void pesquisarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o título do livro:");
        String titulo = scanner.nextLine();
        Livro livro = encontrarLivroPorTitulo(titulo);

        if (livro != null) {
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void excluirLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o título do livro:");
        String titulo = scanner.nextLine();
        Livro livro = encontrarLivroPorTitulo(titulo);

        if (livro != null) {
            listaDeLivros.remove(livro);
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }


    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getNumeroDeExemplares() {
        return numeroDeExemplares;
    }

    public void setNumeroDeExemplares(Integer numeroDeExemplares) {
        this.numeroDeExemplares = numeroDeExemplares;
    }

    public Integer getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(Integer exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public void decrementaExemplaresDisponiveis() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
        }
    }

    public void incrementaExemplaresDisponiveis() {
        if (exemplaresDisponiveis >= 0) {
            exemplaresDisponiveis++;
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", numeroDeExemplares=" + numeroDeExemplares +
                ", exemplaresDisponiveis=" + exemplaresDisponiveis +
                '}';
    }
}
