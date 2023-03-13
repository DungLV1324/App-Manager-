package com.example.filemanager.ui.main.main.favourite;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentFavouriteBinding;
import com.example.filemanager.model.Favorrite;
import com.example.filemanager.model.Recent;
import com.example.filemanager.ui.adapter.recycler.FavoriteAdapter;
import com.example.filemanager.ui.adapter.recycler.RecentAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class FavouriteFragment extends BaseBindingFragment<FragmentFavouriteBinding, FavouriteViewModel> {

    private final List<Favorrite> listItemFavorite = new LinkedList<>();
    private FavoriteAdapter favoriteAdapter;
    @Override
    protected Class<FavouriteViewModel> getViewModel() {
        return FavouriteViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favourite;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();


    }

    public void initAdapter() {
        favoriteAdapter = new FavoriteAdapter();
        binding.rcFavorite.setAdapter(favoriteAdapter);
    }
    public void initData() {
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        listItemFavorite.add(new Favorrite("The Batman.mp4"));
        favoriteAdapter.setListItemFavorite(listItemFavorite);

    }
}
