import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream arquivoSaida = new FileOutputStream("saida.txt");
            PrintStream printStream = new PrintStream(arquivoSaida);
            System.setOut(printStream);

            Biblioteca biblioteca = new Biblioteca();

            BufferedReader brUsuarios = new BufferedReader(new FileReader("usuarios.txt"));
            String line;
            while ((line = brUsuarios.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 3) {
                    Usuario usuario = new Usuario(userData[0], userData[1], userData[2]);
                    biblioteca.adicionarUsuario(usuario);
                }
            }

            BufferedReader brLivros = new BufferedReader(new FileReader("livros.txt"));
            while ((line = brLivros.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length >= 4) {
                    String tipoLivro = bookData[3].trim();

                    if (tipoLivro.equalsIgnoreCase("ebook")) {
                        Livro livro = new Ebook(bookData[0], bookData[1], bookData[2]);
                        biblioteca.adicionarLivro(livro);
                    } else if (tipoLivro.equalsIgnoreCase("fisico")) {
                        Livro livro = new LivroFisico(bookData[0], bookData[1], bookData[2]);
                        biblioteca.adicionarLivro(livro);
                    }
                }
            }

            BufferedReader brEmprestimos = new BufferedReader(new FileReader("emprestimos.txt"));
            while ((line = brEmprestimos.readLine()) != null) {
                String[] loanData = line.split(",");
                if (loanData.length >= 2) {
                    Livro livroEmprestado = biblioteca.encontrarLivroPorID(loanData[0]);
                    Usuario usuario = biblioteca.encontrarUsuarioPorID(loanData[1]);
                    if (livroEmprestado != null && usuario != null) {
                        biblioteca.emprestarLivro(livroEmprestado, usuario);
                    }
                }
            }
            System.out.println();
            biblioteca.imprimir();
            System.out.println();

            Usuario usuarioQueDevolve = biblioteca.encontrarUsuarioPorID("91011");
            if (usuarioQueDevolve != null) {
                System.out.println("Devolução do Livro: " + "9788576052891 "  + usuarioQueDevolve.getNome());
                biblioteca.devolverLivro("9788576052891", usuarioQueDevolve);
            }

            System.out.println();
            biblioteca.imprimir();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
