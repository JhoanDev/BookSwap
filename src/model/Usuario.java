package model;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Instituicao universidade;
    private int id;
    private double avaliacao;
    private Biblioteca bibliotecaPessoal;
    private ArrayList<Notificacao> notificacoes;
    private ArrayList<Troca> trocasEmAndamento;
    private ArrayList<Troca> trocasFinalizadas;

    public Usuario(String nome, String login, String email, String senha, Instituicao universidade, int id) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.universidade = universidade;
        this.id = id;
        this.avaliacao = 0;
        this.bibliotecaPessoal = new Biblioteca();
        this.notificacoes = new ArrayList<>();
        this.trocasEmAndamento = new ArrayList<>();
        this.trocasFinalizadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void addTrocaEmAndamento(Troca troca) {
        this.trocasEmAndamento.add(troca);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instituicao getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Instituicao universidade) {
        this.universidade = universidade;
    }

    public void adicionaLivro(Livro livro) {
        this.bibliotecaPessoal.adicionarLivro(livro);
    }

    public void removeLivro(String nome ) {
        this.bibliotecaPessoal.removerLivro(nome);
    }

    public ArrayList<Livro> getLivros() {
        return this.bibliotecaPessoal.getLivros();
    }
    
    public void addNotificacao(Notificacao notificacao) {
        this.notificacoes.add(notificacao);
    }

    public ArrayList<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(ArrayList<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public void removeNotificacao(Notificacao notificacao) {
        this.notificacoes.remove(notificacao);
    }

    public void removeNotificacao(int index) {
        this.notificacoes.remove(index);
    }

    public Biblioteca getBibliotecaPessoal() {
        return bibliotecaPessoal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDados do Usuário\n");
        sb.append("  Nome: ").append(nome).append("\n");
        sb.append("  Login: ").append(login).append("\n");
        sb.append("  Email: ").append(email).append("\n");
        sb.append("  Universidade: ").append(universidade.getNome()).append("\n");
        sb.append("  ID: ").append(id).append("\n");
        sb.append("  Avaliação: ").append(avaliacao);
        return sb.toString();
    }

    public ArrayList<Troca> getTrocasEmAndamento() {
        return trocasEmAndamento;
    }

    public ArrayList<Troca> getTrocasFinalizadas() {
        return trocasFinalizadas;
    }

    public void addTrocaFinalizada(Troca troca) {
        this.trocasFinalizadas.add(troca);
    }

    public void removeTrocaEmAndamento(Troca troca) {
        this.trocasEmAndamento.remove(troca);
    }
}
