### **Problema**

#### [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **1. Comprensión del problema**

- **Desglose del problema**:

  1. Nos dan un array de enteros `nums` y un entero `k`.
  2. Debemos verificar si existen dos índices `i` y `j` tales que:
     - `nums[i] == nums[j]` (los elementos en esos índices son iguales).
     - `abs(i - j) <= k` (la distancia entre estos índices es menor o igual a `k`).

- **Requisitos específicos**:

  - `nums` tiene un tamaño máximo de 10^5, lo que sugiere que una solución ineficiente podría exceder los límites de tiempo.
  - `nums[i]` puede ser tan grande como -10^9 o tan pequeño como -10^9, por lo que los valores pueden repetirse.
  - `k` puede ser cero, en cuyo caso no habría pares válidos (ya que `i` y `j` deben ser distintos).

- **Preguntas clave**:
  1. ¿Se deben retornar todos los pares válidos o solo confirmar si existe al menos uno? (Según el enunciado, solo debemos devolver `true` o `false`).
  2. ¿Qué sucede si el array está vacío o contiene un solo elemento? (Devolveremos `false`, ya que no puede haber dos índices distintos).

---

### **2. Planificación**

- **Estrategia**:
  Utilizaremos una estructura de datos eficiente para rastrear las apariciones recientes de cada número en el array y verificar la condición en tiempo lineal.

- **Algoritmo sugerido**:
  Usaremos un **diccionario/hashmap**:

  1. Iterar por los elementos del array con su índice.
  2. Para cada elemento:
     - Si el número ya existe en el diccionario, calcular la distancia entre los índices actual y anterior.
     - Si la distancia es menor o igual a `k`, retornar `true`.
     - Si no, actualizar el índice más reciente del número en el diccionario.
  3. Si se completa la iteración sin encontrar ningún par, retornar `false`.

- **Complejidad**:
  - Tiempo: O(n), donde n es el tamaño del array, ya que iteramos una sola vez.
  - Espacio: O(n) en el peor caso, debido al almacenamiento en el diccionario.

---

### **3. Ejecución**

#### Implementación del plan:

```java
import java.util.HashMap;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Mapa para almacenar el valor y su índice más reciente
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterar sobre el array
        for (int i = 0; i < nums.length; i++) {
            // Si el número ya está en el mapa
            if (map.containsKey(nums[i])) {
                // Verificar la distancia entre índices
                if (i - map.get(nums[i]) <= k) {
                    return true; // Encontramos un par válido
                }
            }
            // Actualizar el índice del número en el mapa
            map.put(nums[i], i);
        }

        // Si no encontramos pares válidos
        return false;
    }
}
```

#### Ejemplos de entrada y salida:

```java
public static void main(String[] args) {
    System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
    System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
    System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
}
```

#### Posibles errores y manejo:

1. **Array vacío o un solo elemento**: El código manejará automáticamente estos casos, devolviendo `false`.
2. **Valores grandes o negativos**: No hay problema, ya que el hashmap maneja enteros grandes.

---

### **4. Revisión**

- **Validación**:

  - La solución es eficiente O(n) y cumple con los requisitos del problema.
  - Probada con diferentes ejemplos, incluyendo bordes como `nums = []`, `nums = [1]`, y casos grandes.

- **Mejoras potenciales**:
  - Si el array es extremadamente grande y el rango de `k` es pequeño, podemos usar una **ventana deslizante** con un conjunto para reducir el uso de memoria.

---
