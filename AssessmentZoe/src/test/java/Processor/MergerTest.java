package Processor;

import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;


public class MergerTest {

    @Test
    public void testMerge() {
        ZipInterval zipInterval1 = new ZipInterval(94133, 94133);
        ZipInterval zipInterval2 = new ZipInterval(94200, 94299);
        ZipInterval zipInterval3 = new ZipInterval(94600, 94699);
        LinkedList<ZipInterval> inputList= new LinkedList<ZipInterval>();
        inputList.add(zipInterval1);
        inputList.add(zipInterval2);
        inputList.add(zipInterval3);
        Merger merger = new Merger();
        LinkedList<ZipInterval> mergedList = merger.merge(inputList);
        assertEquals(mergedList.get(0), new ZipInterval(94133, 94133));
        assertEquals(mergedList.get(1), new ZipInterval(94200, 94299));
        assertEquals(mergedList.get(2), new ZipInterval(94600, 94699));
    }

    @Test
    public void testMergeUnsorted() {
        ZipInterval zipInterval1 = new ZipInterval(94133, 94133);
        ZipInterval zipInterval2 = new ZipInterval(94200, 94299);
        ZipInterval zipInterval3 = new ZipInterval(94600, 94699);
        LinkedList<ZipInterval> inputList= new LinkedList<ZipInterval>();
        inputList.add(zipInterval3);
        inputList.add(zipInterval2);
        inputList.add(zipInterval1);
        Merger merger = new Merger();
        LinkedList<ZipInterval> mergedList = merger.merge(inputList);
        assertEquals(mergedList.get(0), new ZipInterval(94133, 94133));
        assertEquals(mergedList.get(1), new ZipInterval(94200, 94299));
        assertEquals(mergedList.get(2), new ZipInterval(94600, 94699));
    }

    @Test
    public void testMergeOverlapping() {
        ZipInterval zipInterval1 = new ZipInterval(94133, 94133);
        ZipInterval zipInterval2 = new ZipInterval(94200, 94299);
        ZipInterval zipInterval3 = new ZipInterval(94226, 94399);
        LinkedList<ZipInterval> inputList= new LinkedList<ZipInterval>();
        inputList.add(zipInterval1);
        inputList.add(zipInterval2);
        inputList.add(zipInterval3);
        Merger merger = new Merger();
        LinkedList<ZipInterval> mergedList = merger.merge(inputList);
        assertEquals(mergedList.get(0), new ZipInterval(94133, 94133));
        assertEquals(mergedList.get(1), new ZipInterval(94200, 94399));
    }

    @Test
    public void testMergeOverlappingUnsorted() {
        ZipInterval zipInterval1 = new ZipInterval(94133, 94133);
        ZipInterval zipInterval2 = new ZipInterval(94200, 94299);
        ZipInterval zipInterval3 = new ZipInterval(94226, 94399);
        LinkedList<ZipInterval> inputList= new LinkedList<ZipInterval>();
        inputList.add(zipInterval2);
        inputList.add(zipInterval3);
        inputList.add(zipInterval1);
        Merger merger = new Merger();
        LinkedList<ZipInterval> mergedList = merger.merge(inputList);
        assertEquals(mergedList.get(0), new ZipInterval(94133, 94133));
        assertEquals(mergedList.get(1), new ZipInterval(94200, 94399));
    }

}
