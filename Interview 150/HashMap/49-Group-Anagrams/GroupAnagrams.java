import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Mapa para agrupar palabras basadas en su clave canónica
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Clave canónica: ordenar las letras de la palabra
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Agregar la palabra al grupo correspondiente
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Devolver los valores del mapa como lista de grupos
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        // Ejemplo 1
        String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs1));

        // Ejemplo 2
        String[] strs2 = { "" };
        System.out.println(groupAnagrams(strs2));

        // Ejemplo 3
        String[] strs3 = { "a" };
        System.out.println(groupAnagrams(strs3));
    }
}
