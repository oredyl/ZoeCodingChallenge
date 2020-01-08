package Processor;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PreProcessorTest {

    @Test
    public void testvalidateNumbers() {
        String zipCode1 = "we334";
        String zipCode2 = "/2345";
        String zipCode3 = "12345";
        PreProcessor preProcessor = new PreProcessor();
        int res1 = preProcessor.validateNumbers(zipCode1);
        int res2 = preProcessor.validateNumbers(zipCode2);
        int res3 = preProcessor.validateNumbers(zipCode3);
        assertEquals(res1, -1);
        assertEquals(res2, -1);
        assertEquals(res3, 12345);
    }

    @Test
    public void testvalidateZipInterval() {
        String[] zipIntervalString1 = new String[2];
        zipIntervalString1[0] = "23423";
        zipIntervalString1[1] = "23523";
        ZipInterval zipInterval1 = new ZipInterval(23423, 23523);
        PreProcessor preProcessor = new PreProcessor();
        ZipInterval res1 = preProcessor.validateZipInterval(zipIntervalString1);
        assertEquals(zipInterval1, res1);

//        String[] zipIntervalString2 = new String[2];
//        zipIntervalString2[0] = "23663";
//        zipIntervalString2[1] = "23523";
//        PreProcessor preProcessor2 = new PreProcessor();
//        preProcessor2.validateZipInterval(zipIntervalString2);
    }

    @Test
    public void testpreProcess() {
        String zipIntervalsString1 = "[94133,94133] [94200,94299] [94600,94699]";
        PreProcessor preProcessor = new PreProcessor();
        List<ZipInterval> res1= preProcessor.preProcess(zipIntervalsString1);
        assertEquals(new ZipInterval(94133, 94133), res1.get(0));
        assertEquals(new ZipInterval(94200, 94299), res1.get(1));
        assertEquals(new ZipInterval(94600, 94699), res1.get(2));
    }
}
