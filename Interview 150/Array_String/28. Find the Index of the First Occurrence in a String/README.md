### **Resolución del problema: Encontrar el índice de la primera ocurrencia de una subcadena en una cadena**

---

#### **1. Comprensión del problema**

- **Desglose**:

  - Nos dan dos cadenas: `haystack` (pajar) y `needle` (aguja).
  - Debemos encontrar el índice donde aparece por primera vez la subcadena `needle` en `haystack`.
  - Si no existe, devolvemos `-1`.

- **Preguntas clave**:

  - ¿Se permite el uso de métodos incorporados como `indexOf` en Java o debemos implementar la lógica manualmente?
  - ¿Importa la eficiencia temporal? Por ejemplo, ¿se espera una solución que sea más rápida que O(n \* m) en el peor caso?
  - ¿Es sensible a mayúsculas/minúsculas? Dado el problema, parece que no lo es.

- **Requisitos específicos**:
  - Ambas cadenas contienen solo letras minúsculas inglesas.
  - La longitud de las cadenas puede llegar hasta \(10^4\), por lo que debemos considerar la eficiencia.

---

#### **2. Planificación de la solución**

##### **Algoritmos o estructuras sugeridas**:

1. **Solución ingênua (Búsqueda directa)**:

   - Iterar por cada índice en `haystack` y verificar si el segmento desde el índice actual coincide con `needle`.

2. **Optimización con algoritmos avanzados**:
   - **KMP (Knuth-Morris-Pratt)**: Un algoritmo eficiente para buscar patrones con complejidad O(n + m).
   - **Rabin-Karp**: Algoritmo basado en hashing para encontrar cadenas, con un costo promedio O(n + m).

##### **Plan detallado**:

1. Comenzaremos con una solución directa para entender la lógica básica.
2. Implementaremos KMP para una solución óptima.

---

#### **3. Ejecución del plan**

### **1. Solución básica: Búsqueda directa**

Esta solución es fácil de entender y funciona bien para tamaños de entrada pequeños o moderados.

```java
public class FirstOccurrence {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Si needle es más grande que haystack, no puede estar contenido.
        if (needleLen > haystackLen) return -1;

        // Recorrer el haystack para buscar la subcadena
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // Comparar la subcadena actual con needle
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i; // Retornar el índice de la primera coincidencia
            }
        }
        return -1; // Si no se encuentra needle
    }

    public static void main(String[] args) {
        FirstOccurrence solution = new FirstOccurrence();

        // Ejemplos de prueba
        System.out.println(solution.strStr("sadbutsad", "sad")); // Output: 0
        System.out.println(solution.strStr("leetcode", "leeto")); // Output: -1
    }
}
```

---

### **2. Solución óptima: Algoritmo KMP**

El algoritmo **Knuth-Morris-Pratt** utiliza una tabla de prefijos para optimizar el proceso de búsqueda. Aquí tienes la implementación completa:

```java
public class FirstOccurrenceKMP {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0; // Si needle está vacío, retornar 0

        // Construir la tabla de prefijos para needle
        int[] lps = buildLPS(needle);

        // Buscar needle en haystack
        int i = 0; // Índice para haystack
        int j = 0; // Índice para needle
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j; // Retornar el índice de la primera coincidencia
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Usar la tabla de prefijos
                } else {
                    i++;
                }
            }
        }
        return -1; // Si no se encuentra needle
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0; // Longitud de la subsecuencia más larga

        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    i--; // Reintentar con un índice menos
                } else {
                    lps[i] = 0;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        FirstOccurrenceKMP solution = new FirstOccurrenceKMP();

        // Ejemplos de prueba
        System.out.println(solution.strStr("sadbutsad", "sad")); // Output: 0
        System.out.println(solution.strStr("leetcode", "leeto")); // Output: -1
    }
}
```

Con la entrada `haystack = "leetcode"` y `needle = "leeto"`, podemos analizar cómo se comporta el algoritmo **Knuth-Morris-Pratt (KMP)**. Aquí hay una descripción paso a paso:

