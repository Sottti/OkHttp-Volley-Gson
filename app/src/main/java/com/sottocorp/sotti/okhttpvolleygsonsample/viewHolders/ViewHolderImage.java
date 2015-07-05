package com.sottocorp.sotti.okhttpvolleygsonsample.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;
import com.sottocorp.sotti.okhttpvolleygsonsample.R;
import com.sottocorp.sotti.okhttpvolleygsonsample.base.App;

/**
 * View holder for a recycler view item holding an image
 *
 * @author @author https://plus.google.com/+PabloCostaTirado/about
 */
public class ViewHolderImage extends RecyclerView.ViewHolder
{
    private NetworkImageView mNetworkImageView;

    public ViewHolderImage(View itemView)
    {
        super(itemView);

        mNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.networkImageView);
        mNetworkImageView.setDefaultImageResId(R.drawable.ic_sun_smile);
        mNetworkImageView.setErrorImageResId(R.drawable.ic_cloud_sad);
    }

    /**
     * Sets the data in the view holder
     *
     * @param imageUrl is the image Url to get the image
     */
    public void setData(String imageUrl)
    {
        mNetworkImageView.setImageUrl(imageUrl, App.getInstance().getVolleyImageLoader());
    }
}
