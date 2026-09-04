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

        System.out.println("¿Insertado por nodo?: " + lista.insert(n2, "Circular Insertado Nodo"));
        System.out.println("¿Insertado por objeto?: " + lista.insert("Circular 5", "Circular Insertado Objeto"));

        lista.insertHead("Circular Inicio");
        lista.insertTail("Circular Final");

        // CORREGIDO: Usamos ((Node)...).dato
        System.out.println("Nueva Cabeza: " + ((Node) lista.getHead()).dato);
        System.out.println("Nueva Cola: " + ((Node) lista.getTail()).dato);

        System.out.println("Dato original n2: " + lista.get(n2));

        // CORREGIDO: Modificamos n2 indicando el nodo n2 y el nuevo texto "Modificado Circular"
        System.out.println("¿Se modificó n2?: " + lista.set(n2, "Modificado Circular"));
        System.out.println("Nuevo dato de n2: " + lista.get(n2));

        // CORREGIDO: Al estar sano n2, ahora remove(n2) dará true
        System.out.println("¿Se eliminó n2?: " + lista.remove(n2));
        System.out.println("¿Contiene 'Inexistente'?: " + lista.contains("Inexistente"));

        // --- Operaciones de expansión ---
        System.out.println("Arreglo: " + Arrays.toString(lista.toArray()));

        Node desde = lista.search("Circular Inicio");
        Node hasta = lista.search("Circular 3");
        MiListaCircular sublista = lista.subList(desde, hasta);
        System.out.println("Sublista: " + Arrays.toString(sublista.toArray()));

        Object[] miArreglo = new Object[lista.getSize()];
        lista.toArray(miArreglo);
        System.out.println("Arreglo (con parámetro): " + Arrays.toString(miArreglo));

        MiListaCircular listaOrdenada = lista.sortList();
        System.out.println("Lista Ordenada: " + Arrays.toString(listaOrdenada.toArray()));

        lista.clear();
        System.out.println("DESPUES DE VACIAR LA LISTA ");
        System.out.println("¿Está vacía?: " + lista.isEmpty());
    }
}