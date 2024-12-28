### **Problema**

#### [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **¿Qué hace este programa?**

El programa busca encontrar el **subcadena más pequeña en `s` que contenga todos los caracteres de `t`** (con la misma frecuencia). Si no existe tal subcadena, devuelve una cadena vacía (`""`).

Por ejemplo, si tienes:

- `s = "ADOBECODEBANC"` y `t = "ABC"`,  
  la subcadena más pequeña que contiene `A`, `B`, y `C` es `"BANC"`.

---

### **El plan general**

1. Usar un **mapa de frecuencias** para contar cuántas veces aparece cada carácter en `t`.
2. Usar una técnica llamada **ventana deslizante** para recorrer `s` y buscar el subtring más pequeño que cumpla con los requisitos.
3. Ajustar constantemente la ventana para **expandir** o **reducir** el rango de caracteres y así encontrar la solución más óptima.

---

### **Paso a paso: desglose del código**

#### **1. Validaciones iniciales**

```java
if (s == null || t == null || s.length() < t.length()) return "";
```

- **¿Qué hace?** Si `s` o `t` son nulos, o si `t` es más grande que `s` (obvio, no puede haber solución), devolvemos `""`.

---

#### **2. Preparar el mapa de frecuencias de `t`**

```java
HashMap<Character, Integer> charCountT = new HashMap<>();
for (char c : t.toCharArray()) {
    charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
}
```

- **¿Qué hace?** Cuenta cuántas veces aparece cada carácter en `t`.  
  Por ejemplo, si `t = "ABC"`, el mapa será:  
  `{'A': 1, 'B': 1, 'C': 1}`.

---

#### **3. Variables clave para la ventana deslizante**

```java
int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
int required = charCountT.size(); // Total de caracteres únicos que necesitamos
int formed = 0; // Cuántos caracteres únicos ya hemos satisfecho en la ventana actual
HashMap<Character, Integer> windowCounts = new HashMap<>();
```

- **`left` y `right`**: Límites izquierdo y derecho de la ventana.
- **`minLength`**: Guarda la longitud de la subcadena más pequeña encontrada.
- **`start`**: La posición donde empieza la mejor subcadena.
- **`required`**: El número total de caracteres únicos en `t` que necesitamos encontrar.
- **`formed`**: Cuántos caracteres de `required` ya están satisfechos en la ventana actual.

---

#### **4. Expandir la ventana deslizante**

```java
while (right < s.length()) {
    char c = s.charAt(right);
    windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

    if (charCountT.containsKey(c) && windowCounts.get(c).intValue() == charCountT.get(c).intValue()) {
        formed++;
    }
```

- **¿Qué hace?**
  - Agrega el carácter `c` de `s` al mapa `windowCounts` (frecuencias de la ventana).
  - Si `c` está en `t` y su frecuencia coincide, aumenta `formed`.

---

#### **5. Contraer la ventana**

```java
while (left <= right && formed == required) {
    char leftChar = s.charAt(left);

    if (right - left + 1 < minLength) {
        minLength = right - left + 1;
        start = left;
    }

    windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
    if (charCountT.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < charCountT.get(leftChar).intValue()) {
        formed--;
    }
    left++;
}
```

- **¿Qué hace?**
  - Intenta mover el límite izquierdo (`left`) hacia la derecha para reducir la ventana, siempre que todos los caracteres necesarios estén satisfechos (`formed == required`).
  - Si encuentra una ventana más pequeña, actualiza `minLength` y `start`.

---

#### **6. Continuar moviendo el límite derecho**

```java
right++;
```

- **¿Qué hace?** Expande la ventana para incluir más caracteres y seguir buscando.

---

#### **7. Devuelve el resultado**

```java
return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
```

- **¿Qué hace?**
  - Si nunca encontró una subcadena válida, devuelve `""`.
  - Si encontró una, devuelve la subcadena que empieza en `start` con longitud `minLength`.

---

### **Relación con el objetivo del programa**

El programa sigue un objetivo claro: **encontrar la subcadena más pequeña que cumple los requisitos de contener todos los caracteres de `t` con sus frecuencias respectivas**.  
Usa:

- **Mapas de frecuencia** para saber qué caracteres y cuántos necesitamos.
- **Ventanas deslizantes** para recorrer eficientemente `s` sin recalcular desde cero en cada paso.

---

### **Ejemplo práctico**

Supongamos que `s = "ADOBECODEBANC"` y `t = "ABC"`:

1. **Mapa inicial:** `{'A': 1, 'B': 1, 'C': 1}`.
2. **Expandimos la ventana:**
   - Ventana: `"ADOBEC"` → Contiene `A`, `B`, `C` → Longitud: 6.
3. **Contraemos:**
   - Ventana: `"BANC"` → Contiene `A`, `B`, `C` → Longitud: 4 (la más pequeña).
4. **Resultado:** `"BANC"`.

---
