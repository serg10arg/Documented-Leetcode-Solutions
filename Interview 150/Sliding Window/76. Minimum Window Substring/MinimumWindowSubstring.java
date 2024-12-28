import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        // Mapa de frecuencias para los caracteres de t
        HashMap<Character, Integer> charCountT = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
        }

        // Variables para la ventana deslizante
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
        int required = charCountT.size(); // Número de caracteres únicos en t
        int formed = 0; // Número de caracteres únicos satisfechos en la ventana actual

        HashMap<Character, Integer> windowCounts = new HashMap<>();

        // Expandir la ventana
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Si el carácter actual satisface la frecuencia requerida
            if (charCountT.containsKey(c) && windowCounts.get(c).intValue() == charCountT.get(c).intValue()) {
                formed++;
            }

            // Contraer la ventana
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Actualiza el resultado
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Eliminar el carácter izquierdo
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (charCountT.containsKey(leftChar)
                        && windowCounts.get(leftChar).intValue() < charCountT.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(solution.minWindow("a", "a")); // Output: "a"
        System.out.println(solution.minWindow("a", "aa")); // Output: ""
    }
}
