package ejercicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio4 {

    static ArrayList<String[]> lista;

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
        String nom,ced;
        String v[]=new String[2];
        ced = JOptionPane.showInputDialog("Ingrese cedula del deportista");
        if (validar(ced)) {
            mensaje("Deportista ya existe");
        } else {
           nom = JOptionPane.showInputDialog("Ingrese nombre del deportista");
           v[0]=ced;
           v[1]=nom;
           lista.add(v);
           mensaje("Deportista registrado");
        }
        
    }

    public static void mensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void mostrar(){
        if (lista.isEmpty()) {
            mensaje("Lista vacia");
        } else {
            String out="";
            for (String[] v : lista) {
                out+="Cedula:"+v[0]+" Nombre:"+v[1]+"\n";
            }
            mensaje(out);
        }
    }
    
    public static void buscar(){
        String ced;
        if (lista.size()>0) {
           ced = JOptionPane.showInputDialog("Ingrese cedula del deportista");
           int pos=getPosicion(ced);
            if (pos==-1) {
                mensaje("No se encontro el deportista");
            } else {
                String out="Informacion deportista:\n";
                out+="Cedula:"+lista.get(pos)[0]+"\n";
                out+="Nombre:"+lista.get(pos)[1];
                mensaje(out);
            }
        } else {
           mensaje("Lista vacia"); 
        }
    }   
    
    public static int getPosicion(String ced){
        for (int i = 0; i < lista.size(); i++) {
            String v[];
            v=lista.get(i);
            if (ced.equals(v[0])) {
               return i; 
            }
        }
        return -1;
    }
    
    public static void eliminar(){
        String ced;
        if (lista.isEmpty()) {
            mensaje("lista vacia");
        } else {
           ced = JOptionPane.showInputDialog("Ingrese cedula del deportista"); 
            int pos=getPosicion(ced);
           if (pos!=-1) {
                lista.remove(pos);
            } else {
                mensaje("Cedula no existe");
            }
        }
    }
    
    public static void actualizar(){
        String ced,nom;
        if (lista.isEmpty()) {
           mensaje("Lista vacia"); 
        } else {
            ced = JOptionPane.showInputDialog("Ingrese cedula del deportista");
            int pos =getPosicion(ced);
            if (pos!=1) {
                nom = JOptionPane.showInputDialog("Ingrese nuevo nombre del deportista");
                lista.get(pos)[1]=nom;
                mensaje("Deportista actualizado");
            } else {
                mensaje("No existe el deportista");
            }
        }
    }
    
    public static boolean validar(String ced){
        for (String[] v : lista) {
            if (ced.equals(v[0])) {
                return true;
            }
        }
        return false;
    }

}
