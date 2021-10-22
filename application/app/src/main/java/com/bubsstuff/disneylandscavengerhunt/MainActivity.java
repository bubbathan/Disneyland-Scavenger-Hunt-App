package com.bubsstuff.disneylandscavengerhunt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;

import com.bubsstuff.disneylandscavengerhunt.fragments.AdventureLandFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.CaAdventureFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.CharactersFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.FantasyLandFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.FrontierLandFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.MainMenuFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.TomorrowLandFragment;
import com.bubsstuff.disneylandscavengerhunt.fragments.ToonTownFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, MainMenuFragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView drawer = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });

        drawer.setNavigationItemSelectedListener(menuItem -> {
            menuItem.isChecked();
            drawerLayout.closeDrawer(Gravity.LEFT);

            if (menuItem.getItemId() == R.id.home_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, MainMenuFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            if (menuItem.getItemId() == R.id.fantasy_land) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, FantasyLandFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.toontown) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, ToonTownFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.tomorrow_land) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, TomorrowLandFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.frontier_land) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, FrontierLandFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.adventure_land) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, AdventureLandFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.california_adventure) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, CaAdventureFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.characters) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, CharactersFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            return false;
        });
    }
}