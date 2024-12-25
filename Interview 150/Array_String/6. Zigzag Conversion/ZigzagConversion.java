public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        // Caso especial: si numRows es 1, no hay zigzag
        if (numRows == 1) {
            return s;
        }

        // Lista para representar las filas
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Construir las filas
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Cambiar dirección si estamos en los extremos
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        // Unir todas las filas
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Ejemplo 1
        System.out.println(convert("PAYPALISHIRING", 3)); // Salida: "PAHNAPLSIIGYIR"

        // Ejemplo 2
        System.out.println(convert("PAYPALISHIRING", 4)); // Salida: "PINALSIGYAHRPI"

        // Ejemplo 3
        System.out.println(convert("A", 1)); // Salida: "A"
    }
}
