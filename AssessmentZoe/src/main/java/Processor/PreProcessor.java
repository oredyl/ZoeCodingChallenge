package Processor;

import java.util.LinkedList;
import java.util.List;

/** Pre-process zip interval strings and transfer them to ZipInterval class */
public class PreProcessor {
//    private String zipIntervals;

    public ZipInterval validateZipInterval(String[] zipIntervalString) {

        /* check if each zip interval has two bounds */
        if (zipIntervalString.length != 2) {
            throw new IllegalArgumentException("Each zip code range should have lower and upper bounds.");
        }

        String startString = zipIntervalString[0];
        String endString = zipIntervalString[1];

        /* check zip code length */
        if (startString.length() != 5 || endString.length() != 5) {
            throw new IllegalArgumentException("Each zip code should have 5 digits.");
        }

        /* check if zip code entered are all numbers */
        int start = validateNumbers(startString);
        int end = validateNumbers(endString);

        if (start != -1 && end != -1) {
            /* check if lower bound is smaller than upper bound*/
            if (start > end) {
                throw new IllegalArgumentException("Lower bound should be smaller than upper bound.");
            }
            ZipInterval zipInterval = new ZipInterval(start, end);
            return zipInterval;
        } else {
            throw new IllegalArgumentException("Zip code should only contain numbers.");
        }
    }

    public int validateNumbers(String zipcode){
        try{
            int zipcodeInt = Integer.parseInt(zipcode);
            return zipcodeInt;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public List<ZipInterval> preProcess(String zipIntervals) {
        String[] zipIntervalsString = zipIntervals.split(" ");
        List<ZipInterval> zipIntervalsList = new LinkedList<ZipInterval>();
        for (int i = 0; i < zipIntervalsString.length; i++) {
            String[] s = zipIntervalsString[i].replaceAll("\\[|\\]", "").split(",");
            zipIntervalsList.add(validateZipInterval(s));
        }
        return zipIntervalsList;
    }


}
