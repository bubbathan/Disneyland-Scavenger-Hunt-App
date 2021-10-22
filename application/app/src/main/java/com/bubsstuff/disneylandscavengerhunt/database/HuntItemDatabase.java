package com.bubsstuff.disneylandscavengerhunt.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;

@Database(entities = {HuntItem.class}, version = 1)
public abstract class HuntItemDatabase extends RoomDatabase {
    public abstract HuntItemDao getHuntItemDao();
}
