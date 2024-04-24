package model;

public class Troca {
    private Livro livro1;
    private Livro livro2;
    private boolean aprovada;
    private boolean rejeitada;

    public Troca(Livro livro1, Livro livro2) {
        this.livro1 = livro1;
        this.livro2 = livro2;
        this.rejeitada = false;
        this.aprovada = false;
    }

    public Livro getLivro1() {
        return livro1;
    }

    public Livro getLivro2() {
        return livro2;
    }

    public void finalizarTroca() {
        Usuario dono1 = livro1.getDono();
        Usuario dono2 = livro2.getDono();
        dono1.getBibliotecaPessoal().removerLivro(livro1.getTitulo());
        dono2.getBibliotecaPessoal().removerLivro(livro2.getTitulo());
        BibliotecaRepo bGeral = BibliotecaRepo.getInstance();
        bGeral.getBiblioteca().removerLivro(livro1.getTitulo());
        bGeral.getBiblioteca().removerLivro(livro2.getTitulo());
        dono1.removeTrocaEmAndamento(this);
        dono2.removeTrocaEmAndamento(this);
        dono1.addTrocaFinalizada(this);
        dono2.addTrocaFinalizada(this);
    }

    public void aprovar() {
        if (!this.rejeitada) {
            this.aprovada = true;
        }
    }
    
    public void rejeitar() {
        if (!this.aprovada) {
            this.rejeitada = true;
        }
    }    

    @Override
    public String toString() {
        if (this.aprovada) {
            return String.format("Troca do livro '%s' pelo livro '%s' (Realizada)", livro1.getTitulo(),
                    livro2.getTitulo());
        } else if (this.rejeitada) {
            return String.format("Troca do livro '%s' pelo livro '%s' (Cancelada)", livro1.getTitulo(),
                    livro2.getTitulo());
        } else {
            return String.format("Troca do livro '%s' pelo livro '%s' (Pendente)", livro1.getTitulo(),
                    livro2.getTitulo());
        }
    }

}