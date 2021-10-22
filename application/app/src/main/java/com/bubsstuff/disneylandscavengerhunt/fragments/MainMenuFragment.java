package com.bubsstuff.disneylandscavengerhunt.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bubsstuff.disneylandscavengerhunt.R;
import com.google.android.material.button.MaterialButton;

public class MainMenuFragment extends Fragment {
    public MainMenuFragment() {
        super(R.layout.fragment_main_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton fantasylandButton = view.findViewById(R.id.fantasy_land_button);
        fantasylandButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, FantasyLandFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton toontownButton = view.findViewById(R.id.toontown_button);
        toontownButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, ToonTownFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton tomorrowlandButton = view.findViewById(R.id.tomorrowland_button);
        tomorrowlandButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, TomorrowLandFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton frontierlandButton = view.findViewById(R.id.frontierland_button);
        frontierlandButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, FrontierLandFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton adventurelandButton = view.findViewById(R.id.adventureland_button);
        adventurelandButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, AdventureLandFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton caAdventureButton = view.findViewById(R.id.california_adventure_button);
        caAdventureButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, CaAdventureFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton charactersButton = view.findViewById(R.id.characters_button);
        charactersButton.setOnClickListener(button -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, CharactersFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
    }
}