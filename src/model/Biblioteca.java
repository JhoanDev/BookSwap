package model;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private Usuario usuario;
    private int quantidadeLivros;

    public Biblioteca(Usuario usuario) {
        this.usuario = usuario;
        this.livros = new ArrayList<>();
        this.quantidadeLivros = 0;
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        this.quantidadeLivros++;
    }

    public void removerLivro(Livro livro) {
        this.livros.remove(livro);
        this.quantidadeLivros--;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
}
