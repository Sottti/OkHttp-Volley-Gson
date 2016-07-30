package com.example.okhttpvolleygson.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;
import com.example.okhttpvolleygson.base.App;
import com.sottocorp.okhttpvolleygson.R;

public class ViewHolderImage extends RecyclerView.ViewHolder
{
    private NetworkImageView mNetworkImageView;

    public ViewHolderImage(@NonNull final View itemView)
    {
        super(itemView);
        bindResources(itemView);
    }

    private void bindResources(final @NonNull View itemView)
    {
        mNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.networkImageView);
        mNetworkImageView.setDefaultImageResId(R.drawable.image_sun_smile);
        mNetworkImageView.setErrorImageResId(R.drawable.image_cloud_sad);
    }

    public void onBind(@NonNull final String imageUrl)
    {
        mNetworkImageView.setImageUrl(imageUrl, App.getInstance().getVolleyImageLoader());
    }
}
