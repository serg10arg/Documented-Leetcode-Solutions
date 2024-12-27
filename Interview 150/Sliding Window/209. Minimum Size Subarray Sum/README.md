### **Problema**

#### [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **El objetivo del programa (Sliding Window)**

Queremos encontrar la **subsecuencia más pequeña** dentro de un arreglo de números que sume al menos un valor llamado `target`. Si no encontramos ninguna que lo haga, devolvemos `0`.

Por ejemplo, si te doy los números `[2, 3, 1, 2, 4, 3]` y te pido que sumen al menos `7`, tú buscarías **la menor cantidad de números consecutivos** que den al menos `7`. En este caso, sería `[4, 3]` (longitud 2).

---

### **El enfoque de Sliding Window**

El truco aquí es pensar como si estuvieras viendo a través de una ventana que puede cambiar de tamaño. La idea es:

1. **Expandir la ventana** para incluir más números hasta que la suma cumpla con el objetivo (`>= target`).
2. **Reducir la ventana** desde el inicio (si es posible) para ver si logramos la misma suma con menos números.

Esto es súper eficiente porque no revisamos todas las combinaciones posibles (lo que sería muy lento), sino que aprovechamos lo que ya calculamos.

---

### **Paso a paso (pensando desde los principios básicos)**

1. **Partimos desde el inicio**

   - Imagina que tienes un puntero (`start`) al principio del arreglo que señala dónde comienza la ventana.
   - Otro puntero (`end`) se moverá para expandir la ventana.
   - Declaramos las variables básicas para manejar la ventana:
     ```java
     int start = 0; // Inicio de la ventana
     int sum = 0;   // Suma de los elementos dentro de la ventana
     int minLength = Integer.MAX_VALUE; // Longitud mínima inicializada como infinita
     ```

2. **Sumamos números al mover el puntero `end`**

   - Mientras `end` se mueve por el arreglo, vamos agregando cada número a una variable `sum`, que lleva la cuenta de los números dentro de la ventana.
   - Usamos un bucle para expandir la ventana añadiendo cada número al `sum`:
     ```java
     for (int end = 0; end < nums.length; end++) {
         sum += nums[end]; // Expande la ventana al sumar el número actual
     }
     ```
   - Aquí estamos "corriendo" el puntero `end` hacia adelante, como si fuéramos extendiendo la ventana.

3. **Verificamos si la suma alcanza el objetivo (`>= target`)**

   - Si no alcanza, seguimos moviendo el puntero `end` para expandir la ventana y agregar más números.
   - Dentro del bucle, comprobamos si la suma de la ventana es suficiente:
     ```java
     while (sum >= target) {
         // Aquí ya hemos encontrado una ventana válida
     }
     ```
   - Si la suma no es suficiente, el bucle `while` no se ejecuta y seguimos expandiendo con `end`.

4. **Reducimos la ventana desde el inicio (`start`)**

   - Si la suma ya alcanza o supera el objetivo, intentamos **achicar la ventana** moviendo el puntero `start` hacia adelante. Esto ayuda a minimizar la cantidad de números dentro de la ventana mientras mantenemos la suma.
   - Dentro del `while`, intentamos achicar la ventana moviendo el puntero `start` hacia adelante:
     ```java
     while (sum >= target) {
         minLength = Math.min(minLength, end - start + 1); // Actualizamos la longitud mínima
         sum -= nums[start]; // Reducimos la suma quitando el número en el inicio
         start++; // Movemos el inicio hacia adelante
     }
     ```
   - Esto nos permite encontrar la ventana más pequeña posible que aún cumpla con el objetivo.

5. **Guardamos la longitud más pequeña**

   - Cada vez que encontramos una ventana válida (es decir, su suma es `>= target`), comparamos su longitud con la mínima encontrada hasta ahora. Guardamos la menor de todas.
   - Cada vez que actualizamos `minLength`, estamos guardando la ventana válida más corta encontrada hasta ese momento:
     ```java
     minLength = Math.min(minLength, end - start + 1);
     ```
   - Este cálculo compara la longitud actual (`end - start + 1`) con la longitud más pequeña registrada.

6. **Repetimos hasta recorrer todo el arreglo**
   - Al final, si nunca encontramos una ventana válida, devolvemos `0`. Si encontramos una o más, devolvemos la longitud más pequeña.
   - Cuando el bucle principal termina, verificamos si encontramos alguna ventana válida. Si `minLength` no cambió desde su valor inicial, devolvemos `0`:
     ```java
     return minLength == Integer.MAX_VALUE ? 0 : minLength;
     ```

---

### **Conexión con el objetivo**

El objetivo era encontrar la subarray más corta que cumpliera con la suma. La magia del sliding window es que:

1. Solo recorremos el arreglo una vez, porque el puntero `start` solo avanza hacia adelante.
2. En cada paso, tratamos de encontrar una solución válida y minimizarla al mismo tiempo.

---

### **Ejemplo detallado (aplicando sliding window)**

#### Datos:

`target = 7`  
`nums = [2, 3, 1, 2, 4, 3]`

1. **Inicialización**:

   - `start = 0`, `sum = 0`, `minLength = ∞`

2. **Primer paso (`end = 0`)**:

   - Sumamos `nums[0] = 2`. Ahora `sum = 2`.
   - No alcanzamos el objetivo (`2 < 7`), así que seguimos.

3. **Segundo paso (`end = 1`)**:

   - Sumamos `nums[1] = 3`. Ahora `sum = 5`.
   - No alcanzamos el objetivo (`5 < 7`), así que seguimos.

4. **Tercer paso (`end = 2`)**:

   - Sumamos `nums[2] = 1`. Ahora `sum = 6`.
   - No alcanzamos el objetivo (`6 < 7`), así que seguimos.

5. **Cuarto paso (`end = 3`)**:

   - Sumamos `nums[3] = 2`. Ahora `sum = 8`.
   - **¡Cumplimos el objetivo!** La ventana es `[2, 3, 1, 2]`. Longitud = `4`.
   - Ahora intentamos reducir la ventana moviendo `start`:
     - Quitamos `nums[0] = 2`. Ahora `sum = 6`.
     - No cumple el objetivo, así que dejamos `start` aquí.

6. **Quinto paso (`end = 4`)**:

   - Sumamos `nums[4] = 4`. Ahora `sum = 10`.
   - **¡Cumplimos el objetivo!** La ventana es `[3, 1, 2, 4]`. Longitud = `4`.
   - Intentamos reducir la ventana:
     - Quitamos `nums[1] = 3`. Ahora `sum = 7`.
     - **Sigue cumpliendo!** La ventana es `[1, 2, 4]`. Longitud = `3`.
     - Quitamos `nums[2] = 1`. Ahora `sum = 6`. No cumple, paramos.

7. **Sexto paso (`end = 5`)**:

   - Sumamos `nums[5] = 3`. Ahora `sum = 9`.
   - **¡Cumplimos el objetivo!** La ventana es `[2, 4, 3]`. Longitud = `3`.
   - Intentamos reducir la ventana:
     - Quitamos `nums[3] = 2`. Ahora `sum = 7`. **Sigue cumpliendo!**
     - La ventana es `[4, 3]`. Longitud = `2`.

8. **Fin del arreglo**:
   - La longitud mínima encontrada es `2`.

---

### **Conclusión**

El sliding window funciona porque **expandimos y reducimos la ventana de manera inteligente**, siempre buscando minimizar su tamaño cuando encontramos una solución válida. Es rápido y eficiente porque cada elemento del arreglo se procesa una sola vez.

---
