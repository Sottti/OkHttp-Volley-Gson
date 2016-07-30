package com.example.okhttpvolleygson.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.okhttpvolleygson.base.App;
import com.sottocorp.okhttpvolleygson.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Demonstrates how to load images using {@link ImageRequest}
 */
public class ImageRequestActivity extends AppCompatActivity
{
    private final static String sIMAGE_URL = "https://goo.gl/XOXAXG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_request);
        init();
    }

    private void init()
    {
        setUpToolbar();
        final CircleImageView circleImageView =
                (CircleImageView) findViewById(R.id.circularImageView);
        performRequest(circleImageView);
    }

    private void performRequest(final CircleImageView circleImageView)
    {
        // Retrieves an image specified by the URL, displays it in the UI.
        // In this example the image is NOT resized.
        final ImageRequest imageRequest =
                new ImageRequest
                (
                        sIMAGE_URL,
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
                            {          circleImageView.setImageResource(R.drawable.image_cloud_sad);
                            }
                        }
                );
        // Access the RequestQueue through your singleton class.
        App.getInstance().getVolleyRequestQueue().add(imageRequest);
    }

    private void setUpToolbar()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
