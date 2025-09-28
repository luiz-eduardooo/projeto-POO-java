package treino.gemini.biblioteca;

public class Main {
    public static void main(String[] args) {
                // --- PREPARAÇÃO DO CENÁRIO ---
                Biblioteca biblioteca = new Biblioteca();
                Livro livro1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");
                Livro livro2 = new Livro(2, "O Hobbit", "J.R.R. Tolkien");
                Livro livro3 = new Livro(3, "Duna", "Frank Herbert");
                Livro livro4 = new Livro(4, "A Revolução dos Bichos", "George Orwell");
                Membro membro1 = new Membro(101, "Luiz");
                Membro membro2 = new Membro(102, "Ana");

                biblioteca.cadastrarLivro(livro1);
                biblioteca.cadastrarLivro(livro2);
                biblioteca.cadastrarLivro(livro3);
                biblioteca.cadastrarLivro(livro4);
                biblioteca.cadastrarMembro(membro1);
                biblioteca.cadastrarMembro(membro2);

                System.out.println("--- Início das Simulações de Empréstimo ---\n");

                // --- SIMULAÇÃO 1: Três empréstimos bem-sucedidos para o Luiz ---
                try {
                    System.out.println("Luiz tentando pegar 'O Senhor dos Anéis'...");
                    biblioteca.emprestarLivro(101, 1);
                    System.out.println("Luiz tentando pegar 'O Hobbit'...");
                    biblioteca.emprestarLivro(101, 2);
                    System.out.println("Luiz tentando pegar 'Duna'...");
                    biblioteca.emprestarLivro(101, 3);
                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                }

                System.out.println("\n-----------------------------------\n");

                // --- SIMULAÇÃO 2: Luiz tenta pegar o 4º livro (ERRO DE LIMITE) ---
                System.out.println("Luiz tentando pegar o quarto livro, 'A Revolução dos Bichos'...");
                try {
                    biblioteca.emprestarLivro(101, 4);
                } catch (LimiteDeEmprestimosExcedidoException e) {
                    System.out.println("FALHA ESPERADA: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                }

                System.out.println("\n-----------------------------------\n");

                // --- SIMULAÇÃO 3: Ana tenta pegar um livro já emprestado (ERRO DE DISPONIBILIDADE) ---
                System.out.println("Ana tentando pegar 'Duna', que já está com Luiz...");
                try {
                    biblioteca.emprestarLivro(102, 3);
                } catch (LivroNaoDisponivelException e) {
                    System.out.println("FALHA ESPERADA: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                }

                System.out.println("\n-----------------------------------\n");

                // --- SIMULAÇÃO 4: Luiz devolve um livro ---
                System.out.println("Luiz devolvendo 'O Hobbit'...");
                try {
                    biblioteca.devolverLivro(101, 2);
                    System.out.println(">>> Devolução realizada com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro inesperado na devolução: " + e.getMessage());
                }
            }
}
