import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;

        Arrays.sort(nums); // Ordenar el arreglo

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Saltar duplicados para el primer número

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Saltar duplicados para el segundo y tercer número
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < 0) {
                    left++; // Incrementar el puntero izquierdo si la suma es menor que 0
                } else {
                    right--; // Decrementar el puntero derecho si la suma es mayor que 0
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solution.threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = { 0, 1, 1 };
        System.out.println(solution.threeSum(nums2)); // []

        int[] nums3 = { 0, 0, 0 };
        System.out.println(solution.threeSum(nums3)); // [[0, 0, 0]]
    }

}
