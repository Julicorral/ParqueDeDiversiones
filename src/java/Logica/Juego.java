
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Juego implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
    int id_juego;
    @Basic
    String nombre;
    int capacidad;
    int edadMinima;

    public Juego() {
    }

    public Juego(int id_juego, String nombre, int capacidad, int edadMinima) {
        this.id_juego = id_juego;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.edadMinima = edadMinima;
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
    
    
}
