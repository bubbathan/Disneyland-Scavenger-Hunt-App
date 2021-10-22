package com.bubsstuff.disneylandscavengerhunt.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;

import java.util.List;

@Dao
public interface HuntItemDao {

    @Query("SELECT * FROM huntitem")
    public List<HuntItem> getAll();

    @Query("SELECT * FROM huntitem WHERE land = :land")
    public List<HuntItem> findByLand(String land);

    @Query("SELECT * FROM huntitem WHERE item_found = 1")
    public List<HuntItem> findFoundItems();

    @Insert
    public long insert(HuntItem huntItem);

    @Update
    public void update(HuntItem huntItem);

    @Delete
    public void delete(HuntItem huntItem);

}
