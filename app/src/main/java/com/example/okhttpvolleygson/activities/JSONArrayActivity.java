package com.example.okhttpvolleygson.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.okhttpvolleygson.base.App;
import com.example.okhttpvolleygson.dataModel.DummyObject;
import com.example.okhttpvolleygson.network.ApiRequests;
import com.example.okhttpvolleygson.network.GsonGetRequest;
import com.sottocorp.okhttpvolleygson.R;

import java.util.ArrayList;

public class JsonArrayActivity extends AppCompatActivity
{
    private static final String sTAG = "tagTwo";

    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;
    private TextView mTitle, mBody, mSecondTitle, mSecondBody;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_array_request_activity);
        init();
    }

    private void init()
    {
        setUpToolbar();
        bindResources();
        performRequest();
    }

    private void setUpToolbar()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void bindResources()
    {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mSecondTitle = (TextView) findViewById(R.id.my_title_2);
        mSecondBody = (TextView) findViewById(R.id.my_body_2);
        mSecondBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    private void performRequest()
    {
        final GsonGetRequest<ArrayList<DummyObject>> gsonGetRequest =
                ApiRequests.getDummyObjectArray
                        (
                                new Response.Listener<ArrayList<DummyObject>>()
                                {
                                    @Override
                                    public void onResponse(ArrayList<DummyObject> dummyObjectArrayList)
                                    {
                                        // Deal with the DummyObject here
                                        onApiResponse(dummyObjectArrayList);
                                    }
                                }
                                ,
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        // Deal with the error here
                                        onApiError();
                                    }
                                }
                        );

        App.addRequest(gsonGetRequest, sTAG);
    }

    private void onApiResponse(@NonNull final ArrayList<DummyObject> dummyObjectArrayList)
    {
        mProgressBar.setVisibility(View.GONE);
        mContent.setVisibility(View.VISIBLE);
        setData(dummyObjectArrayList);
    }

    private void onApiError()
    {
        mProgressBar.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    private void setData(@NonNull final ArrayList<DummyObject> dummyObjectArrayList)
    {
        mTitle.setText(dummyObjectArrayList.get(0).getTitle());
        mBody.setText(dummyObjectArrayList.get(0).getBody());
        mSecondTitle.setText(dummyObjectArrayList.get(1).getTitle());
        mSecondBody.setText(dummyObjectArrayList.get(1).getBody());
    }

    @Override
    protected void onStop()
    {
        App.cancelAllRequests(sTAG);

        super.onStop();
    }
}
