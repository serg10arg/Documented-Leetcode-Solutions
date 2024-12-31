import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // Dividir s en palabras

        if (pattern.length() != words.length) {
            return false; // Tamaños diferentes, no puede haber mapeo
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Verificar mapeo de letra a palabra
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Conflicto en el mapeo
                }
            } else {
                charToWord.put(c, word); // Registrar nuevo mapeo
            }

            // Verificar mapeo de palabra a letra
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Conflicto en el mapeo
                }
            } else {
                wordToChar.put(word, c); // Registrar nuevo mapeo
            }
        }

        return true; // Mapeo exitoso
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
    }
}
