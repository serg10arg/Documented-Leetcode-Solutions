### **Problema**

[30. Substring With Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150)

---

### **¿Cuál es el objetivo del programa?**

El programa busca todas las posiciones dentro de una cadena (`s`) donde se encuentre una combinación exacta de palabras dadas en el arreglo `words`. Estas palabras deben aparecer seguidas y sin mezclar, aunque el orden no importa. Por ejemplo, si `s = "barfoothefoobarman"` y `words = ["foo", "bar"]`, entonces queremos encontrar índices donde estas palabras aparecen juntas, como `"barfoo"` en el índice `0` y `"foobar"` en el índice `9`.

---

### **Primero, la idea básica**

Imagina que tienes un rompecabezas (la cadena `s`) y un conjunto de piezas (`words`). Este programa se encarga de mover una "ventana" sobre el rompecabezas para ver si las piezas encajan exactamente en cualquier lugar. Si encajan, guarda la posición inicial del encaje.

---

### **Planificación de la solución**

### **Idea principal:**

Usaremos una técnica basada en una ventana deslizante, aprovechando las propiedades de las palabras:

1. Todas tienen la misma longitud, lo que permite tratar el problema en "bloques" del tamaño de una palabra.
2. Las combinaciones posibles de `words` pueden validarse usando un contador (frecuencia).

### **Algoritmo paso a paso:**

1. **Variables clave:**
   - `wordLen`: Longitud de cada palabra en `words`.
   - `concatLen`: Longitud total de la concatenación (número de palabras × longitud de una palabra).
   - `wordCount`: Un diccionario que cuenta la frecuencia de cada palabra en `words`.
2. **Iterar sobre posibles inicios de ventanas:**
   - Para cada posición `i` desde 0 hasta `wordLen - 1`, consideramos subcadenas que empiezan en `i` y avanzan en bloques de tamaño `wordLen`.
3. **Deslizar la ventana:**
   - Usamos una ventana de tamaño `concatLen`.
   - Mantén un diccionario para contar palabras dentro de la ventana actual.
   - Si las palabras de la ventana coinciden con las de `words` (frecuencias iguales), añadimos el índice inicial a la solución.
4. **Optimizar con reinicios:**
   - Si encontramos una palabra que no pertenece a `words`, reiniciamos la ventana desde el siguiente bloque.

---

### **Paso a paso: ¿Qué hace cada parte del código?**

#### **1. Validación inicial**

```java
if (s == null || s.length() == 0 || words == null || words.length == 0) {
    return result;
}
```

- Antes de hacer cualquier cosa, el programa verifica que `s` y `words` no estén vacíos o nulos. Si algo anda mal, se regresa una lista vacía porque no hay nada que buscar.

---

#### **2. Calcula los tamaños importantes**

```java
int wordLen = words[0].length();
int concatLen = wordLen * words.length;
int sLen = s.length();
```

- **`wordLen`:** Tamaño de una palabra (todas tienen el mismo tamaño).
- **`concatLen`:** Tamaño total que ocuparían todas las palabras juntas.
- **`sLen`:** Tamaño de la cadena `s`.

---

#### **3. Crea un "mapa" de las palabras**

```java
Map<String, Integer> wordCount = new HashMap<>();
for (String word : words) {
    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}
```

- Aquí se hace un "inventario" de cuántas veces aparece cada palabra en `words`. Por ejemplo, si `words = ["foo", "bar", "foo"]`, el mapa será:
  ```java
  {"foo": 2, "bar": 1}
  ```

---

#### **4. Mueve una ventana sobre la cadena**

El programa usa un truco de dividir el análisis en "ventanas" según el tamaño de las palabras. Esto ayuda a no revisar combinaciones innecesarias. Por cada posible posición inicial (modulo el tamaño de las palabras), hace lo siguiente:

---

#### **5. Desliza la ventana**

```java
int start = i;
int end = i;
Map<String, Integer> windowCount = new HashMap<>();
int matchedWords = 0;
```

- **`start` y `end`:** Representan el inicio y fin de la ventana.
- **`windowCount`:** Lleva un registro de cuántas veces se han encontrado las palabras dentro de la ventana actual.
- **`matchedWords`:** Cuenta cuántas palabras de `words` coinciden exactamente hasta ahora.

---

#### **6. Extrae palabras y actualiza el conteo**

```java
String word = s.substring(end, end + wordLen);
end += wordLen;
```

- Aquí se extrae una palabra del tamaño correcto desde la cadena `s`, usando `end` como punto de inicio.

---

#### **7. Verifica si la palabra es válida**

Si la palabra está en el inventario (`wordCount`), la agrega al conteo de la ventana:

```java
if (wordCount.containsKey(word)) {
    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
    if (windowCount.get(word).equals(wordCount.get(word))) {
        matchedWords++;
    }
}
```

- Si el conteo de la palabra en la ventana coincide con el inventario, incrementa `matchedWords`.

---

#### **8. Ajusta la ventana si es demasiado grande**

Si la ventana supera el tamaño total esperado (`concatLen`), el programa "mueve" el inicio hacia adelante y ajusta los conteos:

```java
while (end - start > concatLen) {
    String leftWord = s.substring(start, start + wordLen);
    start += wordLen;
    if (windowCount.containsKey(leftWord)) {
        if (windowCount.get(leftWord).equals(wordCount.get(leftWord))) {
            matchedWords--;
        }
        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
    }
}
```

Esto asegura que siempre se trabaje con ventanas del tamaño correcto.

---

#### **9. Registra un resultado si hay coincidencia**

Si todas las palabras coinciden (es decir, `matchedWords == wordCount.size()`), agrega la posición inicial a la lista de resultados:

```java
if (matchedWords == wordCount.size()) {
    result.add(start);
}
```

---

#### **10. Resetea si encuentra una palabra inválida**

Si encuentra una palabra que no está en el inventario, vacía la ventana y comienza desde cero:

```java
windowCount.clear();
matchedWords = 0;
start = end;
```

---

### **En resumen**

1. Divide el problema en ventanas del tamaño correcto.
2. Mueve la ventana y revisa si las palabras encajan en la misma cantidad.
3. Ajusta si la ventana es demasiado grande.
4. Resetea si hay palabras inválidas.
5. Guarda las posiciones iniciales de las combinaciones válidas.

El flujo asegura que ninguna posición posible quede sin revisar, y al usar mapas, el programa se mantiene eficiente.
