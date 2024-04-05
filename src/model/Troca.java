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
        this.user1Aprovou = false;
        this.user2Aprovou = false;
        this.rejeitada = false;
        this.finalizada = false;
    }

    public Livro getLivro1() {
        return livro1;
    }

    public Livro getLivro2() {
        return livro2;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizar() {
        if (ambosAprovaram()) {
            this.finalizada = true;
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
    }

    public boolean ambosAprovaram() {
        return user1Aprovou && user2Aprovou;
    }

    public void aprovar() {
        if (!user1Aprovou) {
            this.user1Aprovou = true;
        } else {
            this.user2Aprovou = true;
        }
    }

    public void rejeitar() {
        this.rejeitada = true;
    }

    @Override
    public String toString() {
        if (finalizada && ambosAprovaram()) {
            return String.format("Troca do livro '%s' pelo livro '%s' (Finalizada e Aprovada)", livro1.getTitulo(),
                    livro2.getTitulo());
        } else if (finalizada && !ambosAprovaram() && rejeitada) {
            return String.format("Troca do livro '%s' pelo livro '%s' (Finalizada e Rejeitada)", livro1.getTitulo(),
                    livro2.getTitulo());
        } else {
            return String.format("Troca do livro '%s' pelo livro '%s' (Pendente)", livro1.getTitulo(),
                    livro2.getTitulo());
        }
    }

}