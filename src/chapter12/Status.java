package chapter12;

public class Status {
    int id;
    int firstVisit;
    int lastVisit;
    int distance;
    VisitStatus status;

    static final int MAX_DISTANCE = Integer.MAX_VALUE;

    enum VisitStatus {
        NOT_YET,
        VISITING,
        VISITED


    }
    Status(int id) {
        this.id = id;
        status = VisitStatus.NOT_YET;
        distance = MAX_DISTANCE;
    }

    static Status[] getArray(int size) {
        Status[] visitResults = new Status[size];
        for (int u = 0; u < size; u++) {
            visitResults[u] = new Status(u + 1);
        }
        return visitResults;
    }
    void setFirstVisit(int time) {
        status = VisitStatus.VISITING;
        firstVisit = time;
    }

    void setLastVisit(int time) {
        status = VisitStatus.VISITED;
        lastVisit = time;
    }

    boolean isVisitedNotYet() {
        return status.equals(VisitStatus.NOT_YET);
    }

    boolean isAnyDistance() {
        return distance != MAX_DISTANCE;
    }

    String depthAndStatus() {
        return String.format("%d %d %d", id, firstVisit, lastVisit);
    }

    String distance() {
        return String.format("%d %d", id, distance == MAX_DISTANCE ? -1 : distance);
    }
}
