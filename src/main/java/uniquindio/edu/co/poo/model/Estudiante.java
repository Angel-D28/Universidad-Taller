package uniquindio.edu.co.poo.model;

import javax.swing.*;

public class Estudiante {
    public String nombreEstudiante;
    public String idEstudiante;
    private Nota[] listaNotas;

    public Estudiante(String nombreEstudiante, String idEstudiante) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.listaNotas = new Nota[5];
    }

    public String agregarNota(String nombreNota , float valor){
        int posDisponible = -1;
        posDisponible = buscarPosicion();

        if (posDisponible == -1){
            return "no hay espacion disponible";
        }else {
            Nota nota = new Nota(nombreNota, valor);
            listaNotas[posDisponible]= nota;
            return "La nota se agrego exitosamente";
        }
    }


    public int buscarPosicion(){
        for (int i = 0; i < listaNotas.length; i++) {
            if(listaNotas [i]== null){
                return i;
            }
        }
        return -1;
    }

    public void eliminarNota(String nombreNota) {
        int posicion = buscarNota(nombreNota);
        if (posicion != -1) {
            listaNotas[posicion] = null;
        } else {
            JOptionPane.showMessageDialog(null, " Nota no encontrada.");
        }
    }

    public String modificarNota(String nombreNota, float nuevoValorNota) {
        String mensaje =" ";
        int posicion = buscarNota(nombreNota);
        if (posicion != -1) {
            listaNotas[posicion].setValor(nuevoValorNota); // Se actualiza correctamente
            mensaje += " Nota modificada correctamente.";
            return mensaje;
        }
        mensaje += " La nota no está registrada.";
        return mensaje;
    }

    public int buscarNota(String nombreNota) {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] != null && listaNotas[i].nombreNota.equals(nombreNota)) {
                return i;
            }
        }
        return -1;
    }
    public float calcularPromedio(){
        float sumatoria = 0;
        int contador = 0;
        float definitiva=0;
        for (int i = 0; i < listaNotas.length; i++){
            if(listaNotas[i] != null){
                sumatoria += listaNotas[i].getValor();
                contador++;
            }
        }
        if(contador == 0){
            return definitiva;
        }
        definitiva = sumatoria / contador;
        return definitiva;
    }
    public StringBuilder mostrarNotas() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Notas de ").append(nombreEstudiante)
                .append(" (ID: ").append(idEstudiante).append(")\n\n");

        boolean hayNotas = false;
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] != null) { // Verifica que la nota no sea null antes de acceder a sus métodos
                mensaje.append("✅ ").append(listaNotas[i].getNombreNota()) // Usa el getter de Nota
                        .append(": ").append(listaNotas[i].getValor()).append("\n");
                hayNotas = true;
            }
        }

        if (!hayNotas) {
            mensaje.append("⚠ No hay notas registradas.\n");
        } else {
            mensaje.append("\n📊 Promedio de Notas: ").append(calcularPromedio());
        }

        return mensaje;
    }



    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "nombreEstudiante='" + nombreEstudiante + '\'' +
                ", idEstudiante='" + idEstudiante + '\'' +
                '}';
    }
}
