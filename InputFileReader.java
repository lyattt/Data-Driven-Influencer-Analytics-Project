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
import java.util.Scanner;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Reads influencer data from a CSV file.
 * 
 * @author May Vo (akamay219)
 * @version Nov 18, 2025
 */
public class InputFileReader
{
    private SinglyLinkedList<Influencer> influencers;

    /**
     * Creates a reader and immediately loads and parses the specified CSV file.
     * 
     * @param filename
     *            the file to load
     * @throws IOException
     *             if file cannot be opened
     */
    public InputFileReader(String filename)
        throws IOException
    {
        influencers = new SinglyLinkedList<Influencer>();

        Scanner inStream = IOHelper.createScanner(filename);
        inStream.nextLine();

        while (inStream.hasNextLine())
        {

            String line = inStream.nextLine().replaceAll(" ", "");

            if (line.length() == 0)
            {
                // continue
            }
            String[] values = line.split(",");
            if (values.length < 10)
            {
                // continue
            }
            String month = values[0];
            if (!isValidMonth(month))
            {
                // keep going;
            }
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String topic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            MonthlyStats stats = new MonthlyStats(
                month,
                likes,
                posts,
                followers,
                comments,
                views);

            Influencer inf =
                findOrCreateInfluencer(username, channel, country, topic);

            int index = getMonthIndex(month);
            inf.getMonthlyStats()[index] = stats;
        }
    }


    /**
     * Safely converts a string to an integer. Returns 0 if conversion fails.
     *
     * @param str
     *            the string to convert
     * @return integer value or 0 if invalid
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * Retrieves the full list of influencers loaded from the input file.
     *
     * @return the LinkedList containing all Influencer objects
     */
    public LinkedList<Influencer> getInfluencers()
    {
        return influencerList;
    }


    /**
     * @return the full influencer list
     */
    public SinglyLinkedList<Influencer> getInfluencers()
    {
        return influencers;
    }


    /**
     * Finds existing influencer by channel or creates new.
     */
    private Influencer findOrCreateInfluencer(
        String username,
        String channel,
        String country,
        String topic)
    {

        for (Influencer inf : influencers)
        {
            if (inf.getChannelName().equalsIgnoreCase(channel))
            {
                return inf;
            }
        }

        Influencer newInf = new Influencer(
            username,
            channel,
            country,
            topic,
            new MonthlyStats[12]);

        influencers.add(newInf);
        return newInf;
    }


    /**
     * Checks whether a month string is one of the twelve standard calendar
     * months.
     *
     * @param m
     *            the month string
     * @return true if valid, false otherwise
     */
    private boolean isValidMonth(String m)
    {
        return m.equals("January") || m.equals("February") || m.equals("March")
            || m.equals("April") || m.equals("May") || m.equals("June")
            || m.equals("July") || m.equals("August") || m.equals("September")
            || m.equals("October") || m.equals("November")
            || m.equals("December");
    }


    /**
     * get Month index
     */
    private int getMonthIndex(String m)
    {
        switch (m)
        {
            case "January":
                return 0;
            case "February":
                return 1;
            case "March":
                return 2;
            case "April":
                return 3;
            case "May":
                return 4;
            case "June":
                return 5;
            case "July":
                return 6;
            case "August":
                return 7;
            case "September":
                return 8;
            case "October":
                return 9;
            case "November":
                return 10;
            case "December":
                return 11;
            default:
                return -1;
        }
    }

}
