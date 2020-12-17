
package Logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HorarioJuego implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
    int id_horario;
    @Temporal(TemporalType.TIME)
    Calendar horaInicio;
    @Temporal(TemporalType.TIME)
    Calendar horaFin;
    @OneToMany
    List <Juego> listaJuegos;

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Calendar horaFin) {
        this.horaFin = horaFin;
    }

    public List<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(List<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }

    public HorarioJuego(int id_horario, Calendar horaInicio, Calendar horaFin, List<Juego> listaJuegos) {
        this.id_horario = id_horario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaJuegos = listaJuegos;
    }

    public HorarioJuego() {
    }
}
