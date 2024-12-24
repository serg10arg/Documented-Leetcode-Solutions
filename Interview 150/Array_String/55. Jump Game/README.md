## **1. Comprensión del problema** (https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150)

**Desglose del problema**:

- Tienes un arreglo `nums` de enteros donde cada elemento indica la **máxima distancia** que puedes saltar desde esa posición.
- Estás inicialmente en el índice `0` del arreglo.
- Tu objetivo es determinar si puedes alcanzar el último índice del arreglo, cumpliendo con las restricciones de saltos.

**Requisitos clave**:

1. El arreglo tiene una longitud entre `1` y `10^4`.
2. Cada elemento de `nums[i]` está en el rango `0 ≤ nums[i] ≤ 10^5`.
3. Debes devolver `true` si puedes llegar al último índice; de lo contrario, `false`.

**Preguntas clave**:

1. ¿Qué pasa si el arreglo tiene solo un elemento?Respuesta: Siempre puedes llegar al último índice porque ya estás en él.
2. ¿Existen restricciones de tiempo o espacio para la solución?Respuesta: Dado que `nums.length` puede ser tan grande como 104, una solución eficiente con una complejidad cercana a O(n) es ideal.
3. ¿Puedo retroceder en el arreglo o solo avanzar? Respuesta: Solo puedes avanzar, ya que los saltos son positivos.

## **2. Planificación**

**Enfoque óptimo sugerido**:

Usaremos un algoritmo **Greedy (avaro)**, basado en la idea de mantener un "alcance máximo" (`maxReach`) que nos diga hasta dónde podemos llegar desde cualquier posición.

**Pasos del plan**:

1. Inicializa `maxReach = 0` para representar el índice más lejano al que puedes llegar inicialmente.
2. Recorre el arreglo:
   - Para cada posición `i`, verifica si puedes alcanzarla (`i <= maxReach`).
   - Si puedes alcanzarla, actualiza `maxReach` como el máximo entre `maxReach` y `i + nums[i]`.
3. Si en cualquier momento `maxReach` es mayor o igual al último índice del arreglo, retorna `true`.
4. Si terminas el recorrido y `maxReach` no alcanza el último índice, retorna `false`.

**Complejidad esperada**:

- Tiempo: O(n), porque recorremos el arreglo una sola vez.
- Espacio: O(1), porque no utilizamos estructuras adicionales.

## **3. Revisión y verificación**

**Validación**:

1. Ejecuta el código con casos de prueba básicos:
   - `nums = [2, 3, 1, 1, 4]` → `true`.
   - `nums = [3, 2, 1, 0, 4]` → `false`.
2. Casos límite:
   - Arreglo de un elemento: `nums = [0]` → `true`.
   - Arreglo con todos ceros excepto el primero: `nums = [1, 0, 0, 0]` → `false`.

**Eficiencia**:

- El algoritmo recorre el arreglo una sola vez y usa espacio constante, cumpliendo los requisitos de eficiencia.

**Mejoras potenciales**:

- Si el índice actual supera `maxReach`, podemos interrumpir el bucle anticipadamente para optimizar aún más.
