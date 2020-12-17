
package Logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {
    @Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
    int id_cliente;
    @Basic
    String nombre;
    String apellido;
    String dni;
    @Temporal(TemporalType.DATE)
    Calendar fechaNacimiento;
    @OneToMany
    List <Entrada> listaEntradasCliente;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String dni, Calendar fechaNacimiento, List<Entrada> listaEntradasCliente) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.listaEntradasCliente = listaEntradasCliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

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

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Entrada> getListaEntradasCliente() {
        return listaEntradasCliente;
    }

    public void setListaEntradasCliente(List<Entrada> listaEntradasCliente) {
        this.listaEntradasCliente = listaEntradasCliente;
    }

      
    
    
}

