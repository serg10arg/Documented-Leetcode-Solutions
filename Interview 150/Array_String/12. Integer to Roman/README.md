    # Conversión de Enteros a Números Romanos: Un Enfoque Greedy (https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150)

    Este documento describe el proceso de convertir un número entero a su representación en números romanos, utilizando un enfoque "greedy" (avaricioso).

    ## 1. Entender la naturaleza del problema

    La tarea es convertir un entero (como 1994) en un número romano (como MCMXCIV).

    Sabemos que los números romanos no funcionan como un sistema posicional (como el decimal), sino que se construyen sumando y restando valores asociados a símbolos.

    Esto sugiere que el problema puede ser descompuesto en pasos simples: encontrar el mayor valor romano que encaja, restarlo, y repetir hasta que no quede nada.

    **Primera pista:** los números romanos son aditivos/sustractivos

    Esto me da una intuición: si podemos manejar el número pieza por pieza, es más sencillo. Así que inmediatamente pienso en descomponer el número en partes manejables.

    ## 2. Observación de patrones en los números romanos

    Los números romanos tienen una estructura basada en símbolos y valores:

    - Cada símbolo tiene un valor fijo: I = 1, V = 5, X = 10, etc.
    - Algunos símbolos combinados representan valores especiales por sustracción: IV = 4, IX = 9, etc.
    - La representación siempre usa el menor número de símbolos posible, siguiendo un orden descendente de valores.

**Segunda pista:** orden descendente de valores

Si trabajamos de mayor a menor, podemos construir la representación pieza por pieza. Esto implica que puedo "restar" el valor más grande posible en cada paso y luego moverme al siguiente.

## 3. Simplicidad del enfoque greedy (avaricioso)

En problemas de este tipo, un enfoque "greedy" suele ser natural. El enfoque greedy funciona así:

- En cada paso, selecciona la opción óptima localmente (el valor romano más grande que cabe en el número actual).
- Repite este proceso hasta que el problema esté resuelto.

En este caso:

- Toma el mayor valor posible (1000 → M).
- Resta este valor del número.
- Continúa con el siguiente mayor valor.

Este enfoque funciona porque:

- Los números romanos son intrínsecamente descompuestos en valores.
- El orden descendente asegura que no necesitamos retroceder ni reconsiderar pasos previos.

**Tercera pista:** greedy y valores únicos

Esto me dice que el enfoque de resta sucesiva es correcto porque:

- El valor romano más grande siempre es el mejor candidato.
- Cada resta reduce el problema a un subproblema más pequeño del mismo tipo.

## 4. Validación del enfoque

Antes de confirmar el enfoque de resta sucesiva, hago estas comprobaciones mentales:

- ¿Funciona para casos límites? Por ejemplo: 4 → IV o 3999 → MMMCMXCIX.
- ¿Es eficiente? Con números romanos, solo hay 13 símbolos o combinaciones, así que iterar sobre ellos es eficiente.
- ¿Es claro y fácil de implementar? Resta sucesiva es un concepto simple y fácil de traducir en código.

Cuando todas estas respuestas son afirmativas, sé que este enfoque es el más adecuado.
