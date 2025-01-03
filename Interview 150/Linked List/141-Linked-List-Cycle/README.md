Vamos a abordar el problema **"Linked List Cycle"** siguiendo el enfoque sistemático descrito:

### **Problema**

#### [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **1. Comprensión del problema**

**Desglose**:

- **Input**: Una lista enlazada definida por su nodo inicial `head`.
  - Cada nodo tiene un valor (`val`) y un puntero al siguiente nodo (`next`).
  - `pos` indica el índice del nodo al que se conecta el último nodo. Si `pos = -1`, no hay ciclo.
- **Output**: `true` si existe un ciclo en la lista; `false` si no.
- **Definición de ciclo**: Un ciclo ocurre si algún nodo puede ser visitado más de una vez al seguir el puntero `next`.

**Restricciones**:

- El tamaño de la lista está en el rango `[0, 10^4]`.
- Los valores de los nodos están en el rango `[-10^5, 10^5]`.
- El espacio adicional debe ser **O(1)** en la solución más eficiente.

**Preguntas clave**:

1. ¿Qué tipo de nodos estás manejando? ¿Hay una implementación predeterminada de lista enlazada o necesitas una desde cero?
2. ¿Esperas manejar excepciones como `null` para `head` o listas vacías?
3. ¿El enfoque de O(1) memoria es obligatorio desde el inicio o podemos primero explorar soluciones más simples?

---

### **2. Planificación de la solución**

#### **Algoritmos y estructuras relevantes**:

1. **Método con memoria adicional (HashSet)**:

   - Usar un conjunto para registrar nodos visitados.
   - Complejidad:
     - Tiempo: O(n)
     - Espacio: O(n)

2. **Método eficiente en memoria (Floyd’s Cycle Detection Algorithm)**:
   - Utiliza dos punteros: uno lento (`slow`) y uno rápido (`fast`).
   - Si hay un ciclo, los punteros eventualmente se encontrarán.
   - Complejidad:
     - Tiempo: O(n)
     - Espacio: O(1)

#### **Plan**:

- Paso 1: Verifica condiciones iniciales (lista vacía o un solo nodo sin ciclo).
- Paso 2: Implementa el método de detección con punteros lentos y rápidos.
- Paso 3: Retorna el resultado (`true` o `false`).

---

### **3. Ejecución del plan**

#### **Implementación en Java (Floyd's Algorithm)**:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // Lista vacía o un solo nodo sin ciclo
        }

        ListNode slow = head; // Puntero lento
        ListNode fast = head; // Puntero rápido

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Avanza un paso
            fast = fast.next.next;  // Avanza dos pasos

            if (slow == fast) { // Si se encuentran, hay ciclo
                return true;
            }
        }

        return false; // Si el bucle termina, no hay ciclo
    }
}
```

#### **Posibles errores y soluciones**:

- **Error: NullPointerException**: Asegúrate de verificar que `fast` y `fast.next` no sean nulos antes de acceder a `fast.next.next`.
- **Bucles infinitos**: Ocurre si no se cumplen las condiciones de salida. Asegúrate de mantener las verificaciones en cada iteración.

---

### **Funcionamiento**

**Objetivo:** El objetivo de este programa es detectar si existe un ciclo en una lista enlazada. Un ciclo ocurre cuando un nodo en la lista apunta a un nodo que ya se ha visitado antes, creando un bucle.

**Funcionamiento:** A continuación, te explico paso a paso cómo funciona el programa:

**Definir la estructura de un nodo**: La clase `ListNode` define la estructura de un nodo en la lista enlazada, que tiene un valor (`val`) y una referencia al siguiente nodo (`next`).

- **Definir la estructura de un nodo**: La clase `ListNode` define la estructura de un nodo en la lista enlazada, que tiene un valor (`val`) y una referencia al siguiente nodo (`next`).

**Crear la clase principal**: La clase `LinkedListCycle` contiene el método `hasCycle` que detecta si existe un ciclo en la lista enlazada.

- **Crear la clase principal**: La clase `LinkedListCycle` contiene el método `hasCycle` que detecta si existe un ciclo en la lista enlazada.

**Verificar si la lista está vacía**: El método `hasCycle` verifica si la lista está vacía o tiene un único nodo sin ciclo. Si es así, devuelve `false`.

- **Verificar si la lista está vacía**: El método `hasCycle` verifica si la lista está vacía o tiene un único nodo sin ciclo. Si es así, devuelve `false`.

**Inicializar dos punteros**: Se inicializan dos punteros, `slow` y `fast`, que apuntan al primer nodo de la lista.

- **Inicializar dos punteros**: Se inicializan dos punteros, `slow` y `fast`, que apuntan al primer nodo de la lista.

**Avanzar los punteros**: El puntero `slow` avanza un paso a la vez, mientras que el puntero `fast` avanza dos pasos a la vez.

- **Avanzar los punteros**: El puntero `slow` avanza un paso a la vez, mientras que el puntero `fast` avanza dos pasos a la vez.

**Detectar el ciclo**: Si los punteros `slow` y `fast` se encuentran en el mismo nodo, significa que existe un ciclo en la lista. El método devuelve `true`.

- **Detectar el ciclo**: Si los punteros `slow` y `fast` se encuentran en el mismo nodo, significa que existe un ciclo en la lista. El método devuelve `true`.

**No hay ciclo**: Si el bucle termina sin encontrar un ciclo, el método devuelve `false`.

- **No hay ciclo**: Si el bucle termina sin encontrar un ciclo, el método devuelve `false`.

El método principal (`main`) crea una lista enlazada con un ciclo y otra sin ciclo, y prueba el método `hasCycle` con ambas listas.

---

### **4. Revisión y verificación**

#### **Validación**:

- Prueba casos básicos:
  - Lista vacía: `null`.
  - Un solo nodo sin ciclo: `[1]`.
  - Lista con ciclo: `[3, 2, 0, -4]` y `pos = 1`.
- Prueba casos límite:
  - Lista grande sin ciclo.
  - Lista grande con ciclo cerca del inicio.

#### **Eficiencia**:

- **Complejidad temporal**: O(n), donde `n` es el número de nodos.
- **Complejidad espacial**: O(1), solo se usan variables adicionales.

#### **Mejoras posibles**:

- Agregar un método para imprimir la lista y verificar manualmente.
- Incluir estadísticas sobre el número de pasos o iteraciones.

---
