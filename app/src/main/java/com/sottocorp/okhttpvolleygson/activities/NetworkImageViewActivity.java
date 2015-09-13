package com.sottocorp.okhttpvolleygson.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sottocorp.okhttpvolleygson.R;
import com.sottocorp.okhttpvolleygson.adapters.NetworkImageRecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates how to load images using {@link com.android.volley.toolbox.NetworkImageView}
 */
public class NetworkImageViewActivity extends AppCompatActivity
{
    private final static List<String> sImages = Arrays.asList
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
        setContentView(R.layout.network_image_view);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NetworkImageRecyclerViewAdapter(sImages));
    }
}