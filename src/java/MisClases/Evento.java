package MisClases;

import java.util.Date;

public class Evento {
    private int idEvento;
    private String nombreEvento;
    private String tipoEvento;
    private int quorum;
    private int total;
    private Date date;
    private String correoUsuario;
    private String Invitados[];

    public Evento() {
    }

    public Evento(String nombreEvento, String tipoEvento, int quorum, int total, Date date, String correoUsuario) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.quorum = quorum;
        this.total = total;
        this.date = date;
        this.correoUsuario = correoUsuario;
    }

    public Evento(String nombreEvento, String tipoEvento, int quorum, int total, Date date, String correoUsuario, String[] Invitados) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.quorum = quorum;
        this.total = total;
        this.date = date;
        this.correoUsuario = correoUsuario;
        this.Invitados = Invitados;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
