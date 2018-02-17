package com.sotti.okhttpvolleygson.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.sotti.okhttpvolleygson.R;
import com.sotti.okhttpvolleygson.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final MainActivityBinding viewBinding = DataBindingUtil
        .setContentView(this, R.layout.main_activity);
    viewBinding.setClickHandler(new MainActivityClickHandler());
    setSupportActionBar(viewBinding.includeToolbar.toolbar);
  }

  public class MainActivityClickHandler {

    public void onJsonObjectButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), JsonObjectActivity.class));
    }

    public void onJsonArrayButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), JsonArrayActivity.class));
    }

    public void onNetworkImageViewButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), NetworkImageViewActivity.class));
    }

    public void onImageRequestButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), ImageRequestActivity.class));
    }
  }
}
