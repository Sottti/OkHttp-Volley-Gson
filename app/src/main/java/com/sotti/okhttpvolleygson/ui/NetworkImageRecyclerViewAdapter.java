package com.sotti.okhttpvolleygson.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sotti.okhttpvolleygson.databinding.NetworkImageViewVhBinding;
import java.util.List;

class NetworkImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageVH> {

  private final List<String> mImages;

  NetworkImageRecyclerViewAdapter(@NonNull final List<String> images) {
    mImages = images;
  }

  @Override
  public ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ImageVH(
        NetworkImageViewVhBinding.inflate(LayoutInflater.from(parent.getContext())));
  }

  @Override
  public void onBindViewHolder(ImageVH holder, int position) {
    holder.onBind(mImages.get(position));
  }

  @Override
  public int getItemCount() {
    return mImages.size();
  }
}
