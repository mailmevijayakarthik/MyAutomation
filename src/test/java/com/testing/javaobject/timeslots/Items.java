package com.testing.javaobject.timeslots;

public class Items {
	private String date;

    private Timeslot timeslot;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public Timeslot getTimeslot ()
    {
        return timeslot;
    }

    public void setTimeslot (Timeslot timeslot)
    {
        this.timeslot = timeslot;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", timeslot = "+timeslot+"]";
    }
}
