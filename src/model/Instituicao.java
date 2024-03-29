package model;

import java.util.List;

public class Instituicao {
    private int idInstituicao;
    private String nome;
    private String cidade;
    private String estado;

    // Construtor
    public Instituicao(int idInstituicao, String nome, String cidade, String estado) {
        this.idInstituicao = idInstituicao;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters e Setters
    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Instituicao buscarPorNome(List<Instituicao> instituicoes, String nome) {
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getNome().equalsIgnoreCase(nome)) {
                return instituicao;
            }
        }
        return null;
    }
}
