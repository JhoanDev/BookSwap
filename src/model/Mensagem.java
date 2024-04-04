package model;

public class Mensagem {
    private String mensagem;
    private boolean lida;
    private Usuario remetente;
    private Usuario destinatario;

    public Mensagem(String mensagem, Usuario remetente, Usuario destinatario) {
        this.mensagem = mensagem;
        this.lida = false;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public Usuario getRemetente() {
        return remetente;
    }  

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public void enviarMensagem(Usuario destinatario) {
        destinatario.adicionaMensagem(this);    
    }

    @Override
    public String toString() {
        return String.format("Mensagem{mensagem=%s, lida=%b, remetente=%s}", mensagem, lida, remetente.getNome());
    }
}
