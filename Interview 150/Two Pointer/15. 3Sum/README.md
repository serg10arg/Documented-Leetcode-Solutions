### **Comprensión del problema**

- https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150

---

### Objetivo general

Dado un arreglo de números (`nums`), queremos encontrar todas las tripletas `[nums[i], nums[j], nums[k]]` donde la suma sea 0 y no haya duplicados. El resultado será una lista de estas tripletas.

---

### Flujo del programa

1. **Clase y método principal**
   - **`public List<List<Integer>> threeSum(int[] nums)`**:
     Este método es el núcleo del programa. Su trabajo es recibir un arreglo de números y devolver una lista de listas donde cada lista interna es una tripleta que cumple con la condición de sumar cero.

---

2. **Preparativos iniciales**
   ```java
   List<List<Integer>> result = new ArrayList<>();
   if (nums.length < 3)
       return result;
   ```
   - **¿Qué hace aquí?**
     - Crea una lista llamada `result` para almacenar las tripletas que cumplen la condición.
     - Si el arreglo tiene menos de 3 números, ni siquiera puede formar una tripleta, así que devuelve la lista vacía de inmediato.

---

3. **Ordenar el arreglo**
   ```java
   Arrays.sort(nums);
   ```
   - **¿Por qué ordenamos el arreglo?**
     - Ordenar simplifica la búsqueda de tripletas porque podemos usar un enfoque eficiente basado en punteros (veremos esto más adelante).
     - También nos ayuda a evitar duplicados más fácilmente.

---

4. **Iterar sobre el arreglo**
   ```java
   for (int i = 0; i < nums.length - 2; i++) {
       if (i > 0 && nums[i] == nums[i - 1])
           continue; // Saltar duplicados para el primer número
   ```
   - **¿Qué pasa aquí?**
     - Usamos un bucle para elegir cada número como el primer elemento de la tripleta (`nums[i]`).
     - Si el número actual es igual al anterior, lo saltamos para evitar duplicados.

---

5. **Definir los punteros izquierdo y derecho**
   ```java
   int left = i + 1;
   int right = nums.length - 1;
   ```
   - **¿Qué son estos punteros?**
     - `left` apunta al siguiente número después de `nums[i]`.
     - `right` apunta al último número del arreglo.
     - Estos punteros se moverán hacia el centro del arreglo para encontrar combinaciones que sumen cero.

---

6. **Buscar combinaciones con suma cero**
   ```java
   while (left < right) {
       int sum = nums[i] + nums[left] + nums[right];
   ```
   - **¿Qué hace este bucle?**
     - Calcula la suma de los tres números (`nums[i]`, `nums[left]`, `nums[right]`).
     - Compara la suma con 0 para decidir qué hacer a continuación.

---

7. **Encontrar una tripleta válida**
   ```java
   if (sum == 0) {
       result.add(Arrays.asList(nums[i], nums[left], nums[right]));
       left++;
       right--;
   ```
   - **¿Qué pasa si encontramos una suma igual a 0?**
     - Añadimos la tripleta a la lista `result`.
     - Movemos ambos punteros hacia el centro (`left++` y `right--`) para buscar más combinaciones.

---

8. **Evitar duplicados**
   ```java
   while (left < right && nums[left] == nums[left - 1]) left++;
   while (left < right && nums[right] == nums[right + 1]) right--;
   ```
   - **¿Por qué hacemos esto?**
     - Si el número en `left` o `right` es igual al anterior, lo saltamos para evitar añadir la misma tripleta más de una vez.

---

9. **Ajustar los punteros si la suma no es cero**
   ```java
   else if (sum < 0) {
       left++;
   } else {
       right--;
   }
   ```
   - **¿Qué pasa si la suma no es cero?**
     - Si la suma es menor que 0, significa que necesitamos un número más grande, así que movemos el puntero `left` hacia la derecha.
     - Si la suma es mayor que 0, necesitamos un número más pequeño, así que movemos el puntero `right` hacia la izquierda.

---

10. **Devolver el resultado**

```java
return result;
```

- Al final, devolvemos la lista `result`, que contiene todas las tripletas encontradas.

---

### Ejecución del programa (`main`)

```java
int[] nums1 = { -1, 0, 1, 2, -1, -4 };
System.out.println(solution.threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]
```

- Probamos el programa con varios arreglos y vemos los resultados esperados:
  - Para `[-1, 0, 1, 2, -1, -4]`, encuentra las tripletas `[-1, -1, 2]` y `[-1, 0, 1]`.
  - Para `[0, 1, 1]`, no hay combinaciones válidas, así que devuelve `[]`.
  - Para `[0, 0, 0]`, encuentra una única tripleta `[0, 0, 0]`.

---

### Relación con el objetivo general

Cada parte del programa contribuye al propósito principal:

1. **Ordenar y usar punteros** hace que la búsqueda sea más eficiente.
2. **Evitar duplicados** asegura que el resultado no tenga repetidos.
3. **Usar bucles anidados pero controlados** permite explorar todas las combinaciones posibles sin desperdiciar tiempo.

---
