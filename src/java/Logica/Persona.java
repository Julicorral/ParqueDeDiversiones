
package Logica;

import javax.persistence.Basic;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {
    @Basic
    String nombre;
    String apellido;
    String dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Persona() {
    }
}
