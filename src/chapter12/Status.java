package chapter12;

public class Status {
    int id;
    int firstVisit;
    int lastVisit;
    VisitStatus status;

    enum VisitStatus {
        NOT_YET,
        VISITING,
        VISITED
    }

    Status(int id) {
        this.id = id;
        status = VisitStatus.NOT_YET;
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

    @Override
    public String toString() {
        return String.format("%d %d %d", id, firstVisit, lastVisit);
    }
}
