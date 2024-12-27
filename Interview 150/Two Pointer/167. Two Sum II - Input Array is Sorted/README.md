### **Problema**

#### [167. Two Sum II - Input Array is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150)

### **Objetivo del programa**

Este programa tiene una misión: encontrar dos números en un arreglo que sumen un número objetivo (`target`). Además, el arreglo ya está ordenado (es decir, los números van de menor a mayor). Una vez que encuentra esos dos números, devuelve sus posiciones, pero no como se indexan en programación (empezando desde 0), sino de forma humana, empezando desde 1.

Ejemplo:

- Si el arreglo es `[2, 7, 11, 15]` y queremos que sumen `9`, buscamos `2 + 7`, ¡bingo! Nos devuelve `[1, 2]`.

---

### **Flujo del programa**

1. **Entendiendo los ingredientes básicos**:

   - Tienes un **arreglo de números** llamado `numbers`. Ejemplo: `[2, 7, 11, 15]`.
   - Tienes un **número objetivo** llamado `target`. Ejemplo: `9`.
   - Tu trabajo es encontrar dos números en ese arreglo que sumen exactamente `target`.

2. **¿Qué herramienta usamos?**

   - El programa usa una técnica llamada **punteros duales**. Básicamente, tenemos dos "dedos mágicos" que comienzan en extremos opuestos del arreglo:
     - Uno apunta al principio del arreglo (`left`).
     - El otro apunta al final del arreglo (`right`).

3. **El ciclo que resuelve el misterio**:

   - Mientras `left` esté antes de `right`, hacemos lo siguiente:
     1. Sumamos los números donde están los punteros (`numbers[left] + numbers[right]`).
     2. **¿La suma es igual al objetivo?** ¡Hurra! Ya encontramos la solución y devolvemos los índices.
     3. **¿La suma es menor que el objetivo?** Mueve el puntero izquierdo (`left++`) para intentar aumentar la suma.
     4. **¿La suma es mayor que el objetivo?** Mueve el puntero derecho (`right--`) para intentar disminuir la suma.

4. **La magia de que siempre haya una solución**:

   - El problema garantiza que siempre habrá una respuesta correcta. Por eso, no necesitamos preocuparnos por casos donde no haya solución.

5. **Resultados ajustados para humanos**:
   - Cuando encontramos los números, devolvemos sus índices, pero sumándoles 1 (porque el enunciado pide que sea 1-indexado y no 0-indexado).

---

### **Relación de los pasos con el objetivo**

Cada parte del programa está diseñada para ser súper eficiente:

- **Arreglo ordenado**: Usar punteros duales funciona bien porque sabemos que los números están ordenados. Esto nos permite movernos rápidamente en la dirección correcta (sumas más grandes o más pequeñas).
- **Un solo ciclo**: Solo recorremos el arreglo una vez, moviendo los punteros. Esto ahorra tiempo y cumple la condición de usar "espacio constante" (no necesitamos estructuras adicionales como otro arreglo o mapa).
- **Garantía de solución**: Como siempre hay una respuesta, el programa no necesita verificar casos especiales, lo que lo hace más directo.

---

### **Desglose paso a paso en acción**

Imagina el caso:

- Arreglo: `[2, 7, 11, 15]`
- Objetivo (`target`): `9`

**Inicio**:

- Puntero izquierdo (`left`): Apunta al `2` (posición 0).
- Puntero derecho (`right`): Apunta al `15` (posición 3).

**Primer intento**:

- Suma: `2 + 15 = 17`.
- Como `17 > 9`, movemos el puntero derecho para reducir la suma (`right--`).

**Segundo intento**:

- Ahora, `right` apunta al `11` (posición 2).
- Suma: `2 + 11 = 13`.
- Como `13 > 9`, movemos el puntero derecho de nuevo (`right--`).

**Tercer intento**:

- Ahora, `right` apunta al `7` (posición 1).
- Suma: `2 + 7 = 9`.
- ¡Éxito! Devolvemos los índices `[1, 2]` (recordando que sumamos 1 a las posiciones).

---
