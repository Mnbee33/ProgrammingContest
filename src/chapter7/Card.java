package chapter7;

public class Card {
    String suite;
    int value;
    private static final String SENTINEL = "2000000000";    // sentinel = 番兵


    Card(String suite, String value) {
        this.suite = suite;
        this.value = Integer.valueOf(value);
    }

    static Card sentinel() {
        return new Card("SENTINEL", SENTINEL);
    }

    boolean isLessThan(Card other) {
        return value <= other.value;
    }

    boolean isEqualSuite(Card other) {
        return suite.equals(other.suite);
    }

    @Override
    public String toString() {
        return suite + " " + value;
    }
}
