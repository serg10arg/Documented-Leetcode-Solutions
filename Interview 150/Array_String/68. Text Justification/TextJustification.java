import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // lista para guardar las lineas
        int index = 0; // Indice para recorrer las palabras

        while (index < words.length) { // Procesar cada linea
            int lineStart = index; // Indice de la primera palabra de la linea
            int lineLength = 0; // Longitud de la linea

            // Pack words greedily
            while (index < words.length && lineLength + words[index].length() + (index - lineStart) <= maxWidth) { // Mientras
                                                                                                                   // quepa
                                                                                                                   // la
                                                                                                                   // palabra
                                                                                                                   // en
                                                                                                                   // la
                                                                                                                   // linea
                lineLength += words[index].length(); // Sumar la longitud de la palabra
                index++;
            }

            int spaceSlots = index - lineStart - 1; // Number of gaps between words
            StringBuilder line = new StringBuilder();

            // If it's the last line or there's only one word, left-justify
            if (index == words.length || spaceSlots == 0) { //
                for (int i = lineStart; i < index; i++) {
                    line.append(words[i]);
                    if (i < index - 1)
                        line.append(" ");
                }
                while (line.length() < maxWidth)
                    line.append(" ");
            } else {
                // Fully justify
                int totalSpaces = maxWidth - lineLength; // total de espacios a distribuir
                int spacesPerSlot = totalSpaces / spaceSlots; // espacios por cada espacio entre palabras
                int extraSpaces = totalSpaces % spaceSlots; // espacios extras para distribuir

                for (int i = lineStart; i < index; i++) {
                    line.append(words[i]);
                    if (i < index - 1) {
                        for (int j = 0; j < spacesPerSlot; j++)
                            line.append(" ");
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth1 = 16;
        System.out.println(fullJustify(words1, maxWidth1));

        String[] words2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
        int maxWidth2 = 16;
        System.out.println(fullJustify(words2, maxWidth2));

        String[] words3 = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else", "we", "do" };
        int maxWidth3 = 20;
        System.out.println(fullJustify(words3, maxWidth3));
    }
}
