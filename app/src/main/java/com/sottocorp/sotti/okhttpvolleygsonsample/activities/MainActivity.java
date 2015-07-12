package com.sottocorp.sotti.okhttpvolleygsonsample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sottocorp.sotti.okhttpvolleygsonsample.R;

/**
 * Launches the different samples
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mJSONObjectSample, mJSONArraySample, mNetworkImageView, mImageRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mJSONObjectSample = (Button) findViewById(R.id.json_object);
        mJSONArraySample = (Button) findViewById(R.id.json_array);
        mNetworkImageView = (Button) findViewById(R.id.network_image_view);
        mImageRequest = (Button) findViewById(R.id.image_request);

        mJSONObjectSample.setOnClickListener(this);
        mJSONArraySample.setOnClickListener(this);
        mNetworkImageView.setOnClickListener(this);
        mImageRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == mJSONObjectSample)
        {
            startActivity(new Intent(this, JSONObjectActivity.class));
        }
        else if (view == mJSONArraySample)
        {
            startActivity(new Intent(this, JSONArrayActivity.class));
        }
        else if (view == mNetworkImageView)
        {
            startActivity(new Intent(this, NetworkImageView.class));
        }
        else if (view == mImageRequest)
        {
            startActivity(new Intent(this, ImageRequestActivity.class));
        }
    }
}
