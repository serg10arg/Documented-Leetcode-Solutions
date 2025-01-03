// Clase que define la estructura de un nodo en la lista enlazada
class ListNode {
    int val;
    ListNode next;

    // Constructor para inicializar el nodo
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Clase principal para la detección de ciclos en la lista enlazada
public class LinkedListCycle {
    // Método para detectar si existe un ciclo en la lista enlazada
    public boolean hasCycle(ListNode head) {
        // Verifica si la lista está vacía o tiene un único nodo sin ciclo
        if (head == null || head.next == null) {
            return false;
        }

        // Inicializa dos punteros: lento (slow) y rápido (fast)
        ListNode slow = head;
        ListNode fast = head;

        // Bucle para avanzar los punteros
        while (fast != null && fast.next != null) {
            slow = slow.next; // Avanza un paso
            fast = fast.next.next; // Avanza dos pasos

            // Si los punteros se encuentran, hay un ciclo
            if (slow == fast) {
                return true;
            }
        }

        // Si el bucle termina, no hay ciclo
        return false;
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        // Crea nodos para la lista enlazada
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Conecta los nodos para formar una lista con un ciclo
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Crea el ciclo (tail conecta al segundo nodo)

        // Instancia de la clase LinkedListCycle
        LinkedListCycle solution = new LinkedListCycle();

        // Prueba con la lista enlazada creada
        boolean result = solution.hasCycle(node1);
        System.out.println("¿La lista enlazada tiene un ciclo? " + result);

        // Crea una lista sin ciclo
        ListNode node5 = new ListNode(1);
        node5.next = null;

        result = solution.hasCycle(node5);
        System.out.println("¿La lista enlazada tiene un ciclo? " + result);
    }
}
