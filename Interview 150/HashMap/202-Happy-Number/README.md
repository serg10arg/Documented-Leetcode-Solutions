### **Problema**

## [202. Happy Number](https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **Comprensión del problema**

1. **Desglose del problema**:

   - Un número feliz es aquel que, al reemplazarse repetidamente por la suma de los cuadrados de sus dígitos:
     - Llega a 1 y se detiene.
     - O entra en un ciclo que no incluye el 1.
   - Debemos implementar un algoritmo que:
     - Dado un número positivo `n`, determine si es feliz (`true`) o no (`false`).

2. **Requisitos específicos**:

   - El proceso se repite hasta que:
     - El número sea igual a 1.
     - O se detecte un ciclo que no incluye el 1.
   - Entrada: Un número entero positivo `n`.
   - Salida: `true` si el número es feliz, `false` si no lo es.

3. **Preguntas clave**:
   - ¿Cómo manejamos números muy grandes? (No aplicable aquí, ya que el rango de `n` está limitado por las restricciones).
   - ¿Hay restricciones adicionales en cuanto a tiempo o memoria? (Se busca una solución eficiente, pero no hay límites explícitos).
   - ¿Qué hacemos si el número ya se repitió? (Se utiliza una estructura para detectar ciclos).

---

### **Planificación de la solución**

1. **Algoritmo sugerido**:

   - Usar una estructura de datos como un **conjunto (Set)** para rastrear números ya vistos.
   - Calcular la suma de los cuadrados de los dígitos de `n` en un bucle.
   - Si el número resultante ya está en el conjunto, sabemos que hay un ciclo.
   - Si el número es 1, devolver `true`.

2. **Estructura de datos relevante**:

   - Un conjunto (`HashSet` en Java) para rastrear números vistos.

3. **Plan detallado**:

   1. Crear una función que calcule la suma de los cuadrados de los dígitos de un número.
   2. Usar un bucle para realizar los cálculos sucesivos.
   3. Verificar si el número actual es 1 (feliz) o si ya se vio antes (ciclo).
   4. Retornar `true` si es feliz y `false` si no.

4. **Inspiración de problemas similares**:
   - Problemas de detección de ciclos como encontrar ciclos en listas enlazadas.
   - Transformaciones iterativas con condiciones de parada.

---

### **Ejecución del plan**

#### **Implementación en Java**

```java
import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // Extraer el último dígito
            sum += digit * digit; // Sumar el cuadrado del dígito
            n /= 10; // Eliminar el último dígito
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2));  // false
    }
}
```

---

### **Revisión y verificación**

1. **Validación de requisitos**:

   - Para `n = 19`: la función retorna `true`, como se espera.
   - Para `n = 2`: la función retorna `false`, como se espera.

2. **Eficiencia**:

   - **Complejidad temporal**: O(log n) por iteración (suma de cuadrados de dígitos) multiplicado por el número de iteraciones hasta detectar un ciclo o llegar a 1.
   - **Complejidad espacial**: O(k), donde (k) es el número de elementos únicos en el conjunto.

3. **Mejoras potenciales**:
   - Usar el algoritmo de detección de ciclos de Floyd para ahorrar espacio eliminando el conjunto.

---
