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

    // Verifica se existe alguma instituição com esse nome
    public Boolean existeEssaInstituicaoN(String nome) {
        for (Instituicao instituicao : instituicaoList) {
            if (instituicao.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    // Verifica se existe alguma instituição com essa cidade
    public boolean existeEssaInstituicaoC(String cidade) {
        for (Instituicao instituicao : instituicaoList) {
            if (instituicao.getCidade().equals(cidade)) {
                return true;
            }
        }
        return false;
    }
    
    // Retorna a quantidade de instituições
    public int getQntInstituicoes() {
        return quantidadeInstituicoes;
    }

    public static void cadastraInstituicao(String nome, String cidade, String estado) {
        InstituicoesRepo listInst = InstituicoesRepo.getInstance();
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        } else if (cidade == null || cidade.isEmpty()) {
            throw new IllegalArgumentException("Cidade não pode ser vazia");
        } else if (listInst.existeEssaInstituicaoN(nome) && listInst.existeEssaInstituicaoC(cidade)) {
            throw new IllegalArgumentException("Instituição já cadastrada");
        }
        int id = listInst.getQntInstituicoes() + 1000;
        listInst.addInstituicao(new Instituicao(id, nome, cidade, estado));
    }

    public void limparLista() {
        instituicaoList.clear();
        quantidadeInstituicoes = 0;
    }    
}
