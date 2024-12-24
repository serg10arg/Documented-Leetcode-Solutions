## **1. Comprensión del problema** ([Remove Duplicates from Sorted Array - LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/))

**Objetivo:**

Dado un arreglo `nums` ordenado en orden no decreciente, eliminar duplicados en su lugar, dejando solo elementos únicos en las primeras posiciones del arreglo.

Se debe retornar el número `k`, que indica cuántos elementos únicos contiene el arreglo.

**Restricciones y puntos clave:**

- Los elementos únicos deben mantenerse en el mismo orden en que aparecen.
- No importa qué valores queden en las posiciones posteriores a `k`.
- El arreglo está ordenado de antemano.
- El arreglo debe ser modificado **in-place**, es decir, sin utilizar espacio adicional significativo.

**Preguntas clave:**

1. ¿Siempre habrá al menos un elemento en el arreglo? _(Sí, `nums.length >= 1` según las restricciones)._
2. ¿Es posible usar espacio adicional limitado como variables temporales? _(Sí, pero no estructuras adicionales como otro arreglo)._
3. ¿Se espera una solución eficiente en tiempo? _(Sí, idealmente O(n))._

## **2. Planificación**

**Observación:**

Dado que el arreglo está ordenado, los duplicados estarán adyacentes. Esto permite una solución con punteros para identificar elementos únicos.

**Algoritmo sugerido (dos punteros):**

1. Usa un puntero (`write_index`) para marcar la posición en la que se escribirá el siguiente número único.
2. Recorre el arreglo con otro puntero (`read_index`) que verifica cada elemento.
3. Si el valor actual no es igual al valor anterior, copia este valor a la posición marcada por `write_index` y avanza `write_index`.
4. Al final, `write_index` será igual a `k`, la cantidad de elementos únicos.

**Complejidad:**

- **Temporal:** O(n), porque recorremos el arreglo una vez.
- **Espacial:** O(1), ya que no usamos estructuras adicionales.
