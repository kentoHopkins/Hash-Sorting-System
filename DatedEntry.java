/**
 * DatedEntry - class that stores an entry, like a
 * journal entry, with a date, hence the name DatedEntry.
 * 
 * @version Feb 8, 2024
 * @author  Kento Hopkins
 */

public class DatedEntry
{
    private String date;
    private String entry;

    /**
     * Constructor, with two parameters, a date
     * and the entry. The date must be in yyyy/mm/dd
     * format.
     * @param d date for the entry
     * @param e text for the entry
     */
    public DatedEntry(String d, String e)
    {
        date = d;
        entry = e;
    }

    /**
     * Returns the date stored in this object.
     * @return date
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Returns the numeric representation of the month.
     * It should be a value from 1 (Jan) to 12 (Dec)
     * based on the month number stored in the string.
     * A date is always stored as 'yyyy/mm/dd'.
     * 
     * @return month
     */
    public int getMonth()
    {
        int month = Integer.valueOf(date.substring(5,7));
        return month;
    }

    /**
     * Returns the text of this entry.
     * @return text of the entry
     */
    public String getEntry()
    {
        return entry;
    }
}
