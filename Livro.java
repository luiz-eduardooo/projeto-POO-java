package treino.gemini.biblioteca;

public class Livro {
    private final int id;
    private final String titulo;
    private final String autor;
    private boolean disponivel;
    private Membro membro;
    private Biblioteca biblioteca;

    public void setMembro(Membro membro) {
        this.membro = membro;
        membro.adicionarLivro(this);
    }

    public Membro getMembro() {
        return membro;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        biblioteca.cadastrarLivro(this);
    }

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
     public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
     }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", id=" + id +
                ", autor='" + autor + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}

