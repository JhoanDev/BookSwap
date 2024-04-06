package model;

public class LoginModel {
    public static boolean verificaLogin(String login, String senha) {
        UsuariosRepo listusers = UsuariosRepo.getInstance();
        for (Usuario usuario : listusers.getAllUsuarios()) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
