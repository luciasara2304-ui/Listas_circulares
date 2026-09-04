public class MiListaCircular implements ListInterface {

    private Node cabeza;
    private Node cola;
    private int size;

    public MiListaCircular() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    // --- ESSENTIAL OPERATIONS ---

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    @Override
    public Object getHead() {
        return this.cabeza;
    }

    @Override
    public Object getTail() {
        return this.cola;
    }

    @Override
    public Object get(Node node) {
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

    @Override
    public Node search(Object object) {
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

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(Node node, Object object) {
        if (isEmpty() || node == null) return false;

        Node actual = this.cabeza;
        do {
            if (actual == node || actual.dato == node) {
                Node nuevo = new Node(object);
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;

                if (actual == this.cola) {
                    this.cola = nuevo;
                }
                this.size++;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return false;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        Node nodoEncontrado = search(objectRef);
        if (nodoEncontrado != null) {
            return insert(nodoEncontrado, object);
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        Node nuevo = new Node(object);
        if (isEmpty()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            this.cola.siguiente = this.cabeza;
        } else {
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
            this.cola.siguiente = this.cabeza;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        Node nuevo = new Node(object);
        if (isEmpty()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            this.cola.siguiente = this.cabeza;
        } else {
            this.cola.siguiente = nuevo;
            this.cola = nuevo;
            this.cola.siguiente = this.cabeza;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean set(Node node, Object object) {
        if (isEmpty() || node == null) return false;

        Node actual = this.cabeza;
        do {
            if (actual == node || actual.dato == node) {
                actual.dato = object;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return false;
    }

    @Override
    public boolean remove(Node node) {
        if (isEmpty() || node == null) return false;

        Node actual = this.cabeza;
        Node anterior = this.cola;

        do {
            if (actual == node || actual.dato == node) {
                if (this.size == 1) {
                    this.cabeza = null;
                    this.cola = null;
                } else {
                    anterior.siguiente = actual.siguiente;

                    if (actual == this.cabeza) {
                        this.cabeza = actual.siguiente;
                        this.cola.siguiente = this.cabeza;
                    }
                    if (actual == this.cola) {
                        this.cola = anterior;
                        this.cola.siguiente = this.cabeza;
                    }
                }
                this.size--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return false;
    }

    // --- EXPANSION OPERATIONS ---

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[this.size];
        if (isEmpty()) return arreglo;

        Node actual = this.cabeza;
        int i = 0;
        do {
            Object valor = actual.dato;
            while (valor instanceof Node) {
                valor = ((Node) valor).dato;
            }
            arreglo[i++] = valor;
            actual = actual.siguiente;
        } while (actual != this.cabeza && i < this.size);

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object == null || object.length < this.size) {
            object = new Object[this.size];
        }

        if (!isEmpty()) {
            Node actual = this.cabeza;
            int i = 0;
            do {
                Object valor = actual.dato;
                while (valor instanceof Node) {
                    valor = ((Node) valor).dato;
                }
                object[i++] = valor;
                actual = actual.siguiente;
            } while (actual != this.cabeza && i < this.size);
        }

        if (object.length > this.size) {
            object[this.size] = null;
        }

        return object;
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        MiListaCircular sublista = new MiListaCircular();
        if (from == null || to == null || isEmpty()) return sublista;

        Node actual = this.cabeza;
        Node inicio = null;

        do {
            if (actual == from || actual.dato == from) {
                inicio = actual;
                break;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        if (inicio == null) return sublista;

        actual = inicio;
        do {
            Object valor = actual.dato;
            while (valor instanceof Node) {
                valor = ((Node) valor).dato;
            }
            sublista.add(valor);

            if (actual == to || actual.dato == to) {
                break;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return sublista;
    }

    @Override
    public MiListaCircular sortList() {
        MiListaCircular listaOrdenada = new MiListaCircular();
        if (isEmpty()) return listaOrdenada;

        // 1. Clonar elementos planos a la nueva lista
        Node actual = this.cabeza;
        do {
            Object valor = actual.dato;
            while (valor instanceof Node) {
                valor = ((Node) valor).dato;
            }
            listaOrdenada.add(valor);
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        // 2. Bubble Sort manual sobre la lista circular
        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Node p1 = listaOrdenada.cabeza;

            do {
                String val1 = p1.dato.toString();
                String val2 = p1.siguiente.dato.toString();

                if (p1.siguiente != listaOrdenada.cabeza && val1.compareTo(val2) > 0) {
                    Object temp = p1.dato;
                    p1.dato = p1.siguiente.dato;
                    p1.siguiente.dato = temp;
                    huboIntercambio = true;
                }
                p1 = p1.siguiente;
            } while (p1.siguiente != listaOrdenada.cabeza);

        } while (huboIntercambio);

        return listaOrdenada;
    }
}
