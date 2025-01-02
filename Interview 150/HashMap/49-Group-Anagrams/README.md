### **Problema**

[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150)

### **Comprensión del problema**

El objetivo es agrupar las palabras que son anagramas entre sí dentro de un array de strings (`strs`). Un **anagrama** es una palabra o frase formada al reorganizar las letras de otra palabra o frase, utilizando todas las letras originales exactamente una vez.

#### **Requisitos específicos**:

1. Agrupar todas las palabras que sean anagramas en sublistas.
2. Cada sublista debe contener únicamente anagramas entre sí.
3. El resultado puede estar en cualquier orden.
4. Considerar casos límite como entradas vacías o strings con una sola letra.

#### **Preguntas clave**:

1. ¿La solución debe preservar el orden original de las palabras en el array de entrada?
2. ¿Existen restricciones en el tiempo de ejecución o eficiencia esperada (por ejemplo, complejidad lineal o cuadrática)?
3. ¿Qué debemos devolver si `strs` está vacío?
4. ¿Podemos usar estructuras auxiliares como diccionarios o mapas para resolver el problema?

---

### **Planificación**

#### **Idea principal**:

Usar un enfoque basado en hashing para agrupar palabras. La clave del hash puede ser:

1. Las letras ordenadas alfabéticamente (por ejemplo, "eat" → "aet").
2. Un conteo de las frecuencias de las letras.

#### **Pasos detallados**:

1. **Iterar sobre cada palabra**:
   - Convertir cada palabra en una representación canónica (como ordenar sus letras o usar un contador).
   - Usar esta representación como clave en un diccionario.
2. **Construir el diccionario**:
   - Las claves serán las representaciones canónicas.
   - Los valores serán listas de palabras que comparten esa representación.
3. **Devolver los valores del diccionario como la lista de grupos de anagramas**.

#### **Estructura de datos relevante**:

- Usaremos un **`HashMap`** (`Map<String, List<String>>` en Java) para agrupar palabras según su clave canónica.

---

### **Ejecución**

#### **Código en Java**:

```java
import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Mapa para agrupar palabras basadas en su clave canónica
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Clave canónica: ordenar las letras de la palabra
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Agregar la palabra al grupo correspondiente
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Devolver los valores del mapa como lista de grupos
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        // Ejemplo 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));

        // Ejemplo 2
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));

        // Ejemplo 3
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }
}
```

---

### **Revisión**

#### **Validación**:

1. **Pruebas básicas**:
   - `["eat", "tea", "tan", "ate", "nat", "bat"]` → `[["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]`
   - `[""]` → `[[""]]`
   - `["a"]` → `[["a"]]`
2. **Casos extremos**:
   - Entrada vacía: `[]` → `[]`.
   - Palabras sin anagramas: `["abc", "def", "ghi"]` → `[["abc"], ["def"], ["ghi"]]`.
3. **Eficiencia**:
   - Complejidad temporal: O(n ⋅ klogk), donde n es el número de palabras y k la longitud promedio de cada palabra (debido al ordenamiento).
   - Complejidad espacial: O(n ⋅ k), para almacenar las palabras en el mapa.

#### **Mejoras posibles**:

1. En lugar de ordenar las letras para generar la clave, usar un array de tamaño fijo (26 posiciones) para contar las frecuencias de las letras. Esto mejora la eficiencia al evitar la operación de ordenamiento.

---
