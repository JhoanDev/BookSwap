package model;

public class CadastroModel {
    public static void finalizaCadastro(String nome, String login, String email, String senha, String universidade) {
        UsuariosRepo listusers = UsuariosRepo.getInstance();
        int id = listusers.getQntUsuarios() + 10000;
        Usuario usuario = new Usuario(nome, login, email, senha, universidade, id);     
        listusers.addUsuario(usuario);  
    }
}
