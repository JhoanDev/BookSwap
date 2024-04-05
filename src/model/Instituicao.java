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

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }


    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean equals(Instituicao instituicao) {
        return this.idInstituicao == instituicao.getIdInstituicao();
    }
}
