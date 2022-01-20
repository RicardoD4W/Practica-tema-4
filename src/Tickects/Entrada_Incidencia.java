package Tickects;

public class Entrada_Incidencia {

    //ATRIBUTOS
    private int id;
    private UsuarioNormal usuarioNormal;        //el q pone la incidencia
    private String calendarAbierta;                  //dia   abietra
    private String calendarCerrada;                  //dia cerrada
    private Tecnico tecnico;                    //tecnico asignado a la incidencia
    private String comentario_usuario;
    private String comentario_tecnico;
    private String prioridad;
    private boolean resuelta;

    public Entrada_Incidencia(){
        id = 0;
        usuarioNormal = null;
        calendarAbierta = "";
        calendarCerrada = "";
        //tecnico = null;
        comentario_usuario = "";
        comentario_tecnico = "";
        prioridad = "";
        resuelta = false;
    }

//GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioNormal getUsuarioNormal() {
        return usuarioNormal;
    }

    public void setUsuarioNormal(UsuarioNormal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getComentario_usuario() {
        return comentario_usuario;
    }

    public void setComentario_usuario(String comentario_usuario) {
        this.comentario_usuario = comentario_usuario;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }


    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }


    //tostring


    @Override
    public String toString() {
        return "\nEntrada_Incidencia{" +
                "id=" + id +
                "\n, usuarioNormal=" + usuarioNormal +
                ", destino='" + getUsuarioNormal().getDestino() + '\'' +
                "\n, Fecha de Inicio=" + calendarAbierta +
                "\n, tecnico=" + tecnico +
                ", comentario_usuario='" + comentario_usuario + '\'' +
                ", comentario_tecnico='" + comentario_tecnico + '\'' +
                ", prioridad='" + prioridad + '\'' +
                "\n, Fecha fin" + calendarCerrada +
                ", resuelta=" + resuelta +
                '}';
    }

    public String toStringnResuelta() {

        return "\nIncidencia con ID: " + id +
                "\nAbierta por: " + usuarioNormal.getNombre() +
                ", destino='" + getUsuarioNormal().getDestino() + '\'' +
                "\nAsignada al Técnico: " + tecnico.getNombre() + " " + tecnico.getApellido1() +
                "\nComentarios: " + comentario_usuario +
                "\nPrioridad: " + prioridad +
                "\nFecha de creación: " + calendarAbierta +
                "\nResuelta: " + resuelta ;
    }

    public String toStringnResuelta(int trampa) {

        return "\nIncidencia con ID: " + id +
                "\nComentarios: " + comentario_usuario +
                "\nPrioridad: " + prioridad +
                "\nFecha de creación: " + calendarAbierta +
                "\nResuelta: " + resuelta ;
    }

    public String toStringResuelta() {

        return "\nIncidencia con ID: " + id +
                "\nAbierta por: " + usuarioNormal.getNombre() +
                ", destino='" + getUsuarioNormal().getDestino() + '\'' +
                "\nSolucionada por el técnico: " + tecnico.getNombre() + " " + tecnico.getApellido1() +
                "\nComentarios del usuario: " + comentario_usuario +
                "\nComentarios del técnico: " + comentario_tecnico +
                "\nPrioridad: " +prioridad +
                "\nFecha creación: " + calendarAbierta +
                "\nFecha resolución: " + calendarCerrada +
                "\nResuelta: " + resuelta ;
    }

    public String getComentario_tecnico() {
        return comentario_tecnico;
    }

    public void setComentario_tecnico(String comentario_tecnico) {
        this.comentario_tecnico = comentario_tecnico;
    }

    public String getCalendarAbierta() {
        return calendarAbierta;
    }

    public void setCalendarAbierta(String calendarAbierta) {
        this.calendarAbierta = calendarAbierta;
    }

    public String getCalendarCerrada() {
        return calendarCerrada;
    }

    public void setCalendarCerrada(String calendarCerrada) {
        this.calendarCerrada = calendarCerrada;
    }
}

