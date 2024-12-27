public class FirstOccurrenceKMP {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0)
            return 0; // Si needle está vacío, retornar 0

        // Construir la tabla de prefijos para needle
        int[] lps = buildLPS(needle);

        // Buscar needle en haystack
        int i = 0; // Índice para haystack
        int j = 0; // Índice para needle
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j; // Retornar el índice de la primera coincidencia
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Usar la tabla de prefijos
                } else {
                    i++;
                }
            }
        }
        return -1; // Si no se encuentra needle
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0; // Longitud del prefijo más largo

        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    i--; // Reintentar con un índice menos
                } else {
                    lps[i] = 0; // No hay prefijo más largo
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        FirstOccurrenceKMP solution = new FirstOccurrenceKMP();

        // Ejemplos de prueba
        System.out.println(solution.strStr("sadbutsad", "sad")); // Output: 0
        System.out.println(solution.strStr("leetcode", "leeto")); // Output: -1
    }
}
