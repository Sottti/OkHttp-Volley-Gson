package com.sottocorp.sotti.okhttpvolleygsonsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sottocorp.sotti.okhttpvolleygsonsample.R;
import com.sottocorp.sotti.okhttpvolleygsonsample.adapters.ImageLoadingARecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates how to load images
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 */
public class ImageLoading extends AppCompatActivity
{
    private final static List<String> mImages = Arrays.asList
    (
            "https://lh3.googleusercontent.com/X7LeBu-pcZT072M2mtywDQWCKuqTMjdCWrrAaofQI7_6=w950-h713-no",
            "https://lh3.googleusercontent.com/srl6bOcG8KT0SdlEtkgxvGJOjKh22kWLBLrS25McOUsm=w950-h713-no",
            "https://lh3.googleusercontent.com/uOZbJGuX8Ut5j-Yw2IfzaCe30rdrbD93fmZI1bRLRHR7=w950-h706-no",
            "https://lh3.googleusercontent.com/X2g2LKEruoxITTE1hXG5Lp3tJALhptCDp0gKZ932SWwt=w950-h713-no",
            "https://lh3.googleusercontent.com/EuGPCu0gYpWneIYHFayUDcNK7qrifvWwIYYoFMFu6TP3=w950-h713-no",
            "https://lh3.googleusercontent.com/7QQGcjlShMdu7sXchzLUexsA8BScXnOe82baYOysAZmk=w950-h713-no",
            "https://lh3.googleusercontent.com/5H2ql2TAP0dw_U2kNEP9__nbyBrbvX9Lek0qW3i2K-rF=w950-h713-no",
            "https://lh3.googleusercontent.com/6iA-Q8DyXPOIASEJWMBU1szFzd9isijp5HbDhB17-Q-O=w950-h713-no"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_loading);

        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ImageLoadingARecyclerViewAdapter(mImages));
    }
}