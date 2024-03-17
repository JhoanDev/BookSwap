package model;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private String universidade;
    private int id;

    public Usuario(String nome, String login, String email, String senha, String universidade, int id) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.universidade = universidade;
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
