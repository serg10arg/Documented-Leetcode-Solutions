## **1. Comprensión del problema** (https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)

**Desglose:**

- Nos dan dos arreglos ordenados, `nums1` y `nums2`.
- `nums1` tiene espacio adicional al final (rellenado con ceros) para almacenar la combinación de ambos arreglos.
- Los primeros `m` elementos de `nums1` son válidos y deben combinarse con los `n` elementos de `nums2`.
- La tarea es modificar `nums1` directamente para que contenga la lista combinada y ordenada.

## **2. Planificación**

**Observaciones importantes:**

- Los dos arreglos están ordenados, lo que nos permite utilizar técnicas eficientes, como una fusión inversa desde el final de `nums1`.
- Para una solución óptima de tiempo , debemos evitar ordenar los elementos repetidamente y en su lugar realizar una comparación directa de elementos desde el final hacia el inicio.

**Plan de acción:**

1. Usar punteros:
   - Uno para el final de los elementos válidos en `nums1` (`m-1`).
   - Otro para el final de `nums2` (`n-1`).
   - Uno adicional para el final total de `nums1` (`m+n-1`).
2. Comparar los elementos apuntados por `m` y `n` desde atrás hacia adelante y colocar el mayor en el índice actual del puntero final.
3. Si sobran elementos en `nums2`, copiarlos a `nums1` (no es necesario manejar `nums1`, ya que los elementos restantes ya están en su lugar).

## **3. Revisión**

**Validación de requisitos:**

- La solución es in-place (modifica directamente `nums1`).
- Complejidad temporal: , ya que cada elemento se procesa una vez.
- Complejidad espacial: , ya que no se utiliza memoria adicional significativa.

**Verificación con casos borde:**

1. **Caso 1:** `nums1 = [0], m = 0`, `nums2 = [1], n = 1` → Salida esperada: `[1]`.
2. **Caso 2:** `nums1 = [1], m = 1`, `nums2 = [], n = 0` → Salida esperada: `[1]`.
3. **Caso 3:** `nums1 = [0, 0, 0], m = 0`, `nums2 = [2, 5, 6], n = 3` → Salida esperada: `[2, 5, 6]`.
