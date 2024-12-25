public class ReverseWords {
    public static String reverseWords(String s) {
        // Paso 1: Eliminar espacios extra
        String trimmed = s.trim(); // Eliminar espacios iniciales y finales
        String[] words = trimmed.split("\\s+"); // Dividir por uno o más espacios

        // Paso 2: Invertir el orden de las palabras
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" "); // Añadir un espacio entre palabras
            }
        }

        // Paso 3: Convertir a cadena y devolver
        return reversed.toString();
    }

    // Método principal para probar
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(reverseWords("  hello world  ")); // Output: "world hello"
        System.out.println(reverseWords("a good   example")); // Output: "example good a"
    }
}
