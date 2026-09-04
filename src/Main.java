import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MiListaCircular lista = new MiListaCircular();

        Node n1 = new Node("Circular 1");
        Node n2 = new Node("Circular 2");
        Node n3 = new Node("Circular 3");
        Node n4 = new Node("Circular 4");
        lista.add(n1);
        lista.add(n2);
        lista.add(n3);
        lista.add(n4);

        System.out.println("¿Está vacía?: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.getSize());

        System.out.println("Obtener la cabeza: " + ((Node) lista.getHead()).dato);
        System.out.println("Obtener la cola: " + ((Node) lista.getTail()).dato);
        System.out.println("Dato del nodo 2: " + lista.get(n2));

        lista.add("Circular 5");
        System.out.println("Nodo encontrado: " + lista.get(lista.search("Circular 3")));


        lista.clear();
        System.out.println("DESPUES DE VACIAR LA LISTA ");
        System.out.println("¿Está vacía?: " + lista.isEmpty());
    }
}