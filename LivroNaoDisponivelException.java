package treino.gemini.biblioteca;

public class LivroNaoDisponivelException extends Exception {
    public LivroNaoDisponivelException(String message) {
        super(message);
    }
}
