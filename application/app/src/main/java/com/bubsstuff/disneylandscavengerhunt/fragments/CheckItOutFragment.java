package com.bubsstuff.disneylandscavengerhunt.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bubsstuff.disneylandscavengerhunt.R;
import com.bubsstuff.disneylandscavengerhunt.adapters.ScavengerHuntAdapter;
import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;
import com.bubsstuff.disneylandscavengerhunt.viewmodels.HuntItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CheckItOutFragment extends Fragment {
    HuntItemViewModel viewModel;

    public CheckItOutFragment() {
        super(R.layout.fragment_check_it_out);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(HuntItemViewModel.class);

        TextView numTimesFoundText = view.findViewById(R.id.number_of_times_found);
        numTimesFoundText.setText(Integer.toString(viewModel.getTimesFound()));

        ImageView itemImage = view.findViewById(R.id.check_it_out_image);
        String imageFileName = viewModel.getImage();
        int photoId = getResources().getIdentifier("@drawable/"
                + imageFileName, null, getActivity().getPackageName());
        itemImage.setImageResource(photoId);

        FloatingActionButton foundItButton = view.findViewById(R.id.found_it_fab);
        foundItButton.setOnClickListener(fab -> {
            viewModel.updateFound();
            Toast.makeText(getContext(),"Nice job!", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}