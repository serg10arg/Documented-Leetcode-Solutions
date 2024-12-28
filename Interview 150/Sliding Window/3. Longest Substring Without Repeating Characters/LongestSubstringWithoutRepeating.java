import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0; // Caso base
        }

        HashSet<Character> seen = new HashSet<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            // Si el carácter ya está en el conjunto, mover el puntero `start`
            while (seen.contains(current)) {
                seen.remove(s.charAt(start));
                start++;
            }

            // Agregar el carácter actual al conjunto
            seen.add(current);

            // Actualizar la longitud máxima
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1)); // Salida: 3
        System.out.println(lengthOfLongestSubstring(s2)); // Salida: 1
        System.out.println(lengthOfLongestSubstring(s3)); // Salida: 3
    }
}
