package com.sotti.okhttpvolleygson.activities;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.sotti.okhttpvolleygson.R;
import com.sotti.okhttpvolleygson.base.App;
import com.sotti.okhttpvolleygson.databinding.ImageRequestBinding;

public class ImageRequestActivity extends AppCompatActivity {

  private final static String sIMAGE_URL = "https://goo.gl/XOXAXG";
  private ImageRequestBinding mViewBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.image_request);
    setUpToolbar();
    performRequest();
  }

  private void setUpToolbar() {
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  private void performRequest() {
    final ImageRequest imageRequest =
        new ImageRequest
            (
                sIMAGE_URL,
                new Response.Listener<Bitmap>() {
                  @Override
                  public void onResponse(Bitmap bitmap) {
                    mViewBinding.image.setImageBitmap(bitmap);
                  }
                },
                0,
                0,
                ImageView.ScaleType.CENTER_INSIDE,
                Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                  public void onErrorResponse(VolleyError error) {
                    mViewBinding.image.setImageResource(R.drawable.image_cloud_sad);
                  }
                }
            );

    App.addRequest(imageRequest, sIMAGE_URL);
  }

  @Override
  protected void onStop() {
    App.cancelAllRequests(sIMAGE_URL);
    super.onStop();
  }
}
