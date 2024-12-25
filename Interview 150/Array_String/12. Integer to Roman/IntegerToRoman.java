public class IntegerToRoman {
    public static String intToRoman(int num) {
        // Paso 1: Crear la tabla de correspondencia
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // Paso 2: Construir el resultado
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i]; // resta el valor actual para
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        // Ejemplo de prueba
        System.out.println(intToRoman(1994)); // MCMXCIV
        System.out.println(intToRoman(3749)); // MMMDCCXLIX
        System.out.println(intToRoman(58)); // LVIII
    }
}
