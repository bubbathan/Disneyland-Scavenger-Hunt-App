package com.bubsstuff.disneylandscavengerhunt.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.bubsstuff.disneylandscavengerhunt.database.HuntItemDatabase;
import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;

public class HuntItemViewModel extends AndroidViewModel {
    ObservableArrayList<HuntItem> huntItems = new ObservableArrayList<>();
    HuntItemDatabase db;
    MutableLiveData<HuntItem> currentHuntItem = new MutableLiveData<>();
    MutableLiveData<Boolean> saving = new MutableLiveData<>();

    public HuntItemViewModel(@NonNull Application application) {
        super(application);
        saving.setValue(false);
        db = Room.databaseBuilder(application, HuntItemDatabase.class, "hunt-item-database")
                .createFromAsset("databases/ScavengerHuntItemsDB.db")
                .build();
        new Thread(() -> {
            huntItems.addAll(db.getHuntItemDao().getAll());
        }).start();
    }

    public MutableLiveData<Boolean> getSaving() {
        return saving;
    }

    public void setCurrentHuntItem(HuntItem huntItem) {
        currentHuntItem.postValue(huntItem);
    }

    public MutableLiveData<HuntItem> getCurrentHuntItem() {
        return currentHuntItem;
    }

    public ObservableArrayList<HuntItem> getHuntItems() {
        return huntItems;
    }

    public ObservableArrayList<HuntItem> getLandHuntItems(String land) {
        ObservableArrayList<HuntItem> landHuntItems = new ObservableArrayList<>();
        for (int i = 0; i < huntItems.size(); i++) {
            if (huntItems.get(i).land.equals(land)) {
                landHuntItems.add(huntItems.get(i));
            }
        }
        return landHuntItems;
    }

    public int getTimesFound() {
        return currentHuntItem.getValue().itemFound;
    }

    public void updateFound() {
        saving.setValue(true);
        new Thread(() -> {
            if (currentHuntItem.getValue() != null) {
                HuntItem current = currentHuntItem.getValue();
                current.itemFound = current.itemFound + 1;
                db.getHuntItemDao().update(current);
                setCurrentHuntItem(current);
            }
            saving.postValue(false);
        }).start();
    }

    public String getLand() {
        return currentHuntItem.getValue().land;
    }

    public String getImage() {
        return currentHuntItem.getValue().image;
    }
}
