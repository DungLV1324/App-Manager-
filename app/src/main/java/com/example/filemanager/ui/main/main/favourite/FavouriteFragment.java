package com.example.filemanager.ui.main.main.favourite;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentFavouriteBinding;
import com.example.filemanager.model.FavoriteThumb;
import com.example.filemanager.model.Favorrite;
import com.example.filemanager.model.Recent;
import com.example.filemanager.ui.adapter.recycler.FavoriteAdapter;
import com.example.filemanager.ui.adapter.recycler.FavoriteThumbAdapter;
import com.example.filemanager.ui.adapter.recycler.RecentAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class FavouriteFragment extends BaseBindingFragment<FragmentFavouriteBinding, FavouriteViewModel> {
    private final List<FavoriteThumb> listItemThumb = new LinkedList<>();

    private final List<Favorrite> listItemFavorite = new LinkedList<>();
    private FavoriteAdapter favoriteAdapter;
    private FavoriteThumbAdapter favoriteThumbAdapter;
    boolean iSelect = false;
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
        initAdapterThumb();
        initDataThumb();


        binding.imMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imMenu.setImageResource(R.drawable.ic_menu);
                binding.rcFavorite.setVisibility(View.VISIBLE);
                binding.rcFavoriteThumb.setVisibility(View.INVISIBLE);


                if (iSelect){
                    iSelect = false;

                    binding.rcFavoriteThumb.setVisibility(View.INVISIBLE);
                    binding.rcFavorite.setVisibility(View.VISIBLE);
                    binding.imMenu.setImageResource(R.drawable.list_soid);

                }else {
                    iSelect = true;
                    binding.rcFavoriteThumb.setVisibility(View.VISIBLE);
                    binding.rcFavorite.setVisibility(View.INVISIBLE);
                    binding.imMenu.setImageResource(R.drawable.ic_menu);
                 }
            }
        });


    }

    public void initAdapter() {
        favoriteAdapter = new FavoriteAdapter();
        binding.rcFavorite.setAdapter(favoriteAdapter);
    }

    public void initData() {
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        listItemFavorite.add(new Favorrite("The Batman.mp4", "8/3/2023 10:00  CH 100KB"));
        favoriteAdapter.setListItemFavorite(listItemFavorite);

    }

    public void initAdapterThumb() {
        favoriteThumbAdapter = new FavoriteThumbAdapter();
        binding.rcFavoriteThumb.setAdapter(favoriteThumbAdapter);
    }

    public void initDataThumb() {
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        listItemThumb.add(new FavoriteThumb("The Batman.mp4"));
        favoriteThumbAdapter.setListItemThumb(listItemThumb);

    }
}
