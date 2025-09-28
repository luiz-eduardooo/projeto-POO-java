package treino.gemini.biblioteca;

import java.util.ArrayList;

public class Membro {
    private final String nome;
    private final int id;
    private final ArrayList<Livro> livros = new ArrayList<>();
    private Biblioteca biblioteca;

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        biblioteca.cadastrarMembro(this);
    }

    public Membro(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }

    public Livro procurarLivro(int idLivro) throws LivroNaoEncontradoException{
        for(Livro livro : this.livros){
            if(livro.getId() == idLivro){
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Esse livro não está com esse membro!");
    }

    public int getQuantidadeLivrosEmprestados(){
        return this.livros.size();
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void removerLivro(Livro livro){
        this.livros.remove(livro);
    }
}
