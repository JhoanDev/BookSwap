package model;

public class CadastroModel {
    // adiciona um usuário ao repositório de usuários   
    public static void cadastraUsuario(String nome, String login, String email, String senha, Instituicao universidade) {
        UsuariosRepo listUsers = UsuariosRepo.getInstance();
        int id = listUsers.getQntUsuarios() + 10000;
        listUsers.addUsuario(new Usuario(nome, login, email, senha, universidade, id));  
    }
    // adiciona uma instituição ao repositório de instituições
    public static void cadastraInstituicao(String nome, String cidade, String estado) {
        InstituicoesRepo listInst = InstituicoesRepo.getInstance();
        int id = listInst.getQntInstituicoes() + 1000;
        listInst.addInstituicao(new Instituicao(id, nome, cidade, estado));
    }
    
}
