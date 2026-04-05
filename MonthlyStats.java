package prj5;

// -------------------------------------------------------------------------
/**
 * This class contains the monthly stats for an influencer for one month
 * 
 * @author nikkykuninti
 * @version Nov 19, 2025
 */
public class MonthlyStats
{
    private String month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ----------------------------------------------------------
    /**
     * Create a new MonthlyStats object.
     * 
     * @param month
     *            month
     * @param likes
     *            number of likes
     * @param posts
     *            number of posts
     * @param followers
     *            number of followers
     * @param comments
     *            number of comments
     * @param views
     *            number of views
     */
    public MonthlyStats(
        String month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views)
    {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    // ----------------------------------------------------------
    /**
     * gets the month
     * 
     * @return String
     */
    public String getMonth()
    {
        return month;
    }


    // ----------------------------------------------------------
    /**
     * gets the number of likes
     * 
     * @return int
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * gets the number of posts
     * 
     * @return int
     */
    public int getPosts()
    {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * gets the number of followers
     * 
     * @return int
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * gets the number of comments
     * 
     * @return int
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * gets the number of views
     * 
     * @return int
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * calculates the traditional engagement rate
     * 
     * @return double
     */
    public double getTraditionalEngagementRate()
    {

        return ((comments + likes) / (double)followers) * 100.0;
    }


    // ----------------------------------------------------------
    /**
     * calculates the reach engagement rate
     * 
     * @return double
     */
    public double getReachEngagementRate()
    {

        return ((comments + likes) / (double)views) * 100.0;
    }

}
