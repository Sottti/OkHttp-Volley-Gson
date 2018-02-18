package com.sotti.okhttpvolleygson.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sotti.okhttpvolleygson.App;
import com.sotti.okhttpvolleygson.R;
import com.sotti.okhttpvolleygson.data.ApiRequests;
import com.sotti.okhttpvolleygson.data.GsonGetRequest;
import com.sotti.okhttpvolleygson.databinding.JsonObjectRequestActivityBinding;
import com.sotti.okhttpvolleygson.model.DummyObject;

public class JsonObjectActivity extends AppCompatActivity {

  private static final String sTAG = "tagOne";
  private JsonObjectRequestActivityBinding mViewBinding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.json_object_request_activity);
    setUpToolbar();
    performRequest();
  }

  private void setUpToolbar() {
    setSupportActionBar(mViewBinding.includeToolbar.toolbar);
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
                    onApiResponse(dummyObject);
                  }
                }
                ,
                new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
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
    mViewBinding.myTitle.setText(dummyObject.getTitle());
    mViewBinding.myBody.setText(dummyObject.getBody());
  }

  private void onApiError() {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.VISIBLE);
  }

  @Override
  protected void onStop() {
    App.cancelAllRequests(sTAG);
    super.onStop();
  }
}
