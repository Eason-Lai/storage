package com.example.liyixun.storage;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bmob.v3.Bmob;

public class Fragment_storage extends Fragment {
    private List<Gallery> galleryList = new ArrayList<>();
    public Fragment_storage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage,container,false);
         loadGallery();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        GalleryAdapter adapter = new GalleryAdapter(galleryList);
        recyclerView.setAdapter(adapter);

        //悬浮按钮点击
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"FAB",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this.getContext(),"03de14ff4bda451ee3108a1070c21129");
    }

    private void loadGallery() {
        for (int i=1; i<=50; i++) {
            Gallery p = new Gallery(getRandomLengthName("测试"+i),R.drawable.ic_storage);
            galleryList.add(p);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    /*private void loadGallery() {
        for (int i=1; i<=50; i++) {
            Gallery p = new Gallery("测试"+i,R.drawable.ic_storage);
            galleryList.add(p);
        }
    }*/

}
/*public class Fragment_storage extends Fragment {
    private List<Gallery> galleryList = new ArrayList<>();
    public Fragment_storage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage,container,false);
        loadGallery();
        GalleryAdapter adapter = new GalleryAdapter(this.getContext(),R.layout.gallery_item,galleryList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this.getContext(),"03de14ff4bda451ee3108a1070c21129");
    }

    private void loadGallery() {
        for (int i=1; i<=50; i++) {
            Gallery p = new Gallery("测试"+i,R.drawable.ic_storage);
            galleryList.add(p);
        }
    }

}*/
