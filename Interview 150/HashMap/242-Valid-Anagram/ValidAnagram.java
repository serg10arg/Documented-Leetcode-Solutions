import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // Paso 1: Verifica si las longitudes son diferentes
        if (s.length() != t.length()) {
            return false;
        }

        // Paso 2: Crea un arreglo para contar las frecuencias
        int[] count = new int[26];

        // Paso 3: Actualiza las frecuencias
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Paso 4: Verifica si todas las frecuencias son cero
        for (int freq : count) {
            if (freq != 0) {
                return false;
            }
        }

        // Paso 5: Retorna true si son anagramas
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false
    }
}
