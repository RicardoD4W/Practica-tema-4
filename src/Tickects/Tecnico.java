package Tickects;

public class Tecnico {
    //Puede comprobar qué incidencias tiene asignadas y marcar las mismas como
    //completadas. Los da de alta el administrador.

    //ATRIBUTOS
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String codigo;
    private String contraseña;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void borrarTecnico(){
        setNombre("");
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tecnico(){
        nombre = "";
        apellido1 = "";
        apellido2 = "";
        codigo = "";
        contraseña = "";
    }

    public Tecnico(String nombre, String apellido1, String apellido2){
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                '}';
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
}
