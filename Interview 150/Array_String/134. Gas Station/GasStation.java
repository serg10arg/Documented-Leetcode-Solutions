public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // Si el tanque es negativo, reiniciar desde la siguiente estación
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // Verificar si el recorrido es posible
        return (totalGas >= totalCost) ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas1 = { 1, 2, 3, 4, 5 };
        int[] cost1 = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas1, cost1)); // Output: 3

        int[] gas2 = { 2, 3, 4 };
        int[] cost2 = { 3, 4, 3 };
        System.out.println(canCompleteCircuit(gas2, cost2)); // Output: -1
    }
}
