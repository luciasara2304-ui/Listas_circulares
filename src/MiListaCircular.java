public class MiListaCircular implements ListInterface {

    private Node cabeza;
    private Node cola;
    private int size;

    public MiListaCircular() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    /*
        essential operations
        */
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    public void clear(){
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public Object getHead(){
        return this.cabeza;
    }

    public Object getTail(){
        return this.cola;
    }

    public Object get(Node node){
        if (isEmpty() || node == null) return null;

        Node actual = this.cabeza;
        do {
            if (actual == node || actual.dato == node) {
                Object valor = actual.dato;
                while (valor instanceof Node) {
                    valor = ((Node) valor).dato;
                }
                return valor;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return null;
    }

    public Node search(Object object){
        if (isEmpty() || object == null) return null;

        Node actual = this.cabeza;
        do {
            Object valor = actual.dato;
            while (valor instanceof Node) {
                valor = ((Node) valor).dato;
            }
            if (actual == object || valor.equals(object)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return null;
    }

    public boolean add(Object object){}

    public boolean insert(Node node, Object object){}

    public boolean insert(Object objectRef, Object object){}

    public boolean insertHead(Object object){}

    public boolean insertTail(Object object){}

    public boolean set(Node node, Object object){}

    public boolean remove(Node node){}

    /*
    expansion operations
     */
    public boolean contains(Object object){}

    public Object[] toArray(){}

    public Object[] toArray(Object[] object){}

    public MiListaCircular subList(Node from, Node to){}

    public MiListaCircular sortList(){}
}
