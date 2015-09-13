package com.sottocorp.okhttpvolleygson.activities;

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
import com.sottocorp.okhttpvolleygson.R;
import com.sottocorp.okhttpvolleygson.base.App;
import com.sottocorp.okhttpvolleygson.dataModel.DummyObject;
import com.sottocorp.okhttpvolleygson.network.ApiRequests;
import com.sottocorp.okhttpvolleygson.network.GsonGetRequest;

/**
 * Demonstrates how to make a JSON Object request
 */
public class JSONObjectActivity extends AppCompatActivity
{
    private static final String sTag = "tagOne";

    private TextView mTitle, mBody;
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_object_request);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);

        final GsonGetRequest<DummyObject> gsonGetRequest =
                ApiRequests.getDummyObject
                        (
                                new Response.Listener<DummyObject>() {
                                    @Override
                                    public void onResponse(DummyObject dummyObject) {
                                        // Deal with the DummyObject here
                                        mProgressBar.setVisibility(View.GONE);
                                        mContent.setVisibility(View.VISIBLE);
                                        setData(dummyObject);
                                    }
                                }
                                ,
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // Deal with the error here
                                        mProgressBar.setVisibility(View.GONE);
                                        mErrorView.setVisibility(View.VISIBLE);
                                    }
                                }
                        );

        App.addRequest(gsonGetRequest, sTag);
    }

    @Override
    protected void onStop()
    {
        App.cancelAllRequests(sTag);

        super.onStop();
    }

    /**
     * Sets the data in the UI
     *
     * @param dummyObject is the object to get the data from
     */
    private void setData(@NonNull final DummyObject dummyObject)
    {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }
}
