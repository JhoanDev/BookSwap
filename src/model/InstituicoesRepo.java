package model;

import java.util.ArrayList;
import java.util.List;

// Classe onde fica a lista de instituições
public class InstituicoesRepo {
    private static InstituicoesRepo instance;
    private List<Instituicao> instituicaoList = new ArrayList<>();
    private static int quantidadeInstituicoes = 0;

    // Cria uma instância de InstituicoesRepo
    public static InstituicoesRepo getInstance() {
        if (instance == null) {
            instance = new InstituicoesRepo();
        }
        return instance;
    }

    // Adiciona uma instituição à lista
    public void addInstituicao(Instituicao instituicao) {
        quantidadeInstituicoes++;
        instituicaoList.add(instituicao);
    }

    // Retorna a lista de instituições
    public List<Instituicao> getAllInstituicoes() {
        return instituicaoList;
    }

    // Retorna uma instituição pelo Nome
    public Instituicao getInstituicao(String nome) {
        for (Instituicao instituicao : instituicaoList) {
            if (instituicao.getNome().toUpperCase().equals(nome.toUpperCase())) {
                return instituicao;
            }
        }
        return null;
    }

    // Retorna a quantidade de instituições
    public int getQntInstituicoes() {
        return quantidadeInstituicoes;
    }
}
