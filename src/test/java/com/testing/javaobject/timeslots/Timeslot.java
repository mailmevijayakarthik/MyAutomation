package com.testing.javaobject.timeslots;

import java.util.List;

public class Timeslot
{
    private String allow_alcohol;

    private String store_id;

    private String shop_price;

    private String lead_time_cutoff_rule_id;

    private String shop_fee_plu;

    private String[] postal_codes;

    private String cutoff_delta;

    private String from_time;

    private String capacity;

    private String delivery_fee_plu;

    private String fulfillment_type;

    private String plu_rule_id;

    private String id;

    private String to_time;

    private String day_of_week;

    private String delivery_price;

    public String getAllow_alcohol ()
    {
        return allow_alcohol;
    }

    public void setAllow_alcohol (String allow_alcohol)
    {
        this.allow_alcohol = allow_alcohol;
    }

    public String getStore_id ()
    {
        return store_id;
    }

    public void setStore_id (String store_id)
    {
        this.store_id = store_id;
    }

    public String getShop_price ()
    {
        return shop_price;
    }

    public void setShop_price (String shop_price)
    {
        this.shop_price = shop_price;
    }

    public String getLead_time_cutoff_rule_id ()
    {
        return lead_time_cutoff_rule_id;
    }

    public void setLead_time_cutoff_rule_id (String lead_time_cutoff_rule_id)
    {
        this.lead_time_cutoff_rule_id = lead_time_cutoff_rule_id;
    }

    public String getShop_fee_plu ()
    {
        return shop_fee_plu;
    }

    public void setShop_fee_plu (String shop_fee_plu)
    {
        this.shop_fee_plu = shop_fee_plu;
    }

    public String[] getPostal_codes ()
    {
        return postal_codes;
    }

    public void setPostal_codes (String[] postal_codes)
    {
        this.postal_codes = postal_codes;
    }

    public String getCutoff_delta ()
    {
        return cutoff_delta;
    }

    public void setCutoff_delta (String cutoff_delta)
    {
        this.cutoff_delta = cutoff_delta;
    }

    public String getFrom_time ()
    {
        return from_time;
    }

    public void setFrom_time (String from_time)
    {
        this.from_time = from_time;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getDelivery_fee_plu ()
    {
        return delivery_fee_plu;
    }

    public void setDelivery_fee_plu (String delivery_fee_plu)
    {
        this.delivery_fee_plu = delivery_fee_plu;
    }

    public String getFulfillment_type ()
    {
        return fulfillment_type;
    }

    public void setFulfillment_type (String fulfillment_type)
    {
        this.fulfillment_type = fulfillment_type;
    }

    public String getPlu_rule_id ()
    {
        return plu_rule_id;
    }

    public void setPlu_rule_id (String plu_rule_id)
    {
        this.plu_rule_id = plu_rule_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTo_time ()
    {
        return to_time;
    }

    public void setTo_time (String to_time)
    {
        this.to_time = to_time;
    }

    public String getDay_of_week ()
    {
        return day_of_week;
    }

    public void setDay_of_week (String day_of_week)
    {
        this.day_of_week = day_of_week;
    }

    public String getDelivery_price ()
    {
        return delivery_price;
    }

    public void setDelivery_price (String delivery_price)
    {
        this.delivery_price = delivery_price;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allow_alcohol = "+allow_alcohol+", store_id = "+store_id+", shop_price = "+shop_price+", lead_time_cutoff_rule_id = "+lead_time_cutoff_rule_id+", shop_fee_plu = "+shop_fee_plu+", postal_codes = "+postal_codes+", cutoff_delta = "+cutoff_delta+", from_time = "+from_time+", capacity = "+capacity+", delivery_fee_plu = "+delivery_fee_plu+", fulfillment_type = "+fulfillment_type+", plu_rule_id = "+plu_rule_id+", id = "+id+", to_time = "+to_time+", day_of_week = "+day_of_week+", delivery_price = "+delivery_price+"]";
    }
}
