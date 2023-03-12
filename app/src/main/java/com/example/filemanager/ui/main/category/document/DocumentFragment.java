package com.example.filemanager.ui.main.category.document;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentDocumentBinding;
import com.example.filemanager.model.Document;
import com.example.filemanager.ui.adapter.recycler.DocumentAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class DocumentFragment extends BaseBindingFragment<FragmentDocumentBinding, DocumentViewModel> {
    private final List<Document> listDocument = new LinkedList<>();
    private DocumentAdapter documentAdapter;

    @Override
    protected Class<DocumentViewModel> getViewModel() {
        return DocumentViewModel.class;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_document;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }

    public void initAdapter() {
        documentAdapter = new DocumentAdapter();
        binding.listDocument.setAdapter(documentAdapter);
    }

    public void initData() {
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDocument.add(new Document("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        documentAdapter.setListDocument(listDocument);

    }
}
