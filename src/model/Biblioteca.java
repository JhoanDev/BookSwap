package model;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private int quantidadeLivros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.quantidadeLivros = 0;
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        this.quantidadeLivros++;
    }

    public void removerLivro(String livro) {
        if (this.quantidadeLivros == 0) {
            System.out.println("Não há livros na biblioteca.");
            return;
        }
        int i;
        for (i = 0; i < this.livros.size(); i++) {
            if (this.livros.get(i).getTitulo().equals(livro)) {
                this.livros.remove(i);
                this.quantidadeLivros--;
                return;
            }
        }
        if(i == this.livros.size()) System.out.println("Livro não encontrado.");
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Livro getLivro(String titulo) {
        for (Livro livro : this.livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
}
