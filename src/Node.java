public class Node {
    Object dato;
    Node siguiente;

    public Node(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // AGREGA ESTO AL FINAL DE LA CLASE:
    @Override
    public String toString() {
        return this.dato != null ? this.dato.toString() : "null";
    }
}