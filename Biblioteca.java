import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (livros.contains(livro)) {
            if (usuario != null && !emprestimoAtivo(usuario)) {
                Emprestimo emprestimo = new Emprestimo(livro, usuario);
                emprestimos.add(emprestimo);
                livros.remove(livro);
                System.out.println("Livro emprestado para " + usuario.getNome());
            } else {
                System.out.println("Usuário não pode pegar empréstimo no momento.");
            }
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    private boolean emprestimoAtivo(Usuario usuario) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public void devolverLivro(String livroID, Usuario usuario) {
        for (Emprestimo emprestimo : emprestimos) {
            Livro livro = emprestimo.getLivroEmprestado();
            if (livro.getId().equals(livroID) && emprestimo.getUsuario().equals(usuario)) {
                livros.add(livro);
                emprestimos.remove(emprestimo);
                System.out.println("Livro devolvido com sucesso.");
                return;
            }
        }
        System.out.println("Este livro não foi emprestado para este usuário.");
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado à biblioteca: " + livro.getTitulo());
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado à biblioteca: " + usuario.getNome());
    }

    public Livro encontrarLivroPorID(String ID) {
        for (Livro livro : livros) {
            if (livro.getId().equals(ID)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario encontrarUsuarioPorID(String ID) {
        for (Usuario usuario : usuarios) {
            if (usuario.getID().equals(ID)) {
                return usuario;
            }
        }
        return null;
    }

    public void imprimir() {
        System.out.println("Livros na Biblioteca:");
        for (Livro livro : livros) {
            livro.imprimirDetalhes();
        }

        System.out.println("\nUsuários da Biblioteca:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + ", ID: " + usuario.getID());
        }

        System.out.println("\nEmpréstimos ativos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Livro: " + emprestimo.getLivroEmprestado().getTitulo() +
                    ", Usuário: " + emprestimo.getUsuario().getNome());
        }
    }
}