### **1. Construcción de la tabla de prefijos (LPS) para el patrón (`needle = "leeto"`)**

Construimos la tabla LPS para `needle` siguiendo el proceso descrito anteriormente.

| Índice (`i`) | Patrón hasta `i` | Longitud del prefijo más largo (LPS) |
| ------------ | ---------------- | ------------------------------------ |
| 0            | `"l"`            | 0                                    |
| 1            | `"le"`           | 0                                    |
| 2            | `"lee"`          | 0                                    |
| 3            | `"leet"`         | 0                                    |
| 4            | `"leeto"`        | 0                                    |

**Explicación:**

- Ningún prefijo coincide con un sufijo para este patrón (`"leeto"`). Por lo tanto, todos los valores en la tabla LPS son 0.

---

### **2. Proceso de búsqueda en `haystack = "leetcode"`**

**Inicialización:**

- `i = 0`: Índice en el `haystack`.
- `j = 0`: Índice en el `needle`.

#### Iteración 1:

- Comparamos `haystack[i]` con `needle[j]` (`'l' == 'l'`).
- Coinciden, avanzamos: `i = 1`, `j = 1`.

#### Iteración 2:

- Comparamos `haystack[i]` con `needle[j]` (`'e' == 'e'`).
- Coinciden, avanzamos: `i = 2`, `j = 2`.

#### Iteración 3:

- Comparamos `haystack[i]` con `needle[j]` (`'e' == 'e'`).
- Coinciden, avanzamos: `i = 3`, `j = 3`.

#### Iteración 4:

- Comparamos `haystack[i]` con `needle[j]` (`'t' == 't'`).
- Coinciden, avanzamos: `i = 4`, `j = 4`.

#### Iteración 5:

- Comparamos `haystack[i]` con `needle[j]` (`'c' != 'o'`).
- **No coinciden:**
  - Usamos la tabla LPS: `j = LPS[j - 1] = LPS[3] = 0`.
  - Reiniciamos `j` a 0 pero mantenemos `i` en 4.

#### Iteración 6 en adelante:

- Comparamos desde `haystack[4]` (`'c'`) con `needle[0]` (`'l'`).
- No coinciden.
- Seguimos avanzando con `i` hasta que el final del `haystack` se alcance.

---

### **3. Resultado final**

Después de recorrer todo el `haystack`, no encontramos ninguna coincidencia completa de `needle` en `haystack`. Por lo tanto, el resultado es **`-1`**.

---

### **4. Comportamiento del programa**

- **Complejidad temporal:**

  - Construcción de LPS: \( O(m) \), donde \( m \) es la longitud del `needle`.
  - Búsqueda: \( O(n) \), donde \( n \) es la longitud del `haystack`.
  - Total: \( O(n + m) \).

- **Optimización:**
  - Gracias a la tabla LPS, evitamos retroceder innecesariamente en el `haystack`.

---

### **Diferencias clave entre las dos soluciones**

1. **Eficiencia**:

   - La solución básica tiene una complejidad temporal de \(O(n \cdot m)\), donde \(n\) es la longitud de `haystack` y \(m\) la de `needle`.
   - La solución KMP mejora esto a \(O(n + m)\) gracias a la tabla de prefijos.

2. **Facilidad de implementación**:
   - La solución básica es más sencilla de implementar.
   - La solución KMP es más eficiente pero requiere entender cómo construir y usar la tabla de prefijos.

---

#### **4. Revisión y verificación**

- **Validación**:

  - Verificar si la solución cumple con ejemplos dados:
    - `haystack = "sadbutsad", needle = "sad" → Output = 0`.
    - `haystack = "leetcode", needle = "leeto" → Output = -1`.
  - Probar con casos límite como:
    - Cadenas vacías o needle mayor que haystack.
    - Casos de repetición o caracteres únicos.

- **Complejidad**:
  - Solución ingenua: \(O(n \cdot m)\).
  - Solución KMP: \(O(n + m)\).

---
