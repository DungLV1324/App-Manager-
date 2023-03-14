package com.example.filemanager.ui.main.category.zip;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentZipBinding;
import com.example.filemanager.model.Zip;

import com.example.filemanager.model.ZipThumb;
import com.example.filemanager.ui.adapter.recycler.ZipAdapter;
import com.example.filemanager.ui.adapter.recycler.ZipThumbAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class ZipFragment extends BaseBindingFragment<FragmentZipBinding, ZipViewModel> {
    private final List<Zip> listZip = new LinkedList<>();
    private final List<ZipThumb> listZipThumb = new LinkedList<>();
    boolean iSelect = false;

    private ZipAdapter zipAdapter;
    private ZipThumbAdapter zipThumbAdapter;

    @Override
    protected Class<ZipViewModel> getViewModel() {
        return ZipViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zip;
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
                binding.listZip.setVisibility(View.VISIBLE);
                binding.listZipThumb.setVisibility(View.INVISIBLE);

                if (iSelect){
                    iSelect = false;
                    binding.listZipThumb.setVisibility(View.INVISIBLE);
                    binding.listZip.setVisibility(View.VISIBLE);
                    binding.imMenu.setImageResource(R.drawable.list_soid);
                }else {
                    iSelect = true;
                    binding.listZipThumb.setVisibility(View.VISIBLE);
                    binding.listZip.setVisibility(View.INVISIBLE);
                    binding.imMenu.setImageResource(R.drawable.ic_menu);
                }
            }
        });

    }
    public void initAdapter() {
        zipAdapter = new ZipAdapter();
        binding.listZip.setAdapter(zipAdapter);
    }
    public void initData() {
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        zipAdapter.setListZip(listZip);

    }  public void initAdapterThumb() {
        zipThumbAdapter = new ZipThumbAdapter();
        binding.listZipThumb.setAdapter(zipThumbAdapter);
    }
    public void initDataThumb() {
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        listZipThumb.add(new ZipThumb("Backgroundcolorfuldobeautiful.png"));
        zipThumbAdapter.setListZipThumb(listZipThumb);

    }
}
