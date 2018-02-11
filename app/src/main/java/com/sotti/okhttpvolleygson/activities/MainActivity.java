package com.sotti.okhttpvolleygson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.sotti.okhttpvolleygson.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button mJSONObjectSample, mJSONArraySample,
      mNetworkImageViewSample, mImageRequestSample;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    init();
  }

  private void init() {
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    mJSONArraySample = findViewById(R.id.button_json_array);
    mJSONObjectSample = findViewById(R.id.button_json_object);
    mImageRequestSample = findViewById(R.id.button_image_request);
    mNetworkImageViewSample = findViewById(R.id.button_network_image_view);

    mJSONArraySample.setOnClickListener(this);
    mJSONObjectSample.setOnClickListener(this);
    mImageRequestSample.setOnClickListener(this);
    mNetworkImageViewSample.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    if (view == mJSONObjectSample) {
      startActivity(new Intent(this, JsonObjectActivity.class));
    } else if (view == mJSONArraySample) {
      startActivity(new Intent(this, JsonArrayActivity.class));
    } else if (view == mNetworkImageViewSample) {
      startActivity(new Intent(this, NetworkImageViewActivity.class));
    } else if (view == mImageRequestSample) {
      startActivity(new Intent(this, ImageRequestActivity.class));
    }
  }
}
