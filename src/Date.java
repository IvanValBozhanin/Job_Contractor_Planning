import java.util.Objects;
import java.util.Scanner;

public class Date implements Comparable<Date>{
    private int day;
    private int month;
    private int year;

    /**
     * Constructor of the Date object
     * @param day - the day of the date
     * @param month - the month of the date
     * @param year - the year of the date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    /**
     * Constructor of the Date object from a string to read
     * @param nextLine - the line with info
     */
    public Date(String nextLine) {
        Scanner in = new Scanner(nextLine);
        in.useDelimiter("-");
        this.day = in.nextInt();
        this.month = in.nextInt();
        this.year = in.nextInt();
    }

    /**
     * Method for scanning the date from a line of text
     * @param in - the string to be scanned
     * @return a new date with info from the field
     */
    public Date (Scanner in) {
        in.useDelimiter("-");
        System.out.print("Day: ");
        this.day = Integer.parseInt(in.next());
        System.out.print("Month: ");
        this.month = Integer.parseInt(in.next());
        System.out.print("Year: ");
        this.year = Integer.parseInt(in.next());
    }

    /**
     * Equals method of Date
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    /**
     * Hashcode method of the Date object
     * @return integer of the hascode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    /**
     * ToString method of Date
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    /**
     * Getter of the day field
     * @return the day of the date
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter of the month field
     * @return the month of the date
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter of the year field
     * @return the year of the date
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter of the day field
     * @param day - the new day to be set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Setter of the month field
     * @param month  - the new day to be set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Setter of the year field
     * @param year - the new day to be set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * CompareTo method for Date class
     * @param o the object to be compared.
     * @return integer of the comparing result
     */
    @Override
    public int compareTo(Date o) {
        if(this.year != o.year){
            return Integer.compare(this.year, o.year);
        } else if (this.month != o.month) {
            return Integer.compare(this.month, o.month);
        }
        return Integer.compare(this.day, o.day);
    }
}
