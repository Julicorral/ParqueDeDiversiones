
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
public class Juego implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
    int id_juego;
    @Basic
    String nombre;
    int capacidad;
    int edadMinima;
    @Temporal(TemporalType.TIME)
    Calendar horaInicio;
    @Temporal(TemporalType.TIME)
    Calendar horaCierre;
    @OneToMany
    List <Empleado> listaEmpleados;
    @OneToMany
    List <Entrada> listaEntradas;
    

    public Juego() {
    }

    public Juego(int id_juego, String nombre, int capacidad, int edadMinima, Calendar horaInicio, Calendar horaCierre, List<Empleado> listaEmpleados, List<Entrada> listaEntradas) {
        this.id_juego = id_juego;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.edadMinima = edadMinima;
        this.horaInicio = horaInicio;
        this.horaCierre = horaCierre;
        this.listaEmpleados = listaEmpleados;
        this.listaEntradas = listaEntradas;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Calendar horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    
    
}
