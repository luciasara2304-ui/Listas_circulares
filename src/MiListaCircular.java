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

    public Object getHead(){}

    public Object getTail(){}

    public Object get(Node node){}

    public Node search(Object object){}

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
