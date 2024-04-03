package model;

public class Troca {
    private Livro livro1;
    private Livro livro2;
    private boolean finalizada;
    private boolean user1Aprovou;
    private boolean user2Aprovou;
    private boolean rejeitada;

    public Troca(Livro livro1, Livro livro2) {
        this.livro1 = livro1;
        this.livro2 = livro2;
        this.finalizada = false;
        this.user1Aprovou = false;
        this.user2Aprovou = false;
        this.rejeitada = false;
    }
    
    public Livro getLivro1() {
        return livro1;
    }

    public void setLivro1(Livro livro1) {
        this.livro1 = livro1;
    }

    public Livro getLivro2() {
        return livro2;
    }

    public void setLivro2(Livro livro2) {
        this.livro2 = livro2;
    }


    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizar() {
        if (ambosAprovaram()) {
            this.finalizada = true;
            livro1.getDono().getBibliotecaPessoal().removerLivro(livro1.getTitulo());
            livro2.getDono().getBibliotecaPessoal().removerLivro(livro2.getTitulo());
            BibliotecaRepo bGeral = BibliotecaRepo.getInstance();
            bGeral.getBiblioteca().removerLivro(livro1.getTitulo());
            bGeral.getBiblioteca().removerLivro(livro2.getTitulo());
            livro1.getDono().removeTrocaEmAndamento(this);
            livro2.getDono().removeTrocaEmAndamento(this);
            livro1.getDono().addTrocaFinalizada(this);
            livro2.getDono().addTrocaFinalizada(this);
        }
    }

    public boolean ambosAprovaram() {
        return user1Aprovou && user2Aprovou;
    }


    public void aprovar() {
        if (!user1Aprovou) {
            this.user1Aprovou = true;
        }
        else {
            this.user2Aprovou = true;
        }
    }

    public void rejeitar() {
        this.rejeitada = true;
        livro1.getDono().removeTrocaEmAndamento(this);
        livro2.getDono().removeTrocaEmAndamento(this);
        livro1.getDono().addTrocaFinalizada(this);
        livro2.getDono().addTrocaFinalizada(this);
    }

    public boolean isTrocaFinalizada() {
        return rejeitada || finalizada;
    }

    public boolean isRejeitada() {
        return rejeitada;
    }

    @Override
    public String toString() {
        return String.format("Troca {livro1=%s, livro2=%s, finalizada=%b}", livro1.getTitulo(), livro2.getTitulo(), finalizada, user1Aprovou, user2Aprovou, rejeitada);
    }
}