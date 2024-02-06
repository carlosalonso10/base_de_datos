package Models;

public class Personas {

    private Integer id;
    private String  nombres;
    private String apellidos;
    private Integer telefono;
    private Integer edad;
    private String correo;

    private String direccion;
    //
    public Personas(Integer id, String nombres, String apellidos, Integer telefono, Integer edad, String correo, String direccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Personas() {


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion(){return correo;}
    public  void setDireccion(String direccion){this.direccion = direccion;



    }
}
