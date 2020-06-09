package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro Ahumada
 * @Github https://github.com/maurocastro29 
 */
public class Principal {
    
    public static void main(String[] Argv){
        Pila pila = new Pila();
        menu(pila);
        
    }
    public static void menu(Pila pila){
        int op;
        Nodo nuevo;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "      PILA\n"
                    + "1. Apilar\n"
                    + "2. Desapilar\n"
                    + "3. Ver tope\n"
                    + "4. Ver pila\n"
                    + "5. editar valor\n"    
                    + "6. Vaciar pila\n"
                    + "7. Tamaño pila\n"
                    + "8. Eliminar por Elemento\n"
                    + "9. Salir\n"
                    + "Entre su opción."
                    ));
            switch(op){
                case 1:{
                    int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
                    Nodo n = new Nodo(dato);
                    pila.apilar(n);
                    break;
                }
                case 2:{
                    Nodo aux = pila.desapilar();
                    JOptionPane.showMessageDialog(null, "Dato "+aux.getDato()+" desapilado con exito");
                    break;
                }
                case 3:{
                    pila.verTope();
                    break;
                }
                case 4:{
                    pila.mostrarPila();
                    break;
                }
                case 5:{
                    int b = new Integer(JOptionPane.showInputDialog("Digite el dato que desea editar"));
                    int e = new Integer(JOptionPane.showInputDialog("Digite el dato por el que desea editar"));
                    boolean sw = pila.editarDato(b, e);
                    if(sw){
                        JOptionPane.showMessageDialog(null, "Dato editado con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Dato no editado");
                    }
                    break;
                }
                case 6:{
                    pila.vaciarPila2();
                    break;
                }
                case 7:{
                    int tam = pila.tamanioPila();
                    JOptionPane.showMessageDialog(null, "El tamaño de la pila es: "+tam);
                    break;
                }
                case 8:{
                    int elim = new Integer(JOptionPane.showInputDialog("Digite un numero a eliminar"));
                    Nodo b = pila.eliminarXvalor(elim);
                    if(b!=null){
                        JOptionPane.showMessageDialog(null, "El dato: "+b.getDato()+" ha sido eliminado");
                    }else{
                        JOptionPane.showMessageDialog(null, "El dato: "+elim+" no ha sido eliminado");
                    }
                    break;
                }
                case 9:{
                    System.exit(0);
                    break;
                }
                default:{
                    
                    break;
                }
            }
        }while(op!=9);
    }
}
