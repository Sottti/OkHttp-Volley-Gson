package com.sotti.okhttpvolleygson.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sotti.okhttpvolleygson.R;
import com.sotti.okhttpvolleygson.base.App;
import com.sotti.okhttpvolleygson.dataModel.DummyObject;
import com.sotti.okhttpvolleygson.databinding.JsonObjectRequestActivityBinding;
import com.sotti.okhttpvolleygson.network.ApiRequests;
import com.sotti.okhttpvolleygson.network.GsonGetRequest;

public class JsonObjectActivity extends AppCompatActivity {

  private static final String sTAG = "tagOne";
  JsonObjectRequestActivityBinding mViewBinding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.json_object_request_activity);
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
    final GsonGetRequest<DummyObject> gsonGetRequest =
        ApiRequests.getDummyObject
            (
                new Response.Listener<DummyObject>() {
                  @Override
                  public void onResponse(DummyObject dummyObject) {
                    // Deal with the DummyObject here
                    onApiResponse(dummyObject);
                  }
                }
                ,
                new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                    // Deal with the error here
                    onApiError();
                  }
                }
            );
    App.addRequest(gsonGetRequest, sTAG);
  }

  private void onApiResponse(final DummyObject dummyObject) {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.VISIBLE);
    setData(dummyObject);
  }

  private void onApiError() {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.VISIBLE);
  }

  private void setData(@NonNull final DummyObject dummyObject) {
    mViewBinding.myTitle.setText(dummyObject.getTitle());
    mViewBinding.myBody.setText(dummyObject.getBody());
  }

  @Override
  protected void onStop() {
    App.cancelAllRequests(sTAG);
    super.onStop();
  }
}
