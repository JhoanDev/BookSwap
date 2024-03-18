package model;

import java.util.ArrayList;
import java.util.List;

// Classe onde fica o array list de usuarios, 
//para acessar é so criar uma instancia onde precisar e chamar os metodos.
public class UsuariosRepo {
    private static UsuariosRepo instance;
    private List<Usuario> UsuarioList = new ArrayList<>();
    private static int quantidadeUsuarios = 0;

    // Cria instancia de UsuariosRepo
    public static UsuariosRepo getInstance() {
        if (instance == null) {
            instance = new UsuariosRepo();
        }
        return instance;
    }

    // Adiciona usuario a lista
    public void addUsuario(Usuario Usuario) {
        quantidadeUsuarios++;
        UsuarioList.add(Usuario);
    }

    // Retorna lista de usuarios
    public List<Usuario> getAllUsuarios() {
        return UsuarioList;
    }

    // Retorna usuario pelo id
    public Usuario getUsuario(int id) {
        for (Usuario Usuario : UsuarioList) {
            if (Usuario.getId() == id) {
                return Usuario;
            }
        }
        return null;
    }

    // Retorna usuario pelo nome e senha
    public Usuario getUsuario(String login, String senha) {
        for (Usuario Usuario : UsuarioList) {
            if (Usuario.getLogin().equals(login) && Usuario.getSenha().equals(senha)) {
                return Usuario;
            }
        }
        return null;
    }

    // Retorna quantidade de usuarios
    public int getQntUsuarios() {
        return quantidadeUsuarios;
    }
}