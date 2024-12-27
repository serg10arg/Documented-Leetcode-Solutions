public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++; // Avanza el puntero de s si encontramos un carácter coincidente
            }
            tPointer++; // Siempre avanza en t
        }

        return sPointer == s.length(); // Si hemos recorrido todo s, es subsecuencia
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc")); // true
        System.out.println(isSubsequence("abc", "")); // false
    }

}
