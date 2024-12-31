### **Comprensión del problema**

[205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150)

1. **Desglose del problema:**

   - Se trata de determinar si dos cadenas, `s` y `t`, son isomorfas.
   - Dos cadenas son isomorfas si existe una relación uno a uno entre los caracteres de `s` y los de `t`. Es decir:
     - Cada carácter de `s` debe poder mapearse a un carácter único de `t`.
     - No pueden existir dos caracteres distintos de `s` que se mapeen al mismo carácter de `t`.
   - La relación debe preservar el orden: la misma posición en `s` debe corresponder a la misma posición en `t`.

2. **Requisitos específicos y condiciones:**

   - La longitud de las cadenas debe ser igual: `s.length == t.length`.
   - Los caracteres en las cadenas son válidos ASCII.
   - La entrada puede tener un tamaño considerable, hasta 50,000 caracteres.

3. **Preguntas clave:**
   - ¿Es necesario distinguir entre mayúsculas y minúsculas? (Por ejemplo, ¿"a" y "A" son distintos?)
   - ¿Qué hacer si alguna de las cadenas está vacía? (Por defecto, asumiremos que una cadena vacía es isomorfa con otra cadena vacía).

---

### **Planificación de la solución**

1. **Algoritmo sugerido:**

   - Usar dos diccionarios/mapas (uno para mapear de `s` a `t` y otro para mapear de `t` a `s`) para garantizar que las relaciones sean válidas en ambas direcciones.
   - Recorrer ambas cadenas al mismo tiempo y actualizar los diccionarios verificando que las relaciones existentes se mantengan consistentes.

2. **Estructuras de datos relevantes:**

   - Diccionario/HashMap (en Java, puede ser `HashMap<Character, Character>`).

3. **Plan detallado:**
   1. Verificar si las longitudes de las cadenas son diferentes; si lo son, retornar `false`.
   2. Crear dos mapas, `mapST` y `mapTS`, para rastrear las relaciones entre caracteres de `s` a `t` y de `t` a `s`, respectivamente.
   3. Iterar sobre los caracteres de `s` y `t`:
      - Si un carácter de `s` ya está mapeado, verificar que se mapea correctamente al carácter correspondiente en `t`.
      - Si un carácter de `t` ya está mapeado, verificar que se mapea correctamente al carácter correspondiente en `s`.
      - Si no existen mapeos previos, agregar una nueva relación a ambos mapas.
   4. Retornar `true` si se mantiene la consistencia en ambos mapas.

---

### **Ejecución del plan**

#### Código en Java:

```java
import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Verificar mapeo de s -> t
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

            // Verificar mapeo de t -> s
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}
```

---

### **Revisión y verificación**

1. **Validación de requisitos:**

   - La solución cumple con la condición de preservar la relación uno a uno entre caracteres.
   - Funciona eficientemente con una complejidad temporal de O(n), donde (n) es la longitud de las cadenas.

2. **Verificación de eficiencia:**

   - Complejidad espacial: O(n) debido a los mapas.
   - Casos extremos manejados:
     - Cadenas de longitud cero o uno.
     - Casos donde los caracteres tienen múltiples relaciones inválidas.

3. **Mejoras potenciales:**
   - Si las cadenas contienen solo caracteres limitados (por ejemplo, ASCII estándar), un arreglo de tamaño fijo podría reemplazar los mapas para ahorrar memoria.

---
