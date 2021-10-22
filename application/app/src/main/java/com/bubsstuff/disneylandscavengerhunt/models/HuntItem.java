package com.bubsstuff.disneylandscavengerhunt.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HuntItem {
    @PrimaryKey()
    public long id;

    @ColumnInfo(name = "hunt_item")
    public String huntItem;

    @ColumnInfo(name = "land")
    public String land;

    @ColumnInfo(name = "item_found")
    public int itemFound;

    @ColumnInfo(name = "image")
    public String image;

}
