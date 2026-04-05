// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- May Vo (akamay219)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import java.io.IOException;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * Drives the execution of Project 5. The main method loads the input file,
 * retrieves all influencers, and prints the required console output for the
 * intermediate submission.
 * 
 * @author May Vo (akamay219)
 * @version Nov 18, 2025
 */
public class ProjectRunner
{
    /**
     * * Entry point for the program. Reads the input file (either provided via
     * command-line arguments or falling back to a default) and prints the Q1
     * engagement rate summaries to the console.
     *
     * @param args
     *            optional array whose first element is an input filename
     * @throws IOException
     *             if the input file cannot be opened
     */
    public static void main(String[] args)
        throws IOException
    {
        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        boolean showConsole = true;
        boolean showGUI = false;

        if (showConsole)
        {
            list.insertionSort(new ChannelNameComparator());

            for (Influencer inf : list)
            {
                System.out.println(inf.getChannelName());
                System.out.println(
                    "traditional: "
                        + fmt.format(inf.getTraditionalEngagementRateQ1()));
                System.out.println("==========");
            }

            System.out.println("**********");
            System.out.println("**********");

            list.insertionSort(new EngagementComparator(true));

            for (Influencer inf : list)
            {
                System.out.println(inf.getChannelName());

                if (inf.getTotalViewsQ1() == 0)
                {
                    System.out.println("reach: N/A");
                }
                else
                {
                    System.out.println(
                        "reach: " + fmt.format(inf.getReachEngagementRateQ1()));
                }

                System.out.println("==========");
            }
        }
        if (showGUI)
        {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }
    }
}
