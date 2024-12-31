### **Problema**

[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150)

### **Comprensión del problema**

Un **anagrama** es una palabra o frase formada reorganizando las letras de otra palabra o frase, usando todas las letras una vez y solo una vez.

#### Requisitos específicos:

1. Dado dos cadenas, `s` y `t`:
   - Devuelve `true` si `t` es un anagrama de `s`.
   - Devuelve `false` en caso contrario.

#### Restricciones:

- 1 <= leq s.length, t.length <= 50,000
- Las cadenas contienen solo letras minúsculas.

#### Preguntas clave:

1. ¿Es relevante que las cadenas contengan espacios o caracteres especiales? (Según el problema, no.)
2. ¿Debemos manejar cadenas de longitud diferente? (Si las longitudes son diferentes, podemos retornar inmediatamente `false`.)

---

### **Planificación de la solución**

#### Algoritmos/estructuras sugeridas:

1. **Conteo de caracteres**:

   - Utiliza un diccionario o un arreglo de frecuencia para contar las apariciones de cada letra.
   - Compara las frecuencias de ambas cadenas.
   - Complejidad: O(n) en tiempo y O(1) en espacio adicional (debido al número fijo de letras: 26).

2. **Ordenamiento**:
   - Ordena ambas cadenas y verifica si son iguales.
   - Complejidad: O(n log n) en tiempo.

#### Plan detallado:

1. Si las longitudes de `s` y `t` son diferentes, retorna `false`.
2. Crea un arreglo de tamaño 26 (para las letras del alfabeto) para registrar las frecuencias de cada letra en `s` y `t`.
3. Recorre ambas cadenas y actualiza las frecuencias:
   - Incrementa el contador para `s`.
   - Decrementa el contador para `t`.
4. Verifica si todas las frecuencias son cero al final.
5. Retorna `true` si las frecuencias son iguales, o `false` en caso contrario.

---

### **Ejecución del plan**

#### Código en Java:

```java
import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // Paso 1: Verifica si las longitudes son diferentes
        if (s.length() != t.length()) {
            return false;
        }

        // Paso 2: Crea un arreglo para contar las frecuencias
        int[] count = new int[26];

        // Paso 3: Actualiza las frecuencias
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Paso 4: Verifica si todas las frecuencias son cero
        for (int freq : count) {
            if (freq != 0) {
                return false;
            }
        }

        // Paso 5: Retorna true si son anagramas
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
```

#### Posibles errores/dificultades:

1. **Manejo de caracteres fuera del alfabeto inglés**: Aquí asumimos que solo hay letras minúsculas, pero podría ampliarse si fuera necesario.
2. **Overflow del arreglo**: Imposible en este caso, dado el rango de valores (0-25).

---

**Paso 1: Verificar si las longitudes son diferentes**

Java

```
if (s.length() != t.length()) {
    return false;
}
```

Aquí, el programa verifica si las longitudes de las cadenas `s` y `t` son diferentes. Si lo son, el programa devuelve `false` de inmediato, ya que no es posible que dos cadenas de diferentes longitudes sean anagramas.

**Paso 2: Crear un arreglo para contar las frecuencias**

Java

```
int[] count = new int[26];
```

En este paso, el programa crea un arreglo de 26 enteros llamado `count`. Este arreglo se utilizará para contar la frecuencia de cada letra en las cadenas `s` y `t`.

**Paso 3: Actualizar las frecuencias**

Java

```
for (int i = 0; i < s.length(); i++) {
    count[s.charAt(i) - 'a']++;
    count[t.charAt(i) - 'a']--;
}
```

Aquí, el programa recorre las cadenas `s` y `t` simultáneamente. Para cada letra, el programa incrementa la frecuencia correspondiente en el arreglo `count` para la cadena `s`, y decrementa la frecuencia correspondiente para la cadena `t`.

**Paso 4: Verificar si todas las frecuencias son cero**

Java

```
for (int freq : count) {
    if (freq != 0) {
        return false;
    }
}
```

En este paso, el programa recorre el arreglo `count` y verifica si todas las frecuencias son cero. Si alguna frecuencia no es cero, el programa devuelve `false`, ya que esto indica que las cadenas `s` y `t` no son anagramas.

**Paso 5: Retornar true si son anagramas**

Java

```
return true;
```

Si el programa ha recorrido todos los pasos anteriores sin encontrar ninguna inconsistencia, devuelve `true`, indicando que las cadenas `s` y `t` son anagramas.

### **Revisión y verificación**

1. **Validación de requisitos**:

   - Ejemplo 1: `"anagram", "nagaram"` → Salida esperada: `true`. Resultado: `true`.
   - Ejemplo 2: `"rat", "car"` → Salida esperada: `false`. Resultado: `false`.

2. **Eficiencia**:

   - Complejidad temporal: O(n), donde n es la longitud de las cadenas.
   - Complejidad espacial: O(1), dado el tamaño fijo del arreglo.

3. **Pruebas adicionales**:
   - Entrada vacía: `""`, `""` → `true`.
   - Cadenas con caracteres repetidos: `"aaa"`, `"aaa"` → `true`.
   - Longitudes diferentes: `"abc"`, `"ab"` → `false`.

---
