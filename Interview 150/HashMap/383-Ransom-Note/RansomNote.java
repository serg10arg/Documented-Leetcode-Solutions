public class RansomNote {
    /**
     * Método para determinar si ransomNote puede construirse usando las letras de
     * magazine.
     *
     * @param ransomNote La cadena que deseamos construir.
     * @param magazine   La cadena que proporciona las letras.
     * @return true si ransomNote puede construirse, false en caso contrario.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Paso 1: Crear un arreglo de frecuencias para las letras de magazine
        int[] freq = new int[26]; // Tamaño 26 porque solo tenemos letras de 'a' a 'z'

        // Recorremos magazine para contar las frecuencias de las letras
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++; // Incrementa el contador correspondiente a la letra
        }

        // Paso 2: Verificar si ransomNote puede construirse con las letras disponibles
        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                // Si no hay suficientes letras, devolvemos false
                return false;
            }
            freq[c - 'a']--; // Usamos una letra de magazine
        }

        // Si hemos podido procesar todas las letras de ransomNote, devolvemos true
        return true;
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        RansomNote solver = new RansomNote();

        // Casos de prueba
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println(solver.canConstruct(ransomNote1, magazine1)); // Output: false

        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println(solver.canConstruct(ransomNote2, magazine2)); // Output: false

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(solver.canConstruct(ransomNote3, magazine3)); // Output: true

        // Caso adicional: ransomNote vacío
        String ransomNote4 = "";
        String magazine4 = "anything";
        System.out.println(solver.canConstruct(ransomNote4, magazine4)); // Output: true

        // Caso adicional: magazine vacío
        String ransomNote5 = "a";
        String magazine5 = "";
        System.out.println(solver.canConstruct(ransomNote5, magazine5)); // Output: false
    }
}
