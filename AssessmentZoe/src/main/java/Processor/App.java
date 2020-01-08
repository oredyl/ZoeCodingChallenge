package Processor;

import java.util.List;
import java.util.Scanner;

/** Main entrance to read the data, merge the intervals, and print the result. */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        String zipcodeString = scan.nextLine();
        PreProcessor preProcessor = new PreProcessor();
        List<ZipInterval> zipcodeList = preProcessor.preProcess(zipcodeString);
        Merger merger = new Merger();
        List<ZipInterval> mergedZipcodeList = merger.merge(zipcodeList);
        for (ZipInterval zipInterval : mergedZipcodeList) {
            System.out.println("[" + zipInterval.getStart() + "," + zipInterval.getEnd() + "]");
        }
    }
}
