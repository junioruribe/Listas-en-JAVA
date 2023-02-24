package ejercicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio3 {

    static ArrayList<String> lista;

    public static void main(String[] args) {
        lista = new ArrayList();
        int op;
        String menu = "Gestionar deportista:\n";
        menu += "1. Registrar deportista\n";
        menu += "2. Mostrar deportistas\n";
        menu += "3. Buscar deportista\n";
        menu += "4. Eliminar deportista\n";
        menu += "5. Actualizar deportista\n";
        menu += "6. Salir";
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {
                case 1:
                    registrar();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    actualizar();
                    break;
            }
        } while (op != 6);
    }

    public static void registrar() {
        String nom;
        nom = JOptionPane.showInputDialog("Ingrese nombre del deportista");
        lista.add(nom);
        mensaje("Deportista registrado");
    }

    public static void mensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void mostrar() {
        String out = "DEPORTISTAS:\n";
        for (String nombre : lista) {
            out += nombre + "\n";
        }
        mensaje(out);
    }

    public static void buscar() {
        if (lista.isEmpty() == false) {
            String nom;
            nom = JOptionPane.showInputDialog("Ingrese nombre del deportista");
            for (String deportista : lista) {
                if (deportista.equalsIgnoreCase(nom)) {
                    mensaje("El deportista esta en la lista");
                    break;
                }
            }
        } else {
            mensaje("Lista vacia");
        }
    }

    public static void eliminar() {
        if (lista.size() > 0) {
            String nom;
            nom = JOptionPane.showInputDialog("Ingrese nombre del deportista");
            for (int i = 0; i < lista.size(); i++) {
                if (nom.equalsIgnoreCase(lista.get(i))) {
                    lista.remove(i);
                    break;
                }
            }
        } else {
            mensaje("Lista vacia");
        }
    }
    
    public static void actualizar(){
        if (lista.isEmpty()) {
           mensaje("Lista vacia"); 
        } else {
          String nom;
          nom = JOptionPane.showInputDialog("Ingrese nombre del deportista");
          int pos=getposicion(nom);
            if (pos==-1) {
                mensaje("No se encontro el deportista");
            } else {
               nom = JOptionPane.showInputDialog("Ingrese nuevo nombre del deportista");
               lista.set(pos, nom);
               mensaje("Nombre actualizado");
            }
        }
    }
    
    public static int getposicion(String nom){
        for (int i = 0; i < lista.size(); i++) {
            if (nom.equalsIgnoreCase(lista.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
