package model;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Instituicao universidade;
    private int id;
    private double avaliacao;

    public Usuario(String nome, String login, String email, String senha, Instituicao universidade, int id) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.universidade = universidade;
        this.id = id;
        this.avaliacao = 0;
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

}
