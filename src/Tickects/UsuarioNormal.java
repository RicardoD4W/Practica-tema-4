package Tickects;

public class UsuarioNormal {
    //Puede meter incidencias y comprobar el estado de las mismas. Se puede dar de
    //alta desde el mismo programa

    //ATRIBUTOS
    private String nombre;
    private String usuario;
    private String contraseña;

    private String destino;
    private String mensaje;
    private String asunto;


    //GETTERS & SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //tostring


    @Override
    public String toString() {
        return "UsuarioNormal{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
