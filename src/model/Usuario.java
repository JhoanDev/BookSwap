package model;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Instituicao universidade;
    private int id;
    private Biblioteca bibliotecaPessoal;
    private ArrayList<Troca> trocasEmAndamento;
    private ArrayList<Troca> trocasFinalizadas;
    private ArrayList<Mensagem> mensagens;


    public Usuario(String nome, String login, String email, String senha, Instituicao universidade, int id) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.universidade = universidade;
        this.id = id;
        this.bibliotecaPessoal = new Biblioteca();
        this.trocasEmAndamento = new ArrayList<>();
        this.trocasFinalizadas = new ArrayList<>();
        this.mensagens = new ArrayList<>();
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

    public void adicionaMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public void limparMensagensLidas(){
        for (Mensagem mensagem : mensagens) {
            if (mensagem.isLida()) {
                mensagens.remove(mensagem);
            }
        }
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
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
