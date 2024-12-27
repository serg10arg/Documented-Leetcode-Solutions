public class ContainerWithMostWater {
    // Método principal para calcular el área máxima de agua que puede contener el
    // contenedor
    public static int maxArea(int[] height) {
        int maxArea = 0; // Para almacenar el área máxima encontrada
        int left = 0; // Puntero izquierdo
        int right = height.length - 1; // Puntero derecho

        // Iterar mientras los punteros no se crucen
        while (left < right) {
            // Calcula el área actual usando las líneas en las posiciones left y right
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Actualiza el área máxima si el área actual es mayor
            maxArea = Math.max(maxArea, currentArea);

            // Mueve el puntero que apunta a la línea más corta
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea; // Devuelve el área máxima
    }

    public static void main(String[] args) {
        // Ejemplo 1: Caso dado en el problema
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Máxima área para height1: " + maxArea(height1)); // Salida esperada: 49

        // Ejemplo 2: Caso con dos líneas de igual altura
        int[] height2 = { 1, 1 };
        System.out.println("Máxima área para height2: " + maxArea(height2)); // Salida esperada: 1

        // Ejemplo 3: Caso con valores ascendentes y descendentes
        int[] height3 = { 4, 3, 2, 1, 4 };
        System.out.println("Máxima área para height3: " + maxArea(height3)); // Salida esperada: 16

        // Ejemplo 4: Caso con valores pequeños
        int[] height4 = { 1, 2, 1 };
        System.out.println("Máxima área para height4: " + maxArea(height4)); // Salida esperada: 2
    }
}
