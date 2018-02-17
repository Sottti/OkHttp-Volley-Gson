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
import com.sotti.okhttpvolleygson.databinding.JsonArrayRequestActivityBinding;
import com.sotti.okhttpvolleygson.network.ApiRequests;
import com.sotti.okhttpvolleygson.network.GsonGetRequest;
import java.util.ArrayList;

public class JsonArrayActivity extends AppCompatActivity {

  private static final String sTAG = "tagTwo";
  private JsonArrayRequestActivityBinding mViewBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.json_array_request_activity);
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
    final GsonGetRequest<ArrayList<DummyObject>> gsonGetRequest =
        ApiRequests.getDummyObjectArray
            (
                new Response.Listener<ArrayList<DummyObject>>() {
                  @Override
                  public void onResponse(ArrayList<DummyObject> dummyObjectArrayList) {
                    // Deal with the DummyObject here
                    onApiResponse(dummyObjectArrayList);
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

  private void onApiResponse(@NonNull final ArrayList<DummyObject> dummyObjectArrayList) {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.VISIBLE);
    setData(dummyObjectArrayList);
  }

  private void onApiError() {
    mViewBinding.includeErrorView.setVisibility(View.VISIBLE);
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.GONE);
  }

  private void setData(@NonNull final ArrayList<DummyObject> dummyObjectArrayList) {
    mViewBinding.myTitle.setText(dummyObjectArrayList.get(0).getTitle());
    mViewBinding.myBody.setText(dummyObjectArrayList.get(0).getBody());
    mViewBinding.myTitle2.setText(dummyObjectArrayList.get(1).getTitle());
    mViewBinding.myBody2.setText(dummyObjectArrayList.get(1).getBody());
  }

  @Override
  protected void onStop() {
    App.cancelAllRequests(sTAG);
    super.onStop();
  }
}
