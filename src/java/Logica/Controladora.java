
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private List<Usuario> listaUsuarios;
    private List<Juego> listaJuego;
    private List<Cliente> listaCliente;
    private List<Entrada> listaEntrada;
    private List<Empleado> listaEmpleado;
    
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
    
    public void modificarCliente(String id, String apellido, String nombre, String dni, String fechaNac) {
        
        Cliente cliente = controlPersis.getCliente(Integer.parseInt(id));
        
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
        
        controlPersis.actualizarCliente(cliente);

    }
    
    public void eliminarCliente(int id) {
                
        controlPersis.eliminarCliente(id);

    }
    
    public void crearEntrada(String id_juego, String fecha, String hora, String id_cliente) {
        
        Controladora control = new Controladora();
        Entrada entrada = new Entrada();
        
        Cliente cliente = control.getCliente(Integer.parseInt(id_cliente));
        Juego juego = control.getJuego(Integer.parseInt(id_juego));

        SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
        try {
            Calendar fechaEntrada = Calendar.getInstance();
            Calendar horaEntrada = Calendar.getInstance();

            fechaEntrada.setTime(sdfFecha.parse(fecha));
            horaEntrada.setTime(sdfHora.parse(hora));

            entrada.setFecha(fechaEntrada);
            entrada.setHora(horaEntrada);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        controlPersis.crearEntrada(entrada);
        
        List<Entrada> entradasCliente = cliente.getListaEntradasCliente();
        entradasCliente.add(entrada);
        cliente.setListaEntradasCliente(entradasCliente);
        controlPersis.actualizarCliente(cliente);

        List<Entrada> entradasJuego = juego.getListaEntradas();
        entradasJuego.add(entrada);
        juego.setListaEntradas(entradasJuego);
        controlPersis.actualizarJuego(juego);
    }

    public Boolean comprobarIngreso(String usuario, String pass) {    
        
        listaUsuarios = controlPersis.getUsuarios();
        
        for (Usuario usu : listaUsuarios) {
            if(usu.getNombreUsuario().equals(usuario) && usu.getPassword().equals(pass)) {
            
            return true;
            }
        }
        
        return false;
    }
    
    public List<Juego> getListaJuego(){
        
        listaJuego = controlPersis.getJuego();
        
        return listaJuego;
    }
    
    public List<Cliente> getListaCliente(){
        
        listaCliente = controlPersis.getClienteList();
        
        return listaCliente;
    }
    
    public List<Usuario> getListaUsuario(){
        
        try {
            listaUsuarios = controlPersis.getUsuarios();
        } catch(Exception e) {
            return null;
        }
        
        return listaUsuarios;
    }
    
    public List<Empleado> getListaEmpleado(){
        
        listaEmpleado = controlPersis.getEmpleadoList();
        
        return listaEmpleado;
    }
    
    public void crearUsuario(String user, String pass) {
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(user);
        usuario.setPassword(pass);
        
        controlPersis.crearUsuario(usuario);

    }
    
    public Boolean comprobarHorarioJuego(String sHora, String sJuego){
        int id_juego = Integer.parseInt(sJuego);
        Juego juego = controlPersis.getJuego(id_juego);

        Calendar hora = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        try {
            hora.setTime(sdf.parse(sHora));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (juego.getHoraInicio().after(hora) || juego.getHoraCierre().before(hora)) {
            return false;
        } 
        
        return true;
    }
    
    public Boolean comprobarCantidadEntradas(String sHora, String sJuego){
        int id_juego = Integer.parseInt(sJuego);
        Juego juego = controlPersis.getJuego(id_juego);

        Calendar hora = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        try {
            hora.setTime(sdf.parse(sHora));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<Entrada> todasLasEntradas = juego.getListaEntradas();
        List<Entrada> entradas = new ArrayList<>();
        
        for (Entrada e : todasLasEntradas) {
            if (e.getHora().equals(hora)){
                entradas.add(e);
            }
        }
        
        if (juego.capacidad <= entradas.size() ) {
            return false;
        }
        
        return true;
    }
    
    public List<Entrada> getListaEntrada(){
        
        listaEntrada = controlPersis.getEntradaList();
        
        return listaEntrada;
    }
    
    public Cliente getCliente(int id_cliente){
        return controlPersis.getCliente(id_cliente);
    }
    
    public Juego getJuego(int id_juego){
        return controlPersis.getJuego(id_juego);
    }

    public void crearEmpleado(String apellido, String nombre, String dni, String cargo, String id_usuario) {
        
        Usuario usuario = controlPersis.getUsuario(Integer.parseInt(id_usuario));
        
        Empleado empleado = new Empleado();
        empleado.setApellido(apellido);
        empleado.setNombre(nombre);
        empleado.setDni(dni);
        empleado.setCargo(cargo);
        empleado.setUnUsuario(usuario);
        
        controlPersis.crearEmpleado(empleado);

    }
}