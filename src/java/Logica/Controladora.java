
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private List<Usuario> listaUsuarios;

    void crearUsuario(Usuario usu) {
        controlPersis.crearUsuario(usu);
    }

    void crearEmpleado(Empleado emple) {
        controlPersis.crearEmpleado(emple);
    }


    void crearJuego(Juego juego) {
        controlPersis.crearJuego(juego);
    }

    void crearHorario(HorarioJuego horario) {
        controlPersis.crearHorarioJuego(horario);
    }

    void crearCliente(Cliente cliente) {
        controlPersis.crearCliente(cliente);
    }

    void crearEntrada(Entrada entra) {
        controlPersis.crearEntrada(entra);
    }

    public void crearCliente(String apellido, String nombre, String dni, String fechaNac) {
        
        Cliente cliente = new Cliente();
        cliente.setApellido(apellido);
        cliente.setNombre(nombre);
        cliente.setDni(dni);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(sdf.parse(fechaNac));
        cliente.setFechaNacimiento(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        controlPersis.crearCliente(cliente);

    }

    public Boolean comprobarIngreso(String parameter, String parameter0) {
        Boolean siONo = false;
        
        listaUsuarios = controlPersis.getUsuarios();
        
        for (usario usu : listaUsuarios) {
            if(usu.getUsuarios.equals(usuario) && usu.getContrasenia.equals(pass)){
            siONo = true;
            return siONo;
            }
        }
        
        return siONo;
    }
}