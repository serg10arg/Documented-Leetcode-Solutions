public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Eliminar espacios al principio y al final
        s = s.trim();
        // Dividir la cadena en palabras
        String[] words = s.split(" ");
        // Retornar la longitud de la ultima palabra
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello Wolrd"));
        System.out.println(lengthOfLastWord("  fly me  to  the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}