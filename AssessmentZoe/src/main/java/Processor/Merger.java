package Processor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** Main logic to merge intervals and return merged list */
public class Merger {

    /* The merge() function will change the original zip intervals */
    public LinkedList<ZipInterval> merge(List<ZipInterval> intervals) {
        Collections.sort(intervals, new ZipComparator());
        LinkedList<ZipInterval> mergedIntervals = new LinkedList<ZipInterval>();
        for (ZipInterval interval : intervals) {
            if (mergedIntervals.isEmpty() || interval.getStart() > mergedIntervals.getLast().getEnd()) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.getLast().setEnd(Math.max(interval.getEnd(), mergedIntervals.getLast().getEnd()));
            }
        }
        return mergedIntervals;
    }

}
