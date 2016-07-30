package com.example.okhttpvolleygson.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.okhttpvolleygson.viewHolders.ViewHolderImage;
import com.sottocorp.okhttpvolleygson.R;

import java.util.List;

public class NetworkImageRecyclerViewAdapter extends RecyclerView.Adapter
{
    private final List<String> mImages;

    public NetworkImageRecyclerViewAdapter(@NonNull final List<String> images)
    {
        mImages = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.network_image_view_vh, parent, false);

        return new ViewHolderImage(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        final ViewHolderImage viewHolderImage =
                (ViewHolderImage) holder;

        viewHolderImage.onBind(mImages.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mImages.size();
    }
}
