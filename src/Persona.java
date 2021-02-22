public class Persona {

    private Integer Id;
    private String Nombre;
    private String Apellido;


    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellido) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Integer getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }






}