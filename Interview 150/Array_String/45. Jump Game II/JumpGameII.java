public class JumpGameII {
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0; // Contador de saltos
        int currentEnd = 0; // Rango actual que podemos alcanzar
        int farthest = 0; // Posición más lejana que podemos alcanzar

        for (int i = 0; i < n - 1; i++) {
            // Actualiza el alcance más lejano
            farthest = Math.max(farthest, i + nums[i]);

            // Si llegamos al final del rango actual
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // Actualizamos el rango
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums1)); // Salida: 2

        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println(jump(nums2)); // Salida: 2
    }
}