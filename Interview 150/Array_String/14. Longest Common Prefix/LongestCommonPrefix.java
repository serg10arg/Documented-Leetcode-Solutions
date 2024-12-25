public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0]; // Tomar la primera cadena como referencia.
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // mientras la cadena actual
                prefix = prefix.substring(0, prefix.length() - 1); // Reducir el prefijo.
                if (prefix.isEmpty()) {
                    return ""; // No hay prefijo común.
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] input1 = { "flower", "flow", "flight" };
        System.out.println("Output: " + longestCommonPrefix(input1)); // Output: "fl"

        String[] input2 = { "dog", "racecar", "car" };
        System.out.println("Output: " + longestCommonPrefix(input2)); // Output: ""
    }
}
