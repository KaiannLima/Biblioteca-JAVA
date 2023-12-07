public class Emprestimo implements Imprimivel {
    private Livro livroEmprestado;
    private Usuario usuario;

    public Emprestimo(Livro livroEmprestado, Usuario usuario) {
        this.livroEmprestado = livroEmprestado;
        this.usuario = usuario;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Detalhes do Empréstimo:");
        System.out.println("Livro emprestado: " + livroEmprestado.getTitulo());
        System.out.println("Usuário: " + usuario.getNome());
    }
}