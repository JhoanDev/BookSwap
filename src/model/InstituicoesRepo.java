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

    // Retorna uma instituição pelo Nome e pela cidade
    public Instituicao getInstituicao(String nome, String cidade) {
        for (Instituicao instituicao : instituicaoList) {
            if (instituicao.getNome().equals(nome) && instituicao.getCidade().equals(cidade)) {
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
