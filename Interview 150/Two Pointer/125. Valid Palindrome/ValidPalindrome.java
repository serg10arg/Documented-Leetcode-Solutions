public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Mover puntero izquierdo hasta encontrar carácter alfanumérico
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Mover puntero derecho hasta encontrar carácter alfanumérico
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Comparar caracteres ignorando mayúsculas/minúsculas
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true
    }
}
