package com.testing.javaobject.timeslots;

import java.util.List;

public class Root {
	 private String ok;

	    private Items[] items;

	    public String getOk ()
	    {
	        return ok;
	    }

	    public void setOk (String ok)
	    {
	        this.ok = ok;
	    }

	    public Items[] getItems ()
	    {
	        return items;
	    }

	    public void setItems (Items[] items)
	    {
	        this.items = items;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [ok = "+ok+", items = "+items+"]";
	    }
}
