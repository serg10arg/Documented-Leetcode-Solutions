import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Último índice de elementos válidos en nums1
        int j = n - 1; // Último índice de nums2
        int k = m + n - 1; // Última posición total en nums1

        // Comparar y colocar elementos desde el final
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copiar elementos restantes de nums2 (si hay)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays solution = new MergeSortedArrays();

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}