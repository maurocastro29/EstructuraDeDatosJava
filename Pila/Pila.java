package logica;

/**
 *
 * @author Mauricio Castro Ahumada
 * @Github https://github.com/maurocastro29 
 */
import javax.swing.JOptionPane;

public class Pila {
    private Nodo tope;// TOPE DE LA PILA

    public Pila() {//Constructor de la pila
        this.tope = null;
    }
    //Getter y setter de la pila
    public Nodo getTope() {
        return tope;
    }
    public void setTope(Nodo tope) {
        this.tope = tope;
    }
    public boolean isVacia(Nodo tope){//preguntamos si la pila esta vacia
        return tope == null;
    }
    
    public void apilar(Nodo nodo){//Apila un nodo a la pila
        if(isVacia(this.getTope())){//Caso pila vacia
            this.setTope(nodo); // Ingresa directamente a la pila
        }else{                      //caso pila no vacia
            nodo.setAnt(this.getTope());
            this.setTope(nodo);
        }
    }
    public Nodo desapilar(){//Desapila un nodo a la pila
        if(!isVacia(this.getTope())){//Caso no vacia
            Nodo aux = this.getTope(); //Crea un auxiliar y lo coloca en el tope de la pila
            this.setTope(this.getTope().getAnt()); //Cambiamos el tope de la pila por el que este debajo
            aux.setAnt(null);
            return aux;  //Retorna el nodo que estaba en el tope de la pila
        }
        return null; //En caso que la pila este vacia retorna null
    }
    public void verTope(){//Permite ver el valor del tope de la pila
        if(!isVacia(this.getTope())){ // Caso pila no vacia
            JOptionPane.showMessageDialog(null, "El tope de la pila es: "+this.getTope().getDato());
        }else{                        // Caso pila no vacia
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        }
    }
    public void mostrarPila(){//Permite ver el valor de toda la pila
        if(!isVacia(this.getTope())){// Caso pila no vacia
            Nodo aux = this.getTope();
            while(!this.isVacia(aux)){ // Se recorre la pila a medida que se muestran sus valores
                JOptionPane.showMessageDialog(null, "["+aux.getDato()+"]");
                aux = aux.getAnt();
            }
        }else{                      // Caso pila no vacia
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        }
    }
    public int tamanioPila(){ // Nos permite saber el tamaño de la pila
        int i=0; // inicializamos un contador en 0
        if(!isVacia(this.getTope())){ // Caso pila no vacia
            Nodo aux = this.getTope();
            while(!this.isVacia(aux)){ // Se recorre la pila a medida que se cuentan sus nodos
                i++;
                aux = aux.getAnt();
            }
        }
        return i; // Se devuelve el valor final del contador
    }
    public void vaciarPila1(){ //Forma 1 de vaciar una pila
        if(!isVacia(this.getTope())){
            while(!this.isVacia(this.getTope())){
                Nodo aux = desapilar();
            }
        }
    }
    public void vaciarPila2(){//Forma 2 de vaciar una pila
        if(!isVacia(this.getTope())){
            this.setTope(null);
        }
    }
    //metodo buscar
    public boolean buscar(int elem){// Busca un dato en la pila 
        Nodo aux = this.getTope(); // Se crea un auxiliar de la pila
        if(!isVacia(aux)){ // caso no vacia
            while(!isVacia(aux)){ // Se recorre la pila mientras tenga elementos
                if(aux.getDato() == elem){ // Se pregunta si el dato actual es el que buscamos
                    return true; //Devuelve TRUE si es el que buscamos
                }
                aux = aux.getAnt(); // Pasa al siguiente nodo en caso que no lo encontremos
            }
        }
        return false; //Devuelve FALSE si no encontramos el dato
    }
    public Nodo buscarNodo(int elem){// Busca un nodo en la pila 
        Nodo aux = this.getTope(); // Auxiliar de pila
        if(!isVacia(aux)){// caso no vacia
            while(!isVacia(aux)){// Se recorre la pila mientras tenga elementos
                if(aux.getDato() == elem){// Se pregunta si el nodo actual es el que buscamos
                    return aux;//Devuelve el NODO si es el que buscamos
                }
                aux = aux.getAnt();// Pasa al siguiente nodo en caso que no lo encontremos
            }
        }
        return null;//Devuelve null si no encontramos el dato
    }
    public Nodo eliminarXvalor(int datoElim){//dado un valor buscar en la pila si existe y eliminarlo de la pila
        Nodo b = buscarNodo(datoElim); // Se verifica si el dato existe con el metodo boscarNodo()
        Nodo elim = null; // Se crea un auxiliar para eliminar el nodo.
        if(b!=null){ // En caso que exista el nodo a eliminar
            if(b == this.getTope()){ // Si el nodo a eliminar esta en el tope
                elim = this.desapilar(); //Se desapila y se pasa al auxiliar eliminar
            }else{ // Si el nodo a eliminar no esta en el tope
                Pila pilaAux = new Pila();  // Se crea una pila auxiliar
                Nodo aux = this.getTope();  // Se crea un auxiliar para la pila original
                Nodo aux2 = null;  // Se crea un auxiliar para quitar el tope de la pila original
                while(aux != b){ //Se recorre la pila original mientras no este en el nodo a eliminar
                    aux2 = this.desapilar(); // Se desapila el nodo de la pila original
                    aux = this.getTope(); // Se coloca en el tope de la pila
                    pilaAux.apilar(aux2); //Se ingresa el nodo quitado en la pila auxiliar
                }
                elim = this.desapilar(); // Se quita el nodo a eliminar de la pila original y  se pasa al auxilair eliminar
                while(!isVacia(pilaAux.getTope())){// Se recorre la pila auxiliar hasta quedar vacia
                    aux2 = pilaAux.desapilar(); // Se desapila de la pila auxiliar 
                    this.apilar(aux2); // Se apila en la pila original de nuevo
                }
            }
        }
        return elim; // Retorna el nodo eliminado de la pila.
    }
    public boolean editarDato(int buscar, int editar){
        Nodo edit = buscarNodo(buscar);
        if(edit!=null){
            if(edit==this.getTope()){
                this.getTope().setDato(editar);//Se edita el valor del tope de la pila
                return true; // Retorna TRUE para especificar que se hizo el cambio
            }else{
                Pila pilaAux = new Pila();  // Se crea una pila auxiliar
                Nodo aux = this.getTope();  // Se crea un auxiliar para la pila original
                Nodo aux2 = null;  // Se crea un auxiliar para quitar el tope de la pila original
                while(aux != edit){ //Se recorre la pila original mientras no este en el nodo a editar
                    aux2 = this.desapilar(); // Se desapila el nodo de la pila original
                    aux = this.getTope(); // Se coloca en el tope de la pila
                    pilaAux.apilar(aux2); //Se ingresa el nodo quitado en la pila auxiliar
                }
                this.getTope().setDato(editar);//Se edita el valor del tope de la pila
                
                while(!isVacia(pilaAux.getTope())){// Se recorre la pila auxiliar hasta quedar vacia
                    aux2 = pilaAux.desapilar(); // Se desapila de la pila auxiliar 
                    this.apilar(aux2); // Se apila en la pila original de nuevo
                }
                return true; // Retorna TRUE para especificar que se hizo el cambio
            }
        }
        return false;
    }
}
