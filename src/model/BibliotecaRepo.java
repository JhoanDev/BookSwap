package model;

// Classe para instanciar a bliblioteca geral de livros disponiveis

public class BibliotecaRepo {
    private static BibliotecaRepo instance;
    private Biblioteca biblioteca = new Biblioteca();

    // Cria instância única de BibliotecaRepo
    public static BibliotecaRepo getInstance() {
        if (instance == null) {
            instance = new BibliotecaRepo();
        }
        return instance;
    }

    // Retorna a biblioteca
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    // Remove a biblioteca
    public void removerBiblioteca() {
        this.biblioteca = null;
    }
}
