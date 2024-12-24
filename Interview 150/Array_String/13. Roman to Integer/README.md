## **1. Comprensión del problema** (https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150)

### **Desglose del problema**

1. **Entrada**: Una cadena `s` que representa un número romano. La longitud está entre 1 y 15 caracteres, y contiene solo los símbolos válidos: `I, V, X, L, C, D, M`.
2. **Salida**: Un entero que es el valor equivalente al número romano.
3. **Reglas**:
   - Los valores se suman si los símbolos están en orden descendente.
   - Se restan si un símbolo más pequeño precede a uno más grande (e.g., `IV` = 4, `IX` = 9).
   - Los números están garantizados para estar en el rango `[1, 3999]`.

### **Preguntas clave**

1. ¿Queremos una solución con un enfoque iterativo o recursivo?
2. ¿La solución debe manejar solo cadenas válidas (como se indica en las restricciones)?
3. ¿Es necesario optimizar la solución para escenarios más generales (e.g., validaciones)?

## **2. Planificación**

### **Algoritmo sugerido: `HashMap`**

1. Usar un mapa para asociar cada símbolo romano con su valor (`Map<Character, Integer>`).
2. Iterar por la cadena de entrada:
   - Si el valor actual es menor que el siguiente, restar este valor del total.
   - Si no, sumarlo.
3. Retornar el total acumulado.

### **Plan paso a paso**

1. Crear un mapa de valores para los símbolos romanos.
2. Inicializar un acumulador `total` para la suma final.
3. Recorrer la cadena de entrada, comparando el valor del símbolo actual con el siguiente:
   - Si el símbolo actual es menor que el siguiente, restar su valor.
   - En caso contrario, sumarlo.
4. Devolver el total acumulado.

### **Inspiración de problemas similares**

Este enfoque es análogo al cálculo de valores en sistemas posicionales, donde los valores se ajustan según su posición relativa.

## **7. Revisión y verificación**

### **Validación**

- **Casos simples**:
  - Entrada: `"III"` → Salida esperada: `3`.
  - Entrada: `"IV"` → Salida esperada: `4`.
- **Casos complejos**:
  - Entrada: `"MCMXCIV"` → Salida esperada: `1994`.
  - Entrada: `"MMXXIV"` → Salida esperada: `2024`.

### **Eficiencia**

- Complejidad temporal: O(n), donde n es la longitud de la cadena.
- Complejidad espacial: O(1), el mapa tiene un tamaño fijo.

### **Mejoras potenciales**

- Validar la entrada para asegurar que contiene solo símbolos romanos válidos.
- Usar un arreglo en lugar de un mapa para ahorrar espacio.
