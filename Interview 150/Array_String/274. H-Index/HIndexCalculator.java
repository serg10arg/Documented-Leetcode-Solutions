import java.util.Arrays;

public class HIndexCalculator {
    public static int hIndex(int[] citations) {
        // Ordenar el arreglo
        Arrays.sort(citations);

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i; // Posibles artículos con al menos h citas
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0; // Si no se encuentra un valor h válido
    }

    public static void main(String[] args) {
        int[] citations1 = { 3, 0, 6, 1, 5 };
        System.out.println("H-Index: " + hIndex(citations1)); // Output: 3

        int[] citations2 = { 1, 3, 1 };
        System.out.println("H-Index: " + hIndex(citations2)); // Output: 1
    }
}
