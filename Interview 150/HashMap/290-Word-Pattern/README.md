### **Problema**

#### [290. Word Pattern](https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150)

---

### **1. Comprensión del problema**

#### Desglose del problema:

1. **Entrada**:
   - Un string `pattern` formado por letras minúsculas.
   - Un string `s` que contiene palabras separadas por espacios.
2. **Salida**:
   - `true` si existe una relación biyectiva entre cada letra del `pattern` y una palabra en `s`.
   - `false` de lo contrario.
3. **Condiciones**:
   - Cada letra del `pattern` debe corresponder a exactamente una palabra única en `s`.
   - Cada palabra en `s` debe corresponder a exactamente una letra única en `pattern`.
   - La longitud de `s` (en palabras) debe coincidir con la longitud de `pattern`.

#### Preguntas clave:

1. ¿Podemos asumir que `s` siempre está bien formateado (sin espacios extra ni palabras vacías)?  
   **Respuesta: Sí, según los enunciados.**
2. ¿Qué hacemos si `pattern` y `s` tienen longitudes diferentes (en términos de caracteres y palabras, respectivamente)?  
   **Respuesta: Inmediatamente retornamos `false`.**
3. ¿Debemos distinguir entre letras mayúsculas y minúsculas en `pattern`?  
   **Respuesta: No, solo hay letras minúsculas.**

---

### **2. Planificación**

#### Algoritmo sugerido:

Usaremos un enfoque basado en mapas (hashmaps/diccionarios) para rastrear las asignaciones de letras a palabras y de palabras a letras:

1. Dividimos el string `s` en una lista de palabras.
2. Verificamos si la longitud de `pattern` coincide con la cantidad de palabras en `s`.
3. Creamos dos mapas:
   - Uno para mapear letras del `pattern` a palabras de `s`.
   - Otro para mapear palabras de `s` a letras del `pattern`.
4. Iteramos por el `pattern` y las palabras de `s`:
   - Si una letra ya está mapeada, verificamos que coincida con la palabra actual.
   - Si una palabra ya está mapeada, verificamos que coincida con la letra actual.
5. Si todas las verificaciones son válidas, retornamos `true`. De lo contrario, `false`.

---

### **3. Ejecución**

#### Implementación en Java:

```java
import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // Dividir s en palabras

        if (pattern.length() != words.length) {
            return false; // Tamaños diferentes, no puede haber mapeo
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Verificar mapeo de letra a palabra
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Conflicto en el mapeo
                }
            } else {
                charToWord.put(c, word); // Registrar nuevo mapeo
            }

            // Verificar mapeo de palabra a letra
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Conflicto en el mapeo
                }
            } else {
                wordToChar.put(word, c); // Registrar nuevo mapeo
            }
        }

        return true; // Mapeo exitoso
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
    }
}
```

---

**Objetivo del programa:**

El objetivo de este programa es determinar si un patrón de caracteres (representado por la variable `pattern`) se puede mapear a una secuencia de palabras (representada por la variable `s`) de manera que cada caracter del patrón se asocie con una palabra única y viceversa.

**Paso 1: Dividir la secuencia de palabras en un arreglo de palabras**

Java

```
String[] words = s.split(" ");
```

Aquí, el programa divide la secuencia de palabras (`s`) en un arreglo de palabras individuales (`words`) utilizando el método `split()` con un espacio en blanco como separador.

**Paso 2: Verificar si el patrón y la secuencia de palabras tienen la misma longitud**

Java

```
if (pattern.length() != words.length) {
    return false;
}
```

En este paso, el programa verifica si el patrón (`pattern`) y la secuencia de palabras (`words`) tienen la misma longitud. Si no es así, el programa devuelve `false` de inmediato, ya que no es posible establecer un mapeo entre el patrón y la secuencia de palabras.

**Paso 3: Crear dos mapas para almacenar el mapeo entre caracteres y palabras**

Java

```
HashMap<Character, String> charToWord = new HashMap<>();
HashMap<String, Character> wordToChar = new HashMap<>();
```

Aquí, el programa crea dos mapas: `charToWord` para almacenar el mapeo de caracteres a palabras y `wordToChar` para almacenar el mapeo de palabras a caracteres.

**Paso 4: Recorrer el patrón y la secuencia de palabras, y verificar el mapeo**

Java

```
for (int i = 0; i < pattern.length(); i++) {
    char c = pattern.charAt(i);
    String word = words[i];

    // Verificar mapeo de letra a palabra
    if (charToWord.containsKey(c)) {
        if (!charToWord.get(c).equals(word)) {
            return false;
        }
    } else {
        charToWord.put(c, word);
    }

    // Verificar mapeo de palabra a letra
    if (wordToChar.containsKey(word)) {
        if (wordToChar.get(word) != c) {
            return false;
        }
    } else {
        wordToChar.put(word, c);
    }
}
```

En este paso, el programa recorre el patrón (`pattern`) y la secuencia de palabras (`words`) simultáneamente. Para cada caracter (`c`) del patrón y la palabra correspondiente (`word`) de la secuencia, el programa verifica si el mapeo entre el caracter y la palabra es consistente.

Si el caracter (`c`) ya está en el mapa `charToWord`, el programa verifica si la palabra asociada con ese caracter es igual a la palabra actual (`word`). Si no es así, el programa devuelve `false`.

- Si el caracter (`c`) ya está en el mapa `charToWord`, el programa verifica si la palabra asociada con ese caracter es igual a la palabra actual (`word`). Si no es así, el programa devuelve `false`.

Si el caracter (`c`) no está en el mapa `charToWord`, el programa agrega el mapeo entre el caracter y la palabra al mapa.

- Si el caracter (`c`) no está en el mapa `charToWord`, el programa agrega el mapeo entre el caracter y la palabra al mapa.

El programa realiza una verificación similar para el mapeo de la palabra (`word`) a la letra (`c`) en el mapa `wordToChar`.

- El programa realiza una verificación similar para el mapeo de la palabra (`word`) a la letra (`c`) en el mapa `wordToChar`.

**Paso 5: Devolver el resultado**

Java

```
return true;
```

Si el programa ha recorrido todo el patrón y la secuencia de palabras sin encontrar ninguna inconsistencia en el mapeo, devuelve `true`, indicando que el patrón y la secuencia de palabras son compatibles.

---

### **4. Revisión**

1. **Validación**:
   - **Pruebas realizadas**:
     - `pattern = "abba"` y `s = "dog cat cat dog"` → `true`.
     - `pattern = "abba"` y `s = "dog cat cat fish"` → `false`.
     - `pattern = "aaaa"` y `s = "dog cat cat dog"` → `false`.
   - Todas cumplen con las expectativas.
2. **Complejidad**:
   - **Espacial**: O(n), donde n es la longitud del patrón o número de palabras en s.
   - **Temporal**: O(n), debido a una única iteración a través de los elementos.
3. **Mejoras posibles**:
   - Podríamos optimizar ligeramente el manejo de mapeos combinando ambas verificaciones en un solo mapa, pero esto podría disminuir la claridad.

---

### **5. Resiliencia y desarrollo continuo**

#### Consejos prácticos:

- **Errores comunes**:
  - No dividir correctamente el string `s`.
  - Olvidar verificar conflictos en ambos mapas.
- **Cómo evitarlos**:
  - Verifica que los tamaños coincidan antes de iniciar el mapeo.
  - Prueba con casos límite como patrones con letras repetidas o cadenas vacías.

#### Ideas para mejorar:

- Practica problemas similares como:
  - Verificar si dos cadenas son isomorfas.
  - Implementar una versión inversa: reconstruir el patrón a partir de las palabras.
