package chapter5;

public class Allocation {
    long left = 0;
    long right = 100000 * 10000;

    int[] baggage;
    int numberOfTrucks;

    public Allocation(int[] baggage, int numberOfTrucks) {
        this.baggage = baggage;
        this.numberOfTrucks = numberOfTrucks;
    }

    public long solve() {
        long middle;
        while (isRightBiggerThanLeft()) {
            middle = milddle();
            int value = allocate(middle);
            halve(middle, value);
        }
        return right;
    }

    boolean isRightBiggerThanLeft() {
        return right > left + 1;
    }

    long milddle() {
        return (left + right) / 2;
    }

    int allocate(long maxWeight) {
        int numberOfBaggage = 0;
        for (int j = 0; j < numberOfTrucks; j++) {
            long totalWeight = 0;
            while (canPutBaggageInTruck(maxWeight, baggage[numberOfBaggage], totalWeight)) {
                totalWeight = addBaggage(totalWeight, baggage[numberOfBaggage]);
                numberOfBaggage++;
                if (numberOfBaggage == baggage.length) return baggage.length;
            }
        }
        return numberOfBaggage;
    }

    private boolean canPutBaggageInTruck(long maxWeight, int numberOfBaggage, long totalWeight) {
        return addBaggage(totalWeight, numberOfBaggage) <= maxWeight;
    }

    private long addBaggage(long totalWeight, int baggage) {
        return totalWeight + baggage;
    }

    void halve(long middle, int value) {
        if (value >= baggage.length) {
            right = middle;
        } else {
            left = middle;
        }
    }

}
