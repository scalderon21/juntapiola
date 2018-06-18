package MisClases;


public class Evento {
    private String nombreEvento;
    private String tipoEvento;
    private int quorum;
    private int total;
    private String date;
    private String correoUsuario;
    private String Invitados[];

    public Evento(String nombreEvento, String tipoEvento, int quorum, int total, String date, String correoUsuario, String[] Invitados) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.quorum = quorum;
        this.total = total;
        this.date = date;
        this.correoUsuario = correoUsuario;
        this.Invitados = Invitados;
    }

    public Evento() {
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getQuorum() {
        return quorum;
    }

    public void setQuorum(int quorum) {
        this.quorum = quorum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String[] getInvitados() {
        return Invitados;
    }

    public void setInvitados(String[] Invitados) {
        this.Invitados = Invitados;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombreEvento=" + nombreEvento + ", tipoEvento=" + tipoEvento + ", quorum=" + quorum + ", total=" + total + ", date=" + date + ", correoUsuario=" + correoUsuario + ", Invitados=" + Invitados + '}';
    }
    
    
    
}
