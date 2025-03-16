package uniquindio.edu.co.poo.app;

import uniquindio.edu.co.poo.model.Universidad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad("Uniquindio" , "carrera 15",new ArrayList<>());
        while(true){
            String opcion = JOptionPane.showInputDialog(
                    "📚 MENÚ UNIVERSIDAD 📚\n\n" +
                            "1- Agregar estudiante\n" +
                            "2- Eliminar estudiante\n" +
                            "3- Modificar nota de estudiante\n" +
                            "4- Eliminar nota de estudiante\n" +
                            "5- Mostrar notas de un estudiante\n" +
                            "6- Mostrar todos los estudiantes\n" +
                            "7- Mostrar estudiante con mayor promedio\n" +
                            "8- Agregar nota a estudiante\n" +
                            "9- Salir\n\n" +
                            "Seleccione una opción:"
            );

            if (opcion == null)break;

            switch(opcion){
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                    String idEstudiante = JOptionPane.showInputDialog("Ingrese el id: ");
                    String mensaje = universidad.agregarEstudiante(nombre,idEstudiante);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "2":
                    String idEstudiante2 = JOptionPane.showInputDialog("Ingrese el ID de el estudiante que quiere eliminar: ");
                    mensaje = universidad.eliminarEstudiante(idEstudiante2);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "3":
                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del estudiante:");
                    String notaModificar = JOptionPane.showInputDialog("Ingrese nombre de la nota a modificar:");
                    float nuevoValor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nuevo valor de la nota:"));
                    mensaje = universidad.modificarNotaEstudiante(idModificar, notaModificar, nuevoValor);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "4":
                    String idEliminarNota = JOptionPane.showInputDialog("Ingrese ID del estudiante:");
                    String nombreEliminarNota = JOptionPane.showInputDialog("Ingrese nombre de la nota a eliminar:");
                    universidad.eliminarNotaEstudiante(idEliminarNota, nombreEliminarNota);
                    break;

                case "5":
                    String idMostrarNotas = JOptionPane.showInputDialog("Ingrese ID del estudiante:");
                    String notas = universidad.mostrarNotaEstudiante(idMostrarNotas);
                    JOptionPane.showMessageDialog(null, notas );
                    break;

                case "6":
                    mensaje =  universidad.mostrarEstudiantes();
                    JOptionPane.showMessageDialog(null,mensaje);
                    break;

                case "7":
                    universidad.mostrarEstudianteMayorPromedio();
                    break;

                case "8":
                    String idEstudiante5 = JOptionPane.showInputDialog("Ingrese ID del estudiante a para agregar nota:");
                    String nombreNota = JOptionPane.showInputDialog("Ingrese nombre de la nota :");
                    float valorNota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese valor de la nota:"));
                    universidad.agregarNotaEstudiante(idEstudiante5, nombreNota, valorNota);
                    break;

                case "9":
                    JOptionPane.showMessageDialog(null, "🚪 Saliendo del sistema...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "⚠ Opción inválida, intente de nuevo.");

            }
        }
    }
}