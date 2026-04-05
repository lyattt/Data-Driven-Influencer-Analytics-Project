package prj5;

// -------------------------------------------------------------------------
/**
 * This class creates an influencer with an username, channel name, country,
 * main topic, and monthly stats.
 * 
 * @author nikkykuninti
 * @version Nov 19, 2025
 */
public class Influencer
    implements Comparable<Influencer>
{
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private MonthlyStats[] monthlyStats;

    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param username
     *            influencer's username
     * @param channelName
     *            channel name
     * @param country
     *            country of influencer
     * @param mainTopic
     *            main topic of their channel
     * @param monthlyStats
     *            their monthly stats
     */
    public Influencer(
        String username,
        String channelName,
        String country,
        String mainTopic,
        MonthlyStats[] monthlyStats)
    {

        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.monthlyStats = monthlyStats;
    }


    // ----------------------------------------------------------
    /**
     * gets the username
     * 
     * @return String
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * gets the channel name
     * 
     * @return String
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * gets the country
     * 
     * @return String
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * gets the main topic
     * 
     * @return String
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * gets the monthly stats array
     * 
     * @return MonthlyStats[]
     */
    public MonthlyStats[] getMonthlyStats()
    {
        return monthlyStats;
    }


    private MonthlyStats getMonthlyStats(String month)
    {
        for (MonthlyStats ms : monthlyStats)
        {
            if (ms != null && ms.getMonth().equals(month))
            {
                return ms;
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * gets the traditional engagement rate for Q1
     * 
     * @return double
     */
    public double getTraditionalEngagementRateQ1()
    {
        return (getMonthlyStats("January").getTraditionalEngagementRate()
            + getMonthlyStats("February").getTraditionalEngagementRate()
            + getMonthlyStats("March").getTraditionalEngagementRate()) / 3.0;
    }


    // ----------------------------------------------------------
    /**
     * gets the reach engagement rate for Q1
     * 
     * @return double
     */
    public double getReachEngagementRateQ1()
    {
        return (getMonthlyStats("January").getReachEngagementRate()
            + getMonthlyStats("February").getReachEngagementRate()
            + getMonthlyStats("March").getReachEngagementRate()) / 3.0;
    }


    @Override
    public int compareTo(Influencer other)
    {
        return this.channelName.compareTo(other.channelName);
    }

}
