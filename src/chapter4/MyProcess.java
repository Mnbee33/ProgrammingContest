package chapter4;

public class MyProcess {
    String name;
    int time;
    int endtime;

    public MyProcess(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " " + endtime;
    }
}
