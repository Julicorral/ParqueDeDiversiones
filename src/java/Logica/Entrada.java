
package Logica;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_entrada;
    @Temporal(TemporalType.DATE)
    Calendar fecha;
    @Temporal(TemporalType.TIME)
    Calendar hora;

    public Entrada() {
    }

    public Entrada(int id_entrada, Calendar fecha, Calendar hora) {
        this.id_entrada = id_entrada;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }
    
}
