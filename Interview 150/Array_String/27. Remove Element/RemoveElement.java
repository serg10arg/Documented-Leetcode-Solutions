public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Puntero para rastrear la posición de elementos válidos

        // Recorrer el arreglo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Mover elemento válido a la posición k
                k++; // Incrementar el puntero k
            }
        }

        return k; // Retornar el número de elementos válidos
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 }; // Entrada del arreglo
        int val = 3; // Valor a eliminar

        // Llamar a la función
        int k = removeElement(nums, val);

        // Mostrar el resultado
        System.out.println("k = " + k);
        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                System.out.print(nums[i] + (i < k - 1 ? ", " : ""));
            } else {
                System.out.print("_" + (i < nums.length - 1 ? ", " : ""));
            }
        }
        System.out.println("]");
    }
}