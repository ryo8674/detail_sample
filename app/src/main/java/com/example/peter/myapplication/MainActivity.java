package com.example.peter.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ThumbnailRecyclerAdapter.OnThumbnailTapListener, ViewPager.OnPageChangeListener {

    private ViewPager pager;
    private RecyclerView recyclerView;
    private PhotoPagerAdapter adapter;
    private ThumbnailRecyclerAdapter thumbnailRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.view_pager);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        adapter = new PhotoPagerAdapter(getSupportFragmentManager(), createPhotoList());
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(this);

        thumbnailRecyclerAdapter = new ThumbnailRecyclerAdapter(createPhotoList(), this);
        recyclerView.setAdapter(thumbnailRecyclerAdapter);
    }

    private List<Integer> createPhotoList(){
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.photo01);
        list.add(R.drawable.photo02);
        list.add(R.drawable.photo03);
        list.add(R.drawable.photo04);
        list.add(R.drawable.photo05);
        list.add(R.drawable.photo06);
        list.add(R.drawable.photo07);
        list.add(R.drawable.photo08);
        list.add(R.drawable.photo01);
        list.add(R.drawable.photo02);
        list.add(R.drawable.photo03);
        list.add(R.drawable.photo04);
        list.add(R.drawable.photo05);
        list.add(R.drawable.photo06);
        list.add(R.drawable.photo07);
        list.add(R.drawable.photo08);
        return list;
    }

    @Override
    public void onTap(int position) {
        recyclerView.scrollToPosition(position);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        manager.scrollToPositionWithOffset(position, 0);
        recyclerView.setLayoutManager(manager);
        pager.setCurrentItem(position, true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        onTap(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
