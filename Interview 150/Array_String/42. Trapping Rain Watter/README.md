## **1. Comprensión del problema** (https://leetcode.com/problems/trapping-rain-water/)

- **Enunciado**: Se nos da un arreglo `height` donde cada elemento representa la altura de un bloque en un mapa de elevación. La tarea es calcular cuánta agua se puede "atrapar" entre los bloques después de que llueva.
- **Formato de entrada**:
  - Un arreglo de enteros `height`.
  - Ejemplo: `height = [0,1,0,2,1,0,1,3,2,1,2,1]`.
- **Formato de salida**:
  - Un entero que representa el agua atrapada.
  - Ejemplo: Para `height = [0,1,0,2,1,0,1,3,2,1,2,1]`, el resultado es `6`.
- **Restricciones**:
  - `1 <= n <= 2 * 10^4`.
  - `0 <= height[i] <= 10^5`.

**Preguntas clave**:

1. ¿Se permite modificar el arreglo `height` durante el cálculo?
2. ¿Cuál es la prioridad: optimización del tiempo o de la memoria?
3. ¿Existen casos límites como todos los bloques con altura cero?

## **2. Planificación**

- **Ideas clave**: El agua atrapada entre dos bloques está determinada por el mínimo entre las alturas máximas a la izquierda y a la derecha de la posición actual, menos la altura del bloque en la posición actual.
- **Métodos para resolver**:
  1. **Solución con memoria adicional (Dos arreglos auxiliares)**:
     - Calcular el máximo izquierdo y derecho para cada posición.
     - Complejidad: Tiempo O(n), Espacio O(n).
  2. **Solución optimizada (Punteros en dos extremos)**:
     - Utilizar dos punteros para evitar arreglos auxiliares.
     - Complejidad: Tiempo O(n), Espacio O(1).

Proponemos implementar la solución optimizada usando punteros en dos extremos.

**Algoritmo (Dos Punteros):**

1. Inicializar dos punteros, `left` a 0 y `right` a `n-1`.
2. Inicializar `maxLeft` y `maxRight` a 0.
3. Inicializar `totalWater` a 0.
4. Mientras `left < right`:
   - Si `height[left] < height[right]`:
     - Si `height[left] >= maxLeft`: Actualizar `maxLeft`.
     - Si no: Calcular la cantidad de agua atrapada en la posición `left` como `maxLeft - height[left]` y sumar a `totalWater`.
     - Incrementar `left`.
   - Si no:
     - Si `height[right] >= maxRight`: Actualizar `maxRight`.
     - Si no: Calcular la cantidad de agua atrapada en la posición `right` como `maxRight - height[right]` y sumar a `totalWater`.
     - Decrementar `right`.
   - Retornar `totalWater`.

**Contexto: totalWater += maxLeft - height[left]**

Esta línea de código se encuentra dentro del bucle `while` de la solución al problema "Trapping Rain Water". Su propósito es calcular la cantidad de agua que se puede acumular en una posición específica (`left`) y sumarla al total.

- `maxLeft`: Es la altura máxima de la barra que se ha encontrado hasta el momento _a la izquierda_ de la posición actual `left`.
- `height[left]`: Es la altura de la barra en la posición actual `left`.

**Ejemplo numérico y visual:**

Consideremos una parte del arreglo `height`: `[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]`

Imaginemos que en un momento dado del bucle, tenemos lo siguiente:

- `left = 2` (la tercera posición, con valor 0).
- `maxLeft = 1` (la altura máxima encontrada a la izquierda hasta ahora es 1, correspondiente al `height[1]`).
- `height[left] = height[2] = 0`.

La operación se evaluaría:

1. `maxLeft - height[left] = 1 - 0 = 1`

Esto significa que se puede acumular 1 unidad de agua en la posición `left = 2`.

1. `totalWater += 1` (se suma 1 al valor actual de `totalWater`).

**Otro ejemplo (con más agua):**

Supongamos ahora que más adelante en el bucle, tenemos:

- `left = 5` (la sexta posición, con valor 0).
- `maxLeft = 2` (la altura máxima encontrada a la izquierda hasta ahora es 2, correspondiente al `height[3]`).
- `height[left] = height[5] = 0`.

La operación se evaluaría:

1. `maxLeft - height[left] = 2 - 0 = 2`

Esto significa que se pueden acumular 2 unidades de agua en la posición `left = 5`.

1. `totalWater += 2` (se suma 2 al valor actual de `totalWater`).

**Puntos clave:**

- Solo se calcula agua si `maxLeft` es mayor que `height[left]`. Si `height[left]` fuera igual o mayor que `maxLeft`, no se acumularía agua en esa posición.
- La cantidad de agua que se acumula en una posición está determinada por la diferencia entre `maxLeft` y `height[left]`.
- La lógica es simétrica para el puntero `right` y `maxRight`.

## **3. Revisión y verificación**

**Revisión y verificación:**

- **Prueba con el ejemplo dado:** `height = [0,1,0,2,1,0,1,3,2,1,2,1]`. El código devuelve 6, lo cual es correcto.
- **Complejidad temporal:** O(n), ya que recorremos el arreglo una sola vez.
- **Complejidad espacial:** O(1), ya que solo usamos variables constantes.

**Mejoras:**

Aunque el enfoque de dos punteros es eficiente, también se puede resolver con Programación Dinámica, creando dos arreglos auxiliares para almacenar los máximos a la izquierda y a la derecha de cada posición. Sin embargo, esto aumentaría la complejidad espacial a O(n).
