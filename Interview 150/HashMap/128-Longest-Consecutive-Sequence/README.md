### **Problema**

#### [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **Comprensión del problema**

#### Desglose:

1. **Entrada**: Un arreglo desordenado de números enteros, `nums`.
2. **Salida**: Un entero que indica la longitud de la secuencia consecutiva más larga.
3. **Requisitos**:
   - El algoritmo debe funcionar en tiempo **O(n)**.
   - Los elementos consecutivos no necesitan ser contiguos en el arreglo.
4. **Restricciones**:
   - Longitud del arreglo: 0 <= nums.length <= 10^5.
   - Rango de valores: -10^9 <= nums[i] <= 10^9.

#### Preguntas clave:

1. ¿Qué debemos hacer si `nums` está vacío?
   - Devuelve 0 (no hay secuencia).
2. ¿El orden de los números importa en el resultado?
   - No, solo importa la secuencia de números consecutivos.
3. ¿Cómo manejar números duplicados en el arreglo?
   - Los duplicados no afectan la secuencia consecutiva.

---

### **Planificación**

#### Observaciones:

1. Un enfoque de fuerza bruta (ordenar y buscar consecutivos) sería **O(n log n)**, que no satisface los requisitos.
2. Para lograr **O(n)**:
   - Utilizaremos un conjunto (`Set`) para almacenar los elementos de `nums` y verificar en **O(1)** si un número pertenece a una secuencia consecutiva.

#### Algoritmo:

1. Almacena todos los números en un conjunto (`numSet`) para búsqueda eficiente.
2. Recorre cada número en el arreglo:
   - Si el número es el inicio de una secuencia (es decir, `num - 1` no está en el conjunto), inicia una nueva búsqueda.
   - Cuenta cuántos números consecutivos están presentes, incrementando desde ese número.
3. Lleva un registro de la longitud máxima encontrada.
4. Devuelve la longitud máxima.

#### Plan de acción:

1. Crear un conjunto `numSet` con los elementos de `nums`.
2. Inicializar `longestSequence = 0`.
3. Iterar sobre cada número:
   - Si el número no tiene un predecesor (`num - 1`), inicia un conteo.
   - Incrementa el contador mientras los números consecutivos estén presentes.
4. Actualizar `longestSequence` si el conteo actual es mayor.
5. Devolver `longestSequence`.

---

### **Ejecución**

#### Implementación en Java:

```java
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Caso base: sin elementos.
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Construimos el conjunto.
        }

        int longestSequence = 0;

        for (int num : nums) {
            // Solo iniciamos secuencia si el número no tiene predecesor.
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;

                // Contar la longitud de la secuencia consecutiva.
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }

                // Actualizar la longitud máxima.
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums1)); // Output: 4
        System.out.println(longestConsecutive(nums2)); // Output: 9
    }
}
```

---

### **Revisión**

1. **Validación**:
   - Verifica la solución con los casos de ejemplo proporcionados y otros casos límite, como:
     - Entrada vacía: `[]`.
     - Un solo elemento: `[10]`.
     - Todos duplicados: `[2, 2, 2, 2]`.
2. **Eficiencia**:
   - Complejidad temporal: O(n), ya que cada número se procesa como máximo dos veces (una para iniciar y otra para buscar consecutivos).
   - Complejidad espacial: O(n) para el conjunto.
3. **Mejoras potenciales**:
   - La solución actual es óptima en términos de tiempo y espacio dados los requisitos.

---
