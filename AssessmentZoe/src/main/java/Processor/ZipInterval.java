package Processor;

/** ZipInterval Entity, override equals() to compare the ZipInterval */
public class ZipInterval {

    private int start;
    private int end;

    public ZipInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!ZipInterval.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final ZipInterval interval = (ZipInterval) obj;
        if (this.start != interval.getStart() ) {
            return false;
        }
        if (this.end != interval.getEnd()) {
            return false;
        }
        return true;
    }

}
