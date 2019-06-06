package chapter4;

public class MyNode {
    String key;
    public MyNode next;
    public MyNode prev;

    MyNode(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
