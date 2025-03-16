package uniquindio.edu.co.poo.model;

import javax.swing.*;
import java.util.ArrayList;

public class Universidad {
    private ArrayList<Estudiante> listaEstudiantes;
    private String nombre ;
    private String ubicacion;

    public Universidad(String nombre, String ubicacion, ArrayList<Estudiante> listaEstudiantes ) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = listaEstudiantes;

    }

    public String agregarNotaEstudiante(String idEstudiante, String nombreNota, float valor) {
        String mensaje = "";
        Estudiante estEncontrado = buscarEstudiante(idEstudiante);

        if (estEncontrado != null) {
            mensaje = estEncontrado.agregarNota(nombreNota, valor);
            return mensaje;
        }else{
            mensaje = "El Estudiante no existe";
        }
        return mensaje;
    }

    public void eliminarNotaEstudiante(String idEstudiante, String nombreNota) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).idEstudiante.equals(idEstudiante)) {
                listaEstudiantes.get(i).eliminarNota(nombreNota);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Estudiante no encontrado");
    }

    public String modificarNotaEstudiante(String idEstudiante, String nombreNota, float valor) {
        String mensaje="";
        Estudiante estEncontrado= buscarEstudiante(idEstudiante); {
            if (estEncontrado != null) {
                estEncontrado.modificarNota(nombreNota, valor);
                mensaje="La nota del Estudiante se ha modificado con exito";
                return mensaje;
            }
                mensaje="El Estudiante no existe";
                return mensaje;
            }
    }

    public String mostrarNotaEstudiante(String idEstudiante) {
        Estudiante estEncontrado = null;
        Estudiante estudianteAmostrar=null;
        String mensaje = null ;

        estEncontrado = buscarEstudiante(idEstudiante);
        if(estEncontrado != null){
            estudianteAmostrar = estEncontrado;
            mensaje = estudianteAmostrar.mostrarNotas().toString();
        }else {
            mensaje = estudianteAmostrar.mostrarNotas().toString();
        }
        return mensaje;
    }

    public String agregarEstudiante(String nombreEstudiante, String idEstudiante) {
        String mensaje=" ";
        Estudiante estEncontrado = null;
        Estudiante nuevoEstudiante =null;

        estEncontrado = buscarEstudiante(idEstudiante);
        if (estEncontrado != null) {//Ya existe en el sistema
            mensaje ="El estudiante "+estEncontrado.getNombreEstudiante()+" ya existe";
            return mensaje;
            }
        nuevoEstudiante = new Estudiante(nombreEstudiante, idEstudiante);
        listaEstudiantes.add(nuevoEstudiante);
        mensaje += "Estudiante " + nombreEstudiante+ " xagregado exitosamente ";
        return mensaje;
    }

    public Estudiante buscarEstudiante(String idEstudiante) {
        Estudiante estEncontrado = null;
        for(Estudiante estudianteAux : listaEstudiantes) {
            if(estudianteAux.getIdEstudiante().equals(idEstudiante)){
                return estudianteAux;
            }
        }
        return estEncontrado;
    }

    public String eliminarEstudiante(String idEstudiante) {
        String mensaje=" ";
        Estudiante estEncontrado = null;
        Estudiante estudianteAeliminar =null;

        estEncontrado = buscarEstudiante(idEstudiante);
        if(estEncontrado != null) {
            estudianteAeliminar = estEncontrado;
            listaEstudiantes.remove(estudianteAeliminar);
            mensaje =  "Estudiante eliminado correctamente";
            return mensaje;
        }
        mensaje = "Estudiante no encontrado";
        return mensaje;
    }


    public String mostrarEstudiantes() {
        if (listaEstudiantes.size() == 0) {
            String mensaje = "La lista esta vacía";
            return mensaje;
        }
        String mensaje = "Lista de estudiantes\n\n";
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudianteAux = listaEstudiantes.get(i);
            String promedio;
            if (estudianteAux.calcularPromedio() == -1) {
                promedio = "Sin notas registradas";
            } else {
                promedio = String.valueOf(estudianteAux.calcularPromedio());
            }
            mensaje += ("ID(" + estudianteAux.getIdEstudiante() + ") \nNombre: " + estudianteAux.getNombreEstudiante() + "\n promedio Notas: " + promedio + "\n");

        }
        return mensaje;
    }
    public Estudiante obtenerEstudianteMayorPromedio(){
        if(listaEstudiantes.size() == 0){
            return null ;
        }
        Estudiante mejorEstudiante = null;
        double mejorPromedio= -1;

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            double promedio = listaEstudiantes.get(i).calcularPromedio();
            if(promedio > mejorPromedio){
                mejorEstudiante = listaEstudiantes.get(i);
                mejorPromedio = promedio;
            }
        }
        return mejorEstudiante;
    }

    public void mostrarEstudianteMayorPromedio(){
        Estudiante mejorEstudiante = obtenerEstudianteMayorPromedio();

        if(mejorEstudiante == null){
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        String mensaje = "Estudiante con mayor promedio\n\n";
        mensaje+= "ID: " + mejorEstudiante.getIdEstudiante() + "\n\n";
        mensaje+= "Nombre: " + mejorEstudiante.getNombreEstudiante() + "\n";
        mensaje+="Promedio: "+mejorEstudiante.calcularPromedio();

        JOptionPane.showMessageDialog(null, mensaje);
    }

}

