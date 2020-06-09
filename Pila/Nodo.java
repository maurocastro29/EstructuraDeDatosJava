package logica;

/**
 *
 * @author Mauricio Castro Ahumada
 * @Github https://github.com/maurocastro29 
 */
public class Nodo {
    private int dato; //guardara el valor del nodo
    private Nodo ant; // permitira acceder al nodo debajo del actual
    Nodo() {// Metodo constructor sin valor
        this.ant = null;
    }
    public Nodo(int dato) {// Metodo constructor con valor
        this.dato = dato;
        this.ant = null;
    }
    
    //GETTER Y SETTER DE LOS ATRIBUTOS
    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
    public Nodo getAnt() {
        return ant;
    }
    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    
}
