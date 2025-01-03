// Definición de la clase ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Clase principal para resolver el problema
public class AddTwoNumbers {

    // Método para sumar dos números representados por listas enlazadas
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Nodo ficticio para construir la lista resultante
        ListNode current = dummy; // Puntero para la lista resultante
        int carry = 0; // Variable para el acarreo

        // Iterar mientras haya nodos en l1 o l2 o un acarreo pendiente
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Comienza con el acarreo

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Actualizar el acarreo
            current.next = new ListNode(sum % 10); // Crear el nuevo nodo con el dígito
            current = current.next; // Avanzar al siguiente nodo
        }

        return dummy.next; // Devolver la lista resultante (sin el nodo ficticio)
    }

    // Método principal para ejecutar casos de prueba
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Ejemplo 1: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(result); // Salida esperada: [7,0,8]

        // Ejemplo 2: l1 = [0], l2 = [0]
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(result); // Salida esperada: [0]

        // Ejemplo 3: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        l1 = new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(result); // Salida esperada: [8,9,9,9,0,0,0,1]
    }

    // Método para imprimir la lista enlazada en el formato esperado
    private static void printList(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(",");
            }
            node = node.next;
        }
        System.out.println("]");
    }
}
