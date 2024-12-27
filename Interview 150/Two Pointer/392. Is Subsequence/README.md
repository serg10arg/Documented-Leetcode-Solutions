### **Problema**

#### [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150)

### **Comprensión del problema**

El problema requiere determinar si una cadena `s` es una subsecuencia de otra cadena `t`. Para ello:

- Una **subsecuencia** se forma eliminando caracteres de `t` sin cambiar el orden relativo de los caracteres restantes.
- Debemos retornar `true` si `s` es una subsecuencia de `t`, y `false` en caso contrario.

**Ejemplo 1**:

- `s = "abc"`, `t = "ahbgdc"`. La subsecuencia `"abc"` se puede encontrar en `t`. Resultado: `true`.

**Ejemplo 2**:

- `s = "axc"`, `t = "ahbgdc"`. La subsecuencia `"axc"` no se puede formar sin cambiar el orden. Resultado: `false`.

---

#### **Preguntas clave**:

1. ¿Se permite que `s` esté vacía? (Sí, ya que una subsecuencia vacía siempre está presente en cualquier cadena.)
2. ¿Qué pasa si `t` está vacía? (Si `t` está vacía, `s` no puede ser subsecuencia, excepto si también está vacía.)
3. ¿Existen restricciones en los caracteres? (No, ambos strings contienen solo letras minúsculas del inglés.)

---

### **Planificación**

#### **Estrategia para resolver el problema básico:**

1. **Enfoque de dos punteros**:

   - Mantén dos punteros: uno para recorrer `s` y otro para recorrer `t`.
   - Avanza el puntero de `t` para buscar los caracteres de `s` en orden.
   - Si recorres todo `s` con éxito, significa que `s` es subsecuencia de `t`.

   **Complejidad**:

   - **Temporal**: O(n + m), donde n = s.length y m = t.length.
   - **Espacial**: O(1), porque no se utiliza memoria adicional significativa.

#### **Para la variante de grandes cantidades de cadenas sᵢ:**

- **Preprocesar `t` para optimizar la búsqueda**:

  - Construir un diccionario de posiciones para cada carácter en `t`.
  - Usar búsqueda binaria para encontrar los caracteres de `s` en orden.

  **Complejidad**:

  - **Preprocesamiento**: O(m), donde m = t.length.
  - **Consulta**: O(s.length \ log m) por cada sᵢ.

---

### **Ejecución del plan**

#### **Paso 1: Implementación básica con dos punteros**

```java
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++; // Avanza el puntero de s si encontramos un carácter coincidente
            }
            tPointer++; // Siempre avanza en t
        }

        return sPointer == s.length(); // Si hemos recorrido todo s, es subsecuencia
    }
}
```

#### **Paso 2: Optimización para grandes cantidades de cadenas \(s_i\)**

```java
import java.util.*;

public class IsSubsequenceOptimized {
    public static boolean isSubsequence(String s, String t) {
        // Preprocesamiento de t
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charPositions.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        // Verificación de subsecuencia usando búsqueda binaria
        int prevIndex = -1;
        for (char c : s.toCharArray()) {
            if (!charPositions.containsKey(c)) return false; // Carácter no está en t

            List<Integer> positions = charPositions.get(c);
            int nextIndex = binarySearch(positions, prevIndex);
            if (nextIndex == -1) return false; // No se encuentra el siguiente carácter
            prevIndex = positions.get(nextIndex);
        }
        return true;
    }

    private static int binarySearch(List<Integer> positions, int target) {
        int left = 0, right = positions.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (positions.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < positions.size() ? left : -1; // Retorna índice válido o -1
    }
}
```

---

### **Revisión y verificación**

1. **Validación**:

   - Pruebas unitarias con casos básicos y extremos:
     ```java
     public static void main(String[] args) {
         System.out.println(isSubsequence("abc", "ahbgdc")); // true
         System.out.println(isSubsequence("axc", "ahbgdc")); // false
         System.out.println(isSubsequence("", "ahbgdc")); // true
         System.out.println(isSubsequence("abc", "")); // false
     }
     ```

2. **Medición de eficiencia**:

   - Para la implementación optimizada:
     - Preprocesar `t` una vez es eficiente.
     - Las consultas son rápidas incluso para cadenas largas t y múltiples sᵢ.

3. **Mejoras potenciales**:
   - Paralelizar las consultas de sᵢ si son independientes.
   - Utilizar técnicas de compresión de datos para ahorrar memoria en casos extremos.

---

### **Resiliencia y desarrollo continuo**

- **Consejos para superar desafíos comunes**:

  - Divide los problemas grandes en pasos pequeños y claros.
  - Familiarízate con estructuras como mapas, listas y búsqueda binaria.
