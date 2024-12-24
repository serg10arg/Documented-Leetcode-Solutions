## **1. Comprensión del problema** (https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150)

**Desglose**:

1. Tienes un arreglo `nums` de longitud `n`, donde cada elemento representa el máximo número de pasos que puedes avanzar desde esa posición.
2. El objetivo es determinar el **número mínimo de saltos** necesarios para llegar desde el índice `0` al índice `n-1` del arreglo.

**Requisitos**:

- Cada salto debe cumplir con la condición de que `0 <= j <= nums[i]` y `i + j < n`.
- Está garantizado que siempre es posible llegar a `nums[n - 1]`.

**Preguntas clave**:

1. ¿El arreglo puede contener ceros? (Esto puede influir en las posiciones alcanzables).
2. ¿Se esperan múltiples soluciones, o buscamos únicamente una solución óptima?
3. ¿Es importante optimizar el uso de memoria o es suficiente centrarse en la complejidad temporal?

## **2. Planificación**

**Algoritmo sugerido**:

1. Utilizaremos un enfoque de **Greedy Algorithm (codicioso)** para resolver este problema eficientemente.
2. La idea básica es mantener un rango de alcance actual y determinar la siguiente posición óptima para saltar, minimizando los saltos.

**Pasos**:

1. Inicializa las variables:
   - `jumps` para contar los saltos realizados.
   - `current_end` para rastrear el rango actual que puedes alcanzar.
   - `farthest` para rastrear la posición más lejana que puedes alcanzar desde el rango actual.
2. Itera por el arreglo (excepto el último índice) para ir actualizando `farthest`.
3. Si llegas al final del rango actual (`current_end`), incrementa el contador de `jumps` y actualiza el rango a `farthest`.
4. Devuelve `jumps`.

**Ejemplo relacionado**:
El problema se parece a la estrategia de encontrar una ruta mínima en un grafo unidimensional, donde cada posición tiene bordes hacia los siguientes `nums[i]` nodos.

**Explicación del código**:

1. `farthest` mantiene la posición más lejana alcanzable en cada iteración.
2. Cuando alcanzamos el final del rango actual (`currentEnd`), sabemos que debemos hacer un salto, incrementamos `jumps` y extendemos el rango.
3. No evaluamos el último índice porque ya habremos calculado el salto final necesario.

**Complejidad**:

- Temporal: O(n), ya que iteramos una sola vez sobre el arreglo.
- Espacial: O(1), ya que usamos solo variables auxiliares.

## **3. Revisión y verificación**

- **Validación**:
  - Los casos de ejemplo producen las salidas correctas.
  - Considerar casos límite, como:
    - `nums = [1,1,1,1]` (saltos lineales).
    - `nums = [10,9,8,...,1,0]` (un salto cubre todo el arreglo).
- **Eficiencia**:
  - La solución es eficiente para n=104 con un tiempo lineal y memoria constante.
    n=104n = 10^4
- **Mejoras potenciales**:
  - Si el problema tuviera un tamaño mayor, podríamos explorar soluciones paralelas o basadas en grafos.
