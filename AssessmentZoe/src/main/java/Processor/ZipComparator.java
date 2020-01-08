package Processor;

import java.util.Comparator;

/** Comparator */
public class ZipComparator implements Comparator<ZipInterval> {

    @Override
    public int compare(ZipInterval a, ZipInterval b) {
        return a.getStart() < b.getStart() ? -1 : a.getStart() == b.getStart() ? 0 : 1;
    }

}
