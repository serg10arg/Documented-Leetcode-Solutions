public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // Inicializa el alcance máximo
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // Si no puedes alcanzar la posición actual, retorna false
                return false;
            }
            // Actualiza el alcance máximo
            maxReach = Math.max(maxReach, i + nums[i]);
            // Si alcanzas o superas el último índice, retorna true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false; // Si terminas el recorrido y no alcanzaste el último índice
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println(canJump(nums1)); // Output: true
        System.out.println(canJump(nums2)); // Output: false
    }
}