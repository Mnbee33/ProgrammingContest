package chapter11;

public class FibonacciNumber {
    int[] fibonacci;

    FibonacciNumber() {
        fibonacci = new int[45];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
    }

    int get(int n) {
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }
}
