public abstract class Livro implements Imprimivel {
    private String titulo;
    private String autor;
    private String id;

    public Livro(String titulo, String autor, String id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Título: " + getTitulo() + " ");
        System.out.print("Autor: " + getAutor()+ " ");
        System.out.println("ID: " + getId());
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}