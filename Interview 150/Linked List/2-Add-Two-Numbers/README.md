### **Problema**

#### [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **Comprensión del problema**

#### Desglose del problema:

1. **Entrada**:

   - Dos listas enlazadas `l1` y `l2`, cada una representando un número entero en orden inverso.
   - Cada nodo contiene un dígito en el rango `[0, 9]`.
   - No hay ceros iniciales, salvo el caso especial donde el número sea `0`.

2. **Salida**:

   - Una nueva lista enlazada que representa la suma de los números `l1` y `l2` en orden inverso.

3. **Condiciones específicas**:
   - Las listas pueden tener longitudes diferentes.
   - Los valores de los nodos están garantizados dentro del rango `[0, 9]`.

#### Preguntas clave:

- ¿Se pueden asumir que los nodos de entrada son válidos (es decir, siempre dentro del rango permitido)?
- ¿Qué sucede si las listas tienen longitudes diferentes? ¿Deberíamos rellenar con ceros o manejarlas directamente?
- ¿Hay alguna limitación en cuanto a memoria o tiempo que deba considerarse?

---

### **Planificación**

#### Estructuras de datos y algoritmo sugerido:

1. **Estructura**:

   - Usar la clase `ListNode` para representar nodos de la lista enlazada.

2. **Algoritmo**:
   - Iterar simultáneamente por ambas listas, sumando los valores nodo a nodo.
   - Llevar un acarreo (`carry`) para manejar sumas que excedan `9`.
   - Continuar la iteración hasta que ambos nodos sean nulos y no haya acarreo.
   - Crear nodos en la lista de salida para cada suma calculada.

#### Plan de acción:

1. Inicializar punteros para recorrer ambas listas (`l1` y `l2`) y un valor `carry` a 0.
2. Crear un nodo ficticio (`dummy`) para construir la lista de salida.
3. Iterar hasta que ambos nodos sean nulos y `carry` sea 0:
   - Obtener el valor de los nodos actuales (usar `0` si el nodo es nulo).
   - Calcular la suma de los valores y el acarreo.
   - Crear un nuevo nodo con el dígito de las unidades del resultado.
   - Mover los punteros de las listas al siguiente nodo.
4. Retornar la lista enlazada comenzando desde el nodo siguiente al ficticio.

---

### **Ejecución**

#### Código en Java:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Nodo ficticio
        ListNode current = dummy; // Puntero para construir la lista
        int carry = 0; // Acarreo inicial

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Incluir el acarreo en la suma

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Actualizar el acarreo
            current.next = new ListNode(sum % 10); // Crear nuevo nodo con el dígito
            current = current.next; // Mover el puntero
        }

        return dummy.next; // Retornar la lista sumada
    }
}
```

---

### **Funcionamiento**

**Objetivo:** El objetivo de este programa es sumar dos números representados como listas enlazadas. Cada nodo en la lista representa un dígito del número, y la lista se lee de derecha a izquierda (es decir, el último nodo es el dígito menos significativo).

**Funcionamiento:** A continuación, te explico paso a paso cómo funciona el programa:

- **Definir la estructura de un nodo**: La clase `ListNode` define la estructura de un nodo en la lista enlazada, que tiene un valor (`val`) y una referencia al siguiente nodo (`next`).

- **Definir la estructura de un nodo**: La clase `ListNode` define la estructura de un nodo en la lista enlazada, que tiene un valor (`val`) y una referencia al siguiente nodo (`next`).

- **Crear el método para sumar dos números**: El método `addTwoNumbers` toma dos listas enlazadas (`l1` y `l2`) como entrada y devuelve una nueva lista enlazada que representa la suma de los dos números.

- **Crear el método para sumar dos números**: El método `addTwoNumbers` toma dos listas enlazadas (`l1` y `l2`) como entrada y devuelve una nueva lista enlazada que representa la suma de los dos números.

- **Crear un nodo ficticio**: Se crea un nodo ficticio (`dummy`) para simplificar la construcción de la lista resultante.

- **Crear un nodo ficticio**: Se crea un nodo ficticio (`dummy`) para simplificar la construcción de la lista resultante.

- **Inicializar el puntero y el acarreo**: Se inicializa un puntero (`current`) que apunta al nodo ficticio y un acarreo (`carry`) que se utiliza para llevar el valor de la suma a la siguiente posición.

- **Inicializar el puntero y el acarreo**: Se inicializa un puntero (`current`) que apunta al nodo ficticio y un acarreo (`carry`) que se utiliza para llevar el valor de la suma a la siguiente posición.

- **Iterar mientras haya nodos en l1 o l2 o un acarreo pendiente**: Se utiliza un bucle para sumar los números representados por las listas enlazadas. En cada iteración, se suman los valores de los nodos actuales de `l1` y `l2`, y se actualiza el acarreo.

- **Iterar mientras haya nodos en l1 o l2 o un acarreo pendiente**: Se utiliza un bucle para sumar los números representados por las listas enlazadas. En cada iteración, se suman los valores de los nodos actuales de `l1` y `l2`, y se actualiza el acarreo.

- **Crear un nuevo nodo con el dígito**: Se crea un nuevo nodo con el dígito resultante de la suma (es decir, el valor del acarreo módulo 10).

- **Crear un nuevo nodo con el dígito**: Se crea un nuevo nodo con el dígito resultante de la suma (es decir, el valor del acarreo módulo 10).

- **Avanzar al siguiente nodo**: Se mueve el puntero (`current`) al nuevo nodo creado.

- **Avanzar al siguiente nodo**: Se mueve el puntero (`current`) al nuevo nodo creado.

- **Devolver la lista resultante**: Se devuelve la lista resultante, que es la lista que comienza en el nodo siguiente al nodo ficticio (`dummy.next`).

- **Devolver la lista resultante**: Se devuelve la lista resultante, que es la lista que comienza en el nodo siguiente al nodo ficticio (`dummy.next`).

- **Método para imprimir la lista enlazada**: Se define un método (`printList`) para imprimir la lista enlazada en el formato esperado.

- **Método para imprimir la lista enlazada**: Se define un método (`printList`) para imprimir la lista enlazada en el formato esperado.

**Método principal para ejecutar casos de prueba**: Se define un método principal (`main`) para ejecutar casos de prueba y verificar que el programa funcione correctamente.

- **Método principal para ejecutar casos de prueba**: Se define un método principal (`main`) para ejecutar casos de prueba y verificar que el programa funcione correctamente.

---

### **Revisión**

#### Validación:

1. **Pruebas con ejemplos dados**:

   - Entrada: `l1 = [2,4,3]`, `l2 = [5,6,4]` → Salida esperada: `[7,0,8]`.
   - Entrada: `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]` → Salida esperada: `[8,9,9,9,0,0,0,1]`.

2. **Eficiencia**:
   - Complejidad temporal: O(max(n, m)), donde (n) y (m) son las longitudes de las listas.
   - Complejidad espacial: O(max(n, m)) para la lista de salida.

#### Posibles mejoras:

- Manejar listas enlazadas de entrada más extensas eficientemente si hay restricciones de memoria.

---
