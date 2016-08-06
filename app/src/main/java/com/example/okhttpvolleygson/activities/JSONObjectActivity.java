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

public class JsonObjectActivity extends AppCompatActivity
{
    private static final String sTAG = "tagOne";

    private TextView mTitle, mBody;
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_object_request_activity);
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
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    private void performRequest()
    {
        final GsonGetRequest<DummyObject> gsonGetRequest =
                ApiRequests.getDummyObject
                        (
                                new Response.Listener<DummyObject>()
                                {
                                    @Override
                                    public void onResponse(DummyObject dummyObject)
                                    {
                                        // Deal with the DummyObject here
                                        onApiResponse(dummyObject);
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

    private void onApiResponse(final DummyObject dummyObject)
    {
        mProgressBar.setVisibility(View.GONE);
        mContent.setVisibility(View.VISIBLE);
        setData(dummyObject);
    }

    private void onApiError()
    {
        mProgressBar.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    private void setData(@NonNull final DummyObject dummyObject)
    {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }

    @Override
    protected void onStop()
    {
        App.cancelAllRequests(sTAG);
        super.onStop();
    }
}
