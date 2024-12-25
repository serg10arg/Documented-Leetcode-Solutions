# Longitud de la Última Palabra

Este documento describe el proceso para encontrar la longitud de la última palabra en una cadena dada que contiene palabras y espacios.

## 1. Comprensión del Problema

**Desglose:**

- Se nos proporciona una cadena `s` que contiene palabras y espacios.
- Una "palabra" es una secuencia de caracteres no espaciales.
- El objetivo es determinar la longitud de la última palabra en la cadena.

**Ejemplos relevantes:**

- "Hello World" -> Última palabra: "World", Longitud: 5
- " fly me to the moon " -> Última palabra: "moon", Longitud: 4
- "luffy is still joyboy" -> Última palabra: "joyboy", Longitud: 6

**Preguntas clave:**

- ¿Puede haber múltiples espacios consecutivos? Sí, el problema ya lo menciona.
- ¿Hay siempre al menos una palabra en la cadena? Sí, según las restricciones (se asume que sí, aunque sería mejor que estuviera explícitamente definido).
- ¿Cómo manejamos espacios al principio o al final de la cadena? Los ignoramos.

## 2. Planificación de la Solución

**Algoritmo sugerido (con `split()`):**

1.  Eliminar espacios al principio y al final de la cadena usando `trim()`.
2.  Dividir la cadena en palabras usando `split(" ")`.
3.  Obtener la última palabra del array resultante y calcular su longitud.

**Estructura de datos relevante:**

- Cadenas y arrays de palabras generados por `split()`.

**Inspiración en problemas similares:**

Este problema se enmarca dentro del análisis de cadenas, comúnmente resuelto con métodos básicos de manipulación de strings.

## 3. Ejecución del Plan

**Implementación en Java (con `split()`):**

````java
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Eliminar espacios al principio y al final
        s = s.trim();
        // Dividir la cadena en palabras
        String[] words = s.split(" ");
        // Retornar la longitud de la última palabra
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        // Ejemplos
        System.out.println(lengthOfLastWord("Hello World")); // Output: 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // Output: 6
    }
}

## 4. Revisión y Verificación

**Validación:**

*   **Requisitos iniciales:** La solución funciona correctamente con ejemplos que contienen múltiples espacios y palabras.

*   **Eficiencia (con `split()`):**
    *   **Complejidad temporal:** `trim()` y `split()` recorren la cadena una vez → O(n). Obtener la longitud de una palabra es O(1). Complejidad temporal total: O(n).
    *   **Complejidad espacial:** Se utiliza un array intermedio para almacenar las palabras → O(n).

**Pruebas adicionales:**

*   `" singleWord "` -> Longitud: 10 (con la versión que usa `split()`, aunque no es lo óptimo en términos de espacio).
*   `"a"` -> Longitud: 1.

**Mejoras potenciales:**

Se puede evitar el uso de estructuras intermedias (como el array generado por `split()`) para optimizar el uso de memoria y mejorar la eficiencia espacial.

**Versión mejorada sin `split()` (optimización de espacio):**

```java
public static int lengthOfLastWordOptimized(String s) {
    s = s.trim();
    int length = 0;
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) != ' ') {
        length++;
        i--;
    }
    return length;
}
````
