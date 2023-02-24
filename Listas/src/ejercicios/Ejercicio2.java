package ejercicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {
        //Realizar un algoritmo que permita almacenar
        //los nombres de los deportistas de un equipo de futbol.
        //El programa debe ofrecer la opcion de terminar despus de
        //ingresar un deportista
        //Finalmente muestrar los deportistas
        ArrayList <String>lista=new ArrayList();
        String nom, out="";
        int op;
        do {
            nom=JOptionPane.showInputDialog("Ingrese Nombre deportista");
            lista.add(nom);
            op=JOptionPane.showConfirmDialog(null,"Desea Continuar?");
        } while (op!=1);
        for (String dato : lista) {
           out+=dato+"\n"; 
        }
        JOptionPane.showMessageDialog(null, out);
    }
    
}
