package com.sottocorp.sotti.okhttpvolleygsonsample.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.sottocorp.sotti.okhttpvolleygsonsample.R;
import com.sottocorp.sotti.okhttpvolleygsonsample.base.App;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Demonstrates how to load images using {@link com.android.volley.toolbox.ImageRequest}
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 */
public class ImageRequestActivity extends AppCompatActivity
{
    private final static String mImageUrl = "https://goo.gl/XOXAXG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_request);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        final CircleImageView circleImageView =
                (CircleImageView) findViewById(R.id.circularImageView);

        // Retrieves an image specified by the URL, displays it in the UI.
        final com.android.volley.toolbox.ImageRequest imageRequest =
                new ImageRequest
                (
                        mImageUrl,
                        new Response.Listener<Bitmap>()
                        {
                            @Override
                            public void onResponse(Bitmap bitmap)
                            {
                                circleImageView.setImageBitmap(bitmap);
                            }
                        },
                        0,
                        0,
                        ImageView.ScaleType.CENTER_INSIDE,
                        null,
                        new Response.ErrorListener()
                        {
                            public void onErrorResponse(VolleyError error)
                            {          circleImageView.setImageResource(R.drawable.ic_cloud_sad);
                            }
                        }
                );
        // Access the RequestQueue through your singleton class.
        App.getInstance().getVolleyRequestQueue().add(imageRequest);
    }
}
