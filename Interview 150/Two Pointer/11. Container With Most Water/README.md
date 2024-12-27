### **Problema**

#### [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150)

---

### **Objetivo del Programa**

El programa busca resolver un problema simple pero interesante: **encontrar el contenedor que puede almacenar la mayor cantidad de agua** entre dos líneas verticales dadas por un arreglo de alturas.

Piensa en cada valor del arreglo como la altura de una barra vertical, y queremos ver qué par de barras, junto con el eje x, forma el contenedor más grande.

---

### **Cómo funciona el programa**

Lo vamos a desglosar para entender:

---

#### **1. Entendiendo el problema desde lo básico**

1. **¿Qué significa el área del contenedor?**

   - Si tienes dos líneas, digamos en las posiciones `i` y `j`, la cantidad de agua que pueden almacenar depende de:
     - **La altura de la barra más baja** (no podemos llenar más alto que la barra más corta).
     - **La distancia horizontal entre las barras** (porque eso es el ancho del contenedor).
   - El área del agua almacenada se calcula como:
     - Área = altura mínima x distancia entre las barras

2. **¿Qué buscamos?**
   - Mover las barras para encontrar **el área más grande posible**.

---

#### **2. La estrategia del programa**

Usamos dos punteros, uno al principio (`left`) y otro al final (`right`) del arreglo, y los vamos acercando para probar diferentes combinaciones de barras. La clave aquí es que, en cada paso, movemos el puntero de la barra más corta porque solo así podemos encontrar una altura más alta que pueda aumentar el área.

---

#### **3. Paso a paso del código**

Voy a explicarlo desglosado:

1. **Definir los punteros y variables:**
   ```java
   int maxArea = 0;
   int left = 0;
   int right = height.length - 1;
   ```
   - `maxArea`: para guardar el área máxima encontrada hasta ahora.
   - `left`: empieza desde la primera barra (posición 0).
   - `right`: empieza desde la última barra.

---

2. **Iterar hasta que los punteros se crucen:**
   ```java
   while (left < right) {
       ...
   }
   ```
   - El bucle se detiene cuando `left` y `right` se encuentran porque ya no hay más barras para comparar.

---

3. **Calcular el área entre las dos barras actuales:**
   ```java
   int currentArea = Math.min(height[left], height[right]) * (right - left);
   maxArea = Math.max(maxArea, currentArea);
   ```
   - `Math.min(height[left], height[right])`: toma la altura de la barra más baja.
   - `(right - left)`: calcula la distancia entre las barras.
   - `maxArea`: actualizamos el área máxima si encontramos una mejor.

---

4. **Mover el puntero más corto:**
   ```java
   if (height[left] < height[right]) {
       left++;
   } else {
       right--;
   }
   ```
   - **¿Por qué mover el puntero más corto?**  
     Porque la barra más baja limita la altura máxima del contenedor. Si queremos encontrar un área mayor, necesitamos probar con barras más altas, y eso solo pasa si movemos ese puntero.

---

5. **Devolver el resultado:**
   ```java
   return maxArea;
   ```
   - Cuando el bucle termina, `maxArea` tiene el valor que buscábamos: **el área más grande posible**.

---

### **Relación entre los pasos y el objetivo**

- Cada paso del programa se centra en maximizar el área moviendo los punteros de manera inteligente.
- En lugar de comparar todas las combinaciones posibles (lo cual sería lento), usamos una técnica eficiente: **los punteros se mueven hacia el centro solo si tiene sentido hacerlo**, reduciendo el tiempo de ejecución a O(n).

---

### **Flujo General del Programa**

1. Define los límites (punteros `left` y `right`).
2. Calcula el área actual entre esas barras.
3. Actualiza el área máxima si la nueva es mejor.
4. Decide cuál de los dos punteros mover (siempre el que apunta a la barra más baja).
5. Repite hasta que no queden más combinaciones posibles.
6. Devuelve el área más grande encontrada.

---

### **Conexión con la vida real**

Imagina que tienes una fila de recipientes de diferentes alturas. Al juntar dos recipientes, estás buscando la combinación que te permita almacenar la mayor cantidad de agua. Al mover el recipiente más corto hacia el centro, tienes más posibilidades de encontrar recipientes más altos que formen un contenedor más grande.
