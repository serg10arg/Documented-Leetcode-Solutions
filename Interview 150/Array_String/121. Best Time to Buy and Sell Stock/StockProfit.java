public class StockProfit {

    public int maxProfit(int[] prices) {
        // Verificamos si el array está vacío o tiene solo un elemento
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Inicializamos el precio mínimo como el primer precio en el array
        int minPrice = prices[0];
        // Inicializamos el beneficio máximo como 0
        int maxProfit = 0;

        // Iteramos desde el segundo día hasta el último
        for (int i = 1; i < prices.length; i++) {
            // Si encontramos un precio más bajo, actualizamos minPrice
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculamos el beneficio si vendemos hoy
            int profit = prices[i] - minPrice;
            // Actualizamos el beneficio máximo
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        StockProfit sp = new StockProfit();
        // Ejemplo 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println(sp.maxProfit(prices1)); // Salida: 5

        // Ejemplo 2
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println(sp.maxProfit(prices2)); // Salida: 0
    }
}
