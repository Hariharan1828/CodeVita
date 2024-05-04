import java.util.*;


public class JugsAndCups {
    private static final int MAX_CUPS = 10;
    private static final int MAX_JUG_CAPACITY = 100;
    private static final int MIN_CUP_CAPACITY = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCups = scanner.nextInt();
        int[] cupCapacities = new int[numCups];
        for (int i = 0; i < numCups; i++) {
            cupCapacities[i] = scanner.nextInt();
        }

        int jugCapacity = scanner.nextInt();

        List<Integer> usedCups = new ArrayList<>();
        List<Integer> frequencies = new ArrayList<>();

        fillJug(cupCapacities, jugCapacity, usedCups, frequencies);

        printSolution(usedCups, frequencies);
    }

    private static void fillJug(int[] cupCapacities, int jugCapacity, List<Integer> usedCups, List<Integer> frequencies) {
        // Sort the cup capacities in ascending order
        Arrays.sort(cupCapacities);

        // Create a hash map to track the remaining jug capacity
        Map<Integer, Integer> remainingCapacityMap = new HashMap<>();
        for (int capacity : cupCapacities) {
            remainingCapacityMap.put(capacity, jugCapacity);
        }

        // Initialize the used cups and frequencies lists
        for (int capacity : cupCapacities) {
            usedCups.add(capacity);
            frequencies.add(0);
        }

        // Fill the jug using the cups
        while (jugCapacity > 0) {
            // Find the cup with the maximum remaining capacity
            int maxRemainingCapacity = 0;
            int maxRemainingCapacityCup = -1;
            for (int i = 0; i < cupCapacities.length; i++) {
                int remainingCapacity = remainingCapacityMap.get(cupCapacities[i]);
                if (remainingCapacity > maxRemainingCapacity && remainingCapacity <= jugCapacity) {
                    maxRemainingCapacity = remainingCapacity;
                    maxRemainingCapacityCup = i;
                }
            }

            // If no cup can be used, stop filling the jug
            if (maxRemainingCapacityCup == -1) {
                break;
            }

            // Use the cup with the maximum remaining capacity
            int cupCapacity = cupCapacities[maxRemainingCapacityCup];
            int frequency = remainingCapacityMap.get(cupCapacity) / cupCapacity;
            jugCapacity -= frequency * cupCapacity;
            remainingCapacityMap.put(cupCapacity, remainingCapacityMap.get(cupCapacity) % cupCapacity);
            frequencies.set(maxRemainingCapacityCup, frequency);
        }
    }

    private static void printSolution(List<Integer> usedCups, List<Integer> frequencies) {
        // Print the used cups in ascending order
        for (int cup : usedCups) {
            System.out.print(cup + " ");
        }
        System.out.println();

        // Print the frequencies of the used cups
        for (int frequency : frequencies) {
            System.out.print(frequency + " ");
        }
        System.out.println();
    }
}
