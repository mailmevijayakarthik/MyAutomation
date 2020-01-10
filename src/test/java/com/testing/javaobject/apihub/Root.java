package com.testing.javaobject.apihub;

public class Root {
    private Stores[] stores;

    public Stores[] getStores ()
    {
        return stores;
    }

    public void setStores (Stores[] stores)
    {
        this.stores = stores;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stores = "+stores+"]";
    }
}
