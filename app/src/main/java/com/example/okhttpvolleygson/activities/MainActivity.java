package com.example.okhttpvolleygson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sottocorp.okhttpvolleygson.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mJSONObjectSample, mJSONArraySample,
            mNetworkImageViewSample, mImageRequestSample;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
    }

    private void init()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mJSONObjectSample = (Button) findViewById(R.id.button_json_object);
        mJSONArraySample = (Button) findViewById(R.id.button_json_array);
        mNetworkImageViewSample = (Button) findViewById(R.id.button_network_image_view);
        mImageRequestSample = (Button) findViewById(R.id.button_image_request);

        mJSONObjectSample.setOnClickListener(this);
        mJSONArraySample.setOnClickListener(this);
        mNetworkImageViewSample.setOnClickListener(this);
        mImageRequestSample.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == mJSONObjectSample)
        {
            startActivity(new Intent(this, JsonObjectActivity.class));
        }
        else if (view == mJSONArraySample)
        {
            startActivity(new Intent(this, JsonArrayActivity.class));
        }
        else if (view == mNetworkImageViewSample)
        {
            startActivity(new Intent(this, NetworkImageViewActivity.class));
        }
        else if (view == mImageRequestSample)
        {
            startActivity(new Intent(this, ImageRequestActivity.class));
        }
    }
}
