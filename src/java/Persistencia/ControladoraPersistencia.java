
package Persistencia;

import Logica.Cliente;
import Logica.Empleado;
import Logica.Entrada;
import Logica.HorarioJuego;
import Logica.Juego;
import Logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    ClienteJpaController clienteJPA = new ClienteJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    EntradaJpaController entraJPA = new EntradaJpaController();
    HorarioJuegoJpaController horarioJPA = new HorarioJuegoJpaController();
    JuegoJpaController juegoJPA = new JuegoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    public void crearCliente(Cliente cliente) {
        try {
            clienteJPA.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearEmpleado(Empleado emple) {
        try {
            empleJPA.create(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearEntrada(Entrada entra) {
        try {
            entraJPA.create(entra);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
    public void crearHorarioJuego(HorarioJuego horario) {
        try {
            horarioJPA.create(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void crearJuego(Juego juego) {
        try {
            juegoJPA.create(juego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearUsuario(Usuario usuario) {
        try {
            usuJPA.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getUsuarios() {
            List<Usuario> listaUsuarios = usuJPA.findUsuarioEntities();
            return listaUsuarios;
    }
}
