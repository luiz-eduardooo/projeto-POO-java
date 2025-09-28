package treino.gemini.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Livro> livros = new ArrayList<>();
    private final ArrayList<Membro> membros = new ArrayList<>();

    public void cadastrarLivro(Livro livro){
        this.livros.add(livro);
    }

    public void cadastrarMembro(Membro membro){
        this.membros.add(membro);
    }

    public Livro buscarLivroPorId(int idLivro) throws LivroNaoEncontradoException{
        for(Livro livro: this.livros){
            if(livro.getId() == idLivro){
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado!");
    }

    public Membro buscarMembroPorId(int idMembro) throws MembroNaoEncontradoException{
        for(Membro membro: this.membros){
            if(membro.getId() == idMembro){
                return membro;
            }
        }
        throw new MembroNaoEncontradoException("Membro não encontrado!");
    }

    public void emprestarLivro(int idMembro, int idLivro) throws MembroNaoEncontradoException, LivroNaoEncontradoException, LivroNaoDisponivelException, LimiteDeEmprestimosExcedidoException{
        Membro membro = buscarMembroPorId(idMembro);
        Livro livro = buscarLivroPorId(idLivro);
        if(membro.getQuantidadeLivrosEmprestados() >= 3){
            throw new LimiteDeEmprestimosExcedidoException("Esse membro ja está com o limite de livros!");
        }
        if(!livro.isDisponivel()){
            throw new LivroNaoDisponivelException("Esse livro não está disponivel!");
        }

        livro.setDisponivel(false);
        membro.adicionarLivro(livro);
        System.out.println("O livro foi emprestado com sucesso!");
    }
    public void devolverLivro(int idMembro, int idLivro) throws LivroNaoEncontradoException, MembroNaoEncontradoException{
        Membro membro = buscarMembroPorId(idMembro);
        Livro livro = membro.procurarLivro(idLivro);

        livro.setDisponivel(true);
        membro.removerLivro(livro);
    }



}
