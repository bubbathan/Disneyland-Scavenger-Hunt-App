package com.bubsstuff.disneylandscavengerhunt.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bubsstuff.disneylandscavengerhunt.R;
import com.bubsstuff.disneylandscavengerhunt.adapters.ScavengerHuntAdapter;
import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;
import com.bubsstuff.disneylandscavengerhunt.viewmodels.HuntItemViewModel;

import org.w3c.dom.Text;

public class FrontierLandFragment extends Fragment {
    HuntItemViewModel viewModel;

    public FrontierLandFragment() {
        super(R.layout.fragment_frontier_land);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(HuntItemViewModel.class);

        ScavengerHuntAdapter adapter = new ScavengerHuntAdapter(
                getActivity(),
                viewModel.getLandHuntItems("Frontierland"),
                (huntItem) -> {
                    viewModel.setCurrentHuntItem(huntItem);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, CheckItOutFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                });

        viewModel.getHuntItems().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<HuntItem>>() {
            @Override
            public void onChanged(ObservableList<HuntItem> sender) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onItemRangeChanged(ObservableList<HuntItem> sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeChanged(positionStart, itemCount);
                });
            }

            @Override
            public void onItemRangeInserted(ObservableList<HuntItem> sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeInserted(positionStart, itemCount);
                });
            }

            @Override
            public void onItemRangeMoved(ObservableList<HuntItem> sender, int fromPosition, int toPosition, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemMoved(fromPosition, toPosition);
                });
            }

            @Override
            public void onItemRangeRemoved(ObservableList<HuntItem> sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeRemoved(positionStart, itemCount);
                });
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.frontier_hunt_items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}