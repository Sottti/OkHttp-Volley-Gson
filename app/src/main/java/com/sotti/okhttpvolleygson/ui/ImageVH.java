package com.sotti.okhttpvolleygson.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.sotti.okhttpvolleygson.App;
import com.sotti.okhttpvolleygson.R;
import com.sotti.okhttpvolleygson.databinding.NetworkImageViewVhBinding;

class ImageVH extends RecyclerView.ViewHolder {

  private final NetworkImageViewVhBinding mViewBinding;

  ImageVH(NetworkImageViewVhBinding viewBinding) {
    super(viewBinding.getRoot());
    mViewBinding = viewBinding;
    mViewBinding.networkImageView.setErrorImageResId(R.drawable.image_cloud_sad);
    mViewBinding.networkImageView.setDefaultImageResId(R.drawable.image_sun_smile);
  }

  void onBind(@NonNull final String imageUrl) {
    mViewBinding.networkImageView.setImageUrl(imageUrl, App.getInstance().getVolleyImageLoader());
  }
}
