### **Problema**

[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **Objetivo del programa**

Queremos encontrar la longitud de la subcadena más larga que NO tenga letras repetidas.  
Por ejemplo:

- En `"abcabcbb"`, la subcadena más larga sin repeticiones es `"abc"`, que tiene 3 letras.
- En `"bbbbb"`, solo podemos usar `"b"`, así que la longitud es 1.

La idea es simple: identificar esa subcadena y medir su longitud. Pero en lugar de probar todas las combinaciones posibles (lo que sería súper lento), usamos un truco llamado "ventana deslizante" para hacerlo rápido.

---

### **Flujo del programa**

Vamos paso a paso:

1. **Pensar en el problema como una ventana que se mueve**  
   Imagina que tenemos una regla para medir texto, pero solo puedes medir desde un punto inicial hasta donde la regla sea válida (sin repeticiones). Esta regla es nuestra "ventana".

   - Empieza desde el principio de la cadena.
   - Amplía la ventana agregando más caracteres siempre que no se repitan.
   - Si encuentras una repetición, ajusta el punto inicial para que la ventana sea válida otra vez.

2. **Rastreo de los caracteres**  
   Necesitamos una forma de recordar qué caracteres ya están dentro de la ventana. Para eso usamos un conjunto (`HashSet`), que nos dice rápidamente si un carácter ya está ahí o no.

3. **Mover la ventana de manera dinámica**  
   Usamos dos punteros, uno llamado `start` (inicio de la ventana) y otro `end` (final de la ventana), para expandir y contraer la ventana:

   - El puntero `end` va avanzando para explorar la cadena.
   - Si no hay repeticiones, medimos la longitud de la ventana.
   - Si encontramos una repetición, movemos `start` hacia adelante hasta que la ventana sea válida otra vez.

4. **Actualizar la longitud máxima**  
   Cada vez que ajustamos la ventana, verificamos si la longitud actual es mayor que la longitud máxima registrada. Si es así, actualizamos la longitud máxima.

---

### **Cómo se relaciona cada paso con el objetivo**

1. **Abrir y mover la ventana**:  
   Estamos explorando diferentes subcadenas posibles. La ventana asegura que siempre sea continua y sin repeticiones, que es lo que queremos medir.

2. **Evitar repeticiones con el conjunto**:  
   El conjunto nos ayuda a recordar qué caracteres están en la ventana. Esto es clave para decidir si necesitamos ajustar la ventana o podemos seguir ampliándola.

3. **Ajustar el inicio (`start`) cuando hay repetición**:  
   Esto nos permite eliminar caracteres que ya no son válidos y mantener la ventana sin repeticiones. Es como "limpiar la regla" para seguir midiendo.

4. **Actualizar la longitud máxima**:  
   Cada vez que ampliamos o ajustamos la ventana, verificamos si encontramos una subcadena más larga que la anterior. Al final, el programa nos devuelve la longitud más grande que encontramos.

---

### **Ejemplo práctico: `"abcabcbb"`**

1. **Inicializamos**:

   - `start = 0`, `end = 0`, longitud máxima (`maxLength = 0`), y un conjunto vacío (`seen = {}`).

2. **Primeros pasos**:

   - `end = 0`, carácter es `'a'` → No está en el conjunto.  
     Añadimos `'a'` a `seen` → Ventana válida es `"a"`.  
     Longitud = `end - start + 1 = 1`.  
     Actualizamos `maxLength = 1`.

3. **Expandimos más**:

   - `end = 1`, carácter es `'b'` → No está en el conjunto.  
     Añadimos `'b'` → Ventana es `"ab"`.  
     Longitud = `2`. Actualizamos `maxLength = 2`.

   - `end = 2`, carácter es `'c'` → No está en el conjunto.  
     Añadimos `'c'` → Ventana es `"abc"`.  
     Longitud = `3`. Actualizamos `maxLength = 3`.

4. **Encuentra una repetición**:

   - `end = 3`, carácter es `'a'` → Ya está en el conjunto.  
     Esto significa que la ventana no es válida.  
     Ajustamos `start` para eliminar `'a'`. Ahora `start = 1`.  
     Ventana válida es `"bca"`.

5. **Repetimos este proceso** hasta recorrer toda la cadena.

Al final, la subcadena más larga encontrada es `"abc"` con longitud `3`.

---

### **Cómo pensar desde los primeros principios**

1. **¿Cuál es el problema más básico aquí?**

   - Medir una subcadena sin repeticiones.

2. **¿Qué hace falta para resolverlo?**

   - Una forma de rastrear caracteres sin repetición (usamos un conjunto).
   - Una manera de explorar y ajustar subcadenas de forma eficiente (ventana deslizante).

3. **¿Por qué funciona este enfoque?**
   - En lugar de calcular todas las subcadenas posibles, que sería lento O(n^2) o peor, este enfoque se mueve dinámicamente a través de la cadena en tiempo lineal O(n).
